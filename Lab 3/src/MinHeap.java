
/**
 * 
 * Reference: https://medium.com/@ankur.singh4012/implementing-min-heap-in-java-413d1c20f90d
 */
public class MinHeap {
	
	HuffmanNode[] heap;
	int size = 0;
	int current;
	//int maxSize;
	
	public MinHeap() {
		
		this.heap = new HuffmanNode[27];
		heap[0] = null;
		
	} //end MinHeap constructor
	
	private int getLeftChildIndex(int parentIndex) {
		return (parentIndex * 2);
	} //end getLeftChildIndex
	
	private int getRightChildIndex(int parentIndex) {
		return (parentIndex * 2) + 1;
	} //end getRightChldIndex
	
	private int getParentIndex(int childIndex) {
		return (childIndex / 2);
	} //end getParentIndex
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) <= size;
	} //end hasLeftChild
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) <= size;
	} //end hasRightChild
	
	private boolean hasParent(int index) {
		return getParentIndex(index) > 0;
	} //end hasParent
	
	private HuffmanNode leftChild(int parentIndex) {
		return heap[getLeftChildIndex(parentIndex)];
	} //end leftChild
	
	private HuffmanNode rightChild(int parentIndex) {
		return heap[getRightChildIndex(parentIndex)];
	} //end rightChild
	
	private HuffmanNode parent(int childIndex) {
		return heap[getParentIndex(childIndex)];
	} //end parent
	
	private void swap(int lowerIndex, int higherIndex) {
		
		HuffmanNode temp;
		temp = heap[lowerIndex];
		heap[lowerIndex] = heap[higherIndex];
		heap[higherIndex] = temp;
		
	} //end swap
	
	public void insert(HuffmanNode node) {
		
		size++;
		heap[size] = node;
		percolateUp();
		
		if(heap[2] != null && heap[3] != null) {
		
			if(compare(heap[2], heap[3])) {
				swap(2, 3);
			}
		}
	
	} //end insert
	
	//moves lower value node from larger index to smaller index in the array
	private void percolateUp() {
		
		int index = size;
		
		while(hasParent(index) && compare(heap[index], parent(index)) ) {
			
			swap(getParentIndex(index), index);
			index = getParentIndex(index);	
		}
		
		/*while (hasParent(index) && (parent(index).frequency > heap[index].frequency)) {
			swap(getParentIndex(index), index);
			
			index = getParentIndex(index);
			
		} //end while*/
	} //end percolateUp()
	
	public void minHeapify(int index) {
		
		int left = getLeftChildIndex(index);
		int right = getRightChildIndex(index);
		
		int smallest = index;
		
		if(left < size && (compare(leftChild(index), parent(index)))) {
			
			smallest = left;
		}
		
		if(right < size && (compare(rightChild(index), parent(index)))) {
			
			smallest = right;
		}
		
		if(smallest != index) {
			
			swap(index, smallest);
			minHeapify(smallest);
		}
		
	} //end minHeapify
	
	private boolean compare(HuffmanNode firstNode, HuffmanNode secondNode) {
		
		while(secondNode != null) {
		
			if(firstNode.frequency < secondNode.frequency) {
				
				return true;
			}
			
			else if(firstNode.frequency == secondNode.frequency && 
					firstNode.value.length() > secondNode.value.length()) {
			
				return true;
				
			}
			
			else if (firstNode.frequency == secondNode.frequency && 
					firstNode.value.charAt(0) < secondNode.value.charAt(0)) {
			
				return true;
				
			}
			
			else
				return false;
				
		}
		
		return true;
	}
	
	public HuffmanNode remove() {
		
		HuffmanNode minNode;
		
		minNode = heap[1]; //assign variable to node in [1]
		heap[1] = heap[size]; //move last node to [1]
		heap[size] = null; //set [last] to null after removing node
		size--; //decrement size by 1
		
		//percolateDown();
		minHeapify(1);
		
		return minNode;
		
	} //end remove
	
	//moves higher value node from smaller index to larger index in the array
	private void percolateDown() {
		
		int index = 1;
		
		while(hasLeftChild(index)) {
			
			//int smallestChildIndex = getLeftChildIndex(index);
			int smallestChildIndex = getLeftChildIndex(index);
			
			//if (hasRightChild(index) && rightChild(index).frequency < leftChild(index).frequency) {
			if (hasRightChild(index) && (rightChild(index).frequency > leftChild(index).frequency)) {	
				
				swap(getRightChildIndex(index), getLeftChildIndex(index));
				
				smallestChildIndex = getLeftChildIndex(index);
				
				//smallestChildIndex = getRightChildIndex(index);
			} //end if
		
			if(heap[index].frequency < heap[smallestChildIndex].frequency)
				break;
			else
				swap(index, smallestChildIndex);
			
			index = smallestChildIndex;
			
		} //end while

	} //end percolateDown()
	
	public void printMinHeap() {
		
		for(int i=1; i <= size; i++) {
		
		System.out.println(heap[i].toString());
		} //end for
	} //end printMinHeap
		
} //end MinHeap
