import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */
public class HuffmanCompression {
	
	public HuffmanCompression(String freqTableFile, String plainTextFile, 
			String codedFile) {
		
		freqTable = freqTableFile;
		plainText = plainTextFile;
		codedText = codedFile;

	} //end HuffmanCompression
	
	public void huffmanProgram() throws NumberFormatException, IOException {
		
		HuffmanNode rootNode = buildHuffmanTree();
		
		System.out.println("The tree in preorder is: \n");
		printTree(rootNode);
		
		System.out.println("\n**********\n");
		
		System.out.println("The Huffman code is: \n");
		getHuffmanCodes(rootNode, "", "");
		
		System.out.println("\n**********\n");

		encodeHuffman(rootNode);
		
		System.out.println("\n**********\n");
		
		decodeHuffman(rootNode);
	}
		
	public HuffmanNode buildHuffmanTree() throws NumberFormatException, IOException {
		
		BufferedReader reader = null;
		String freqInput;
		String value;
		String frequencyStr;
		int frequency;
		MinHeap minHeap = new MinHeap();
		
		try {
			reader = new BufferedReader(new FileReader(freqTable));

		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file.");
		}
		
		//load heap from frequency table
		while((freqInput = reader.readLine()) != null) {
						
			String[] result = freqInput.split(" - "); //result[0] = letter, result[1] = freq
			value = result[0];
			frequencyStr = result[1];
			frequency = Integer.parseInt(frequencyStr);
			
			HuffmanNode node = new HuffmanNode(value, frequency); //create new node with value and frequency
			
			minHeap.insert(node); //insert node into min heap
			
		} //end while
		
		//minHeap.printMinHeap(); //testing/debugging only
		//System.out.println("\n******\n");
		
		reader.close();
		
		while(minHeap.size > 1) {
			
			HuffmanNode tempNode1 = new HuffmanNode();
			HuffmanNode tempNode2 = new HuffmanNode();
			HuffmanNode tempNode3 = new HuffmanNode();
			
			tempNode1 = null;
			tempNode2 = null;
			
			tempNode1 = minHeap.remove();
			tempNode2 = minHeap.remove();
			
			tempNode3.mergeNodes(tempNode1, tempNode2);
			minHeap.insert(tempNode3);
			
			//minHeap.printMinHeap(); //testing/debugging only
			//System.out.println("\n******\n");
			
		} //end while
		
		return minHeap.remove();
		
	} //end buildHuffmanTree
	
	public void getHuffmanCodes(HuffmanNode rootNode, String prefix, String output) throws IOException {
		
		
		if(rootNode == null) {
			return;
		}
		
		if(rootNode.isLeaf()) {
			output = prefix;
		}
		else {
			getHuffmanCodes(rootNode.leftChild, prefix + "0", output);
			getHuffmanCodes(rootNode.rightChild, prefix + "1", output);
		} //end else
		
		System.out.println(rootNode.getValue() + ":" + output); //testing

		//return rootNode.getValue() + ":" + output;	
	
	} //end getHuffmanCodes
	
	/**
	 * @param rootNode
	 * @throws IOException
	 */
	public void printTree(HuffmanNode rootNode) throws IOException {
		
			System.out.println(rootNode.toString()); //print root
			if(rootNode.leftChild != null)
				printTree(rootNode.leftChild);
			if(rootNode.rightChild != null)
				printTree(rootNode.rightChild);
		
	} //end printTree
	
	public void encodeHuffman(HuffmanNode rootNode) throws IOException {
		
		BufferedReader reader = null;
		String strInput;
		String strOutput = "";
		String searchStr = "";
		
		try {
			reader = new BufferedReader(new FileReader(plainText));

		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file.");
		}
		
		while((strInput = reader.readLine()) != null) {
			
			strInput = strInput.toUpperCase(); //convert all letters to uppercase
			strInput = strInput.replaceAll("\\p{Punct}", ""); //remove punctuation
			strInput = strInput.replaceAll(" ", ""); //remove whitespaces
			
			for(int i=0; i < strInput.length(); i++) {
				
				HuffmanNode searchNode = rootNode;
				//strOutput = "";
				
				searchStr = "" + strInput.charAt(i);
				
				while(!searchNode.isLeaf) {
					
					if(searchNode.leftChild != null && 
							searchNode.leftChild.value.contains(searchStr)) {
						
						searchNode = searchNode.leftChild;
						strOutput = strOutput + "0";
						
					} //end if
					
					else if (searchNode.rightChild != null && 
							searchNode.rightChild.value.contains(searchStr)) {
						
						searchNode = searchNode.rightChild;
						strOutput = strOutput + "1";
					} //end else if
					
				} //end while
				
			} //end for
			
			System.out.println("Input: " + strInput + "\n");
			System.out.println("Output: " + strOutput + "\n");
			
			strOutput = "";
			
		} //end while
		
		reader.close();
		
	} //end encodeHuffman
	
	public void decodeHuffman(HuffmanNode rootNode) throws IOException {
		BufferedReader reader = null;
		String strInput;
		String strOutput = "";
		//String searchStr = "";
		
		try {
			reader = new BufferedReader(new FileReader(codedText));

		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file.");
		}
		
		while((strInput = reader.readLine()) != null) {

			HuffmanNode searchNode = rootNode;
			
			for(int i=0; i < strInput.length(); i++) {
				
				char c = strInput.charAt(i);
				
				
				if(c == '0') {
					
					searchNode = searchNode.getLeftChild();
				} //end if
				
				else if(c == '1') {
					searchNode = searchNode.getRightChild();
				}
				
				if(searchNode.isLeaf()) {
					
					strOutput += searchNode.getValue();
					searchNode = rootNode;
				}
					
			} //end for
			
			System.out.println("Input: " + strInput + "\n");
			System.out.println("Output: " + strOutput + "\n");
				
		} //end while
			
			//System.out.println("Input: " + strInput + "\n");
			//System.out.println("Output: " + strOutput + "\n");
			
			strOutput = "";
			
			//return strOutput;
	} //end decodeHuffman


	private String freqTable;
	private String plainText;
	private String codedText;
	private String output;

}
