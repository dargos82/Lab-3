/**
 * 
 */

/**
 * 
 */
public class HuffmanNode {
	
	public String value;
	public int frequency;
	public HuffmanNode rightChild;
	public HuffmanNode leftChild;
	
	public HuffmanNode(String value, int frequency) {
		
		this.value = value;
		this.frequency = frequency;
		this.rightChild = null;
		this.leftChild = null;		
	} //end HuffmanNode()
		
}
