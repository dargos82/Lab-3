
/**
 * 
 */
public class MinHeap {
	
	HuffmanNode[] heap;
	int size;
	int current;
	//int maxSize;
	
	public MinHeap() {
		
		heap = new HuffmanNode[27];
		heap[0] = null;
		this.size = 0;
		
	} //end MinHeap
	
	private int parent(int pos) {
		
		return pos / 2;
		
	}
	
	private int leftChild(int pos) {
		
		return (2 * pos);
		
	}
	
	private int rightChild(int pos) {
		
		return (2 * pos) + 1;
		
	} //end rightChild
	
	private boolean isLeaf(int pos) {
		
		if (pos > (size / 2))
			return true;
		
		else
			return false;
	} //end isLeaf
	
	private void swap(int lowerValue, int higherValue) {
		
		HuffmanNode temp;
		temp = heap[lowerValue];
		heap[lowerValue] = heap[higherValue];
		heap[higherValue] = temp;
		
	} //end swap
	
	public void insert(HuffmanNode node) {
		
		if (size >= 27)
			return;
		
		else
			size++;
			int current = size;
			heap[current] = node;
			
		if (current % 2 == 0) {
			while (heap[current].frequency < heap[parent(current)].frequency) {
							
				swap(current, parent(current));
				current = parent(current);
				
			} //end while
		} //end if
		
		else {
			while (heap[current].frequency < heap[parent(current-1)].frequency) {
				
				swap(current, parent(current-1));
				current = parent(current-1);
				
			} //end while
		} //end else
	} //end insert
	
	public HuffmanNode remove() {
		
		HuffmanNode minNode;
		HuffmanNode temp;
		
		minNode = heap[1]; //assign variable to node in [1]
		temp = heap[size]; //temp variable to hold node from [last]
		heap[1] = temp; //move last node to [1]
		heap[size] = null; //set [last] to null after removing node
		size--;

		//need to add heapify() here
		
		return minNode;
		
	} //end remove
	
	
} //end MinHeap
