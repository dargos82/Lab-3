/**
 * 
 */

/**
 * 
 */
public class HuffmanCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HuffmanNode nodeA = new HuffmanNode("A", 10);
		HuffmanNode nodeB = new HuffmanNode("B", 2);
		HuffmanNode	nodeC = new HuffmanNode("C", 12);
		
		MinHeap heap = new MinHeap();
		heap.insert(nodeA);
		heap.insert(nodeB);
		heap.insert(nodeC);
		heap.printMinHeap();
		
		heap.remove();
		
		heap.printMinHeap();
		
		
		//heap.remove();
		
		//System.out.println(node.toString());

	}

}
