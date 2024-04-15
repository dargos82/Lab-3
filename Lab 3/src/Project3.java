/**
 * 
 */

import java.io.IOException;

/**
 * 
 */
public class Project3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		if (args.length != 4) {
		    System.out.println("Invalid Number of Arguments");
		}

		HuffmanCompression hc = new HuffmanCompression( args[0], args[1], args[2], args[3] );
		
		HuffmanNode rootNode = hc.buildHuffmanTree();
		
		System.out.println("The Huffman code is: ");
		hc.getHuffmanCodes(rootNode, "", "");
		
		System.out.println("\n**********\n");
		
		System.out.println("The tree in preorder: ");
		hc.printTree(rootNode);
		
		hc.encodeHuffman(rootNode);
		
		
		
	} //end main

}// end Project3
