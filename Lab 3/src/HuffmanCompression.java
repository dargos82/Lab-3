import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
/**
 * 
 */
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */
public class HuffmanCompression {
	
	public HuffmanCompression(String freqTableFile, String plainTextFile, 
			String codedFile, String outputFile) {
		
		freqTable = freqTableFile;
		plainText = plainTextFile;
		codedText = codedFile;
		convertedOutput = outputFile;		
	} //end HuffmanCompression
		
	public HuffmanNode buildHuffmanTree() throws NumberFormatException, IOException {
		
		BufferedReader reader = null;
		//BufferedWriter writer = null;
		String freqInput;
		String value;
		String frequencyStr;
		int frequency;
		MinHeap minHeap = new MinHeap();
		
		try {
			reader = new BufferedReader(new FileReader(freqTable));
			//writer = new BufferedWriter(new FileWriter(convertedOutput));

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
		
		minHeap.printMinHeap(); //testing/debugging only
		System.out.println("\n******\n");
		
		reader.close();
		//writer.close();
		
		while(minHeap.size > 1) {
			
			HuffmanNode tempNode1 = new HuffmanNode();
			HuffmanNode tempNode2 = new HuffmanNode();
			HuffmanNode tempNode3 = new HuffmanNode();
			//HuffmanNode tempNode4 = new HuffmanNode();
			
			tempNode1 = null;
			tempNode2 = null;
			
			tempNode1 = minHeap.remove();
			tempNode2 = minHeap.remove();
			
			//tempNode4 = tempNode3.mergeNodes(tempNode1, tempNode2);
			tempNode3.mergeNodes(tempNode1, tempNode2);
			minHeap.insert(tempNode3);
			
			minHeap.printMinHeap(); //testing/debugging only
			System.out.println("\n******\n");
			
		} //end while
		
		return minHeap.remove();
		
	} //end buildHuffmanTree
	
	public String getHuffmanCodes(HuffmanNode rootNode, String prefix, String output) {

		prefix = "";
		output = "";
		
		if(rootNode.isLeaf) {
			output = prefix;
		}
		else
			getHuffmanCodes(rootNode.leftChild, prefix + "0", output);
			getHuffmanCodes(rootNode.rightChild, prefix + "1", output);
		
		return output;	
	} //end getHuffmanCodes


	private String freqTable;
	private String plainText;
	private String codedText;
	private String convertedOutput;

}
