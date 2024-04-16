/**
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

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
		
		//open output file and adjust print stream to output file
		BufferedWriter outputData = null;
		PrintStream printStream = null;
		
		try {
			outputData = new BufferedWriter(new FileWriter(args[3]));

		} catch (FileNotFoundException e) {
			System.out.println("Error locating the file.");
		}

		printStream = new PrintStream(new FileOutputStream(args[3]));
		System.setOut(printStream);

		HuffmanCompression hc = new HuffmanCompression( args[0], args[1], args[2]);
		hc.huffmanProgram();
		
		outputData.close();
		
	} //end main


}// end Project3
