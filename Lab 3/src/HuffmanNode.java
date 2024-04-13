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
	
	public HuffmanNode(String value, int frequency, HuffmanNode leftChild, HuffmanNode rightChild) {
		
		this.value = value;
		this.frequency = frequency;
		this.leftChild = null;
		this.rightChild = null;
		
	} //end HuffmanNode()
		
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public HuffmanNode mergeNodes(HuffmanNode firstNode, HuffmanNode secondNode) {
		
		HuffmanNode newNode = new HuffmanNode(value, frequency, leftChild, rightChild);
		
		if(firstNode.value.charAt(0) < secondNode.value.charAt(0)) {
			
			this.value = firstNode.value + secondNode.value;
		} //end if
		
		else 
			this.value = secondNode.value + firstNode.value;
		
		this.frequency = firstNode.frequency + secondNode.frequency;
		
		this.rightChild = firstNode;
		this.leftChild = secondNode;
		
		return newNode;
		
	} //end mergeNodes()
		
}
