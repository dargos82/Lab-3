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
		this.leftChild = null;
		this.rightChild = null;
		
	} //end HuffmanNode()
	
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
	
	public String toString() {
		
		return "Value: " + this.value + " Frequency: " + this.frequency;
		
	}
	
	public HuffmanNode mergeNodes(HuffmanNode firstNode, HuffmanNode secondNode) {
		
		HuffmanNode newNode = new HuffmanNode(value, frequency, leftChild, rightChild);
		
		if(compareNodes(firstNode, secondNode))
			this.value = firstNode.value + secondNode.value;
		
		else 
			this.value = secondNode.value + firstNode.value;
		
		this.frequency = firstNode.frequency + secondNode.frequency;
		
		this.leftChild = firstNode;
		this.rightChild = secondNode;
		
		return newNode;
		
	} //end mergeNodes()
	
	private boolean compareNodes(HuffmanNode firstNode, HuffmanNode secondNode) {
		
		if(firstNode.frequency < secondNode.frequency)
			return true;
		else if(firstNode.value.length() < secondNode.value.length())
			return true;
		else if(firstNode.value.charAt(0) < secondNode.value.charAt(0))
			return true;
		else
			return false;
			
	} //end compareNodes
		
} //end HuffmanNode
