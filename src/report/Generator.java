package report;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Generator {
	
	
	/**
	 * This is a stub to read a file, NOT WRITE.
	 * @param filename
	 * @return
	 */
	public static ArrayList<String> readWordsFromFile(String filename) {

		ArrayList<String> words = new ArrayList<String>();

		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			// Strip non-alphanumeric \\W
			scanner.useDelimiter("\\W+");
			while (scanner.hasNext()) {
				words.add(scanner.next());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		return words;
	}
}
