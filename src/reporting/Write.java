package reporting;

import java.io.*;
import java.util.ArrayList;

import finance.Transaction;
import finance.TransactionRecord;

public class Write {

	private ArrayList<Transaction> list;
	private BufferedWriter out;

	/**
	 * Creates a Writer instance
	 * 
	 * @param a
	 */
	public Write(TransactionRecord a) {
		list = a.getFullRecord();
	}

	// Writes data to a file
	public void writeData() {

		try {
			// Create file
			FileWriter fstream = new FileWriter("codejam.json");

			out = new BufferedWriter(fstream);

			writeHeader();

			for (int i = 0; i < list.size(); i++) {

				writeTransaction(list.get(i));

				// Closes the file if end of list reached.
				if (i == list.size() - 1)
					out.write("    }");
				else
					out.write("    },");
			}

			writeFooter();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Could not write data to file." + "\nError: "
					+ e.getMessage());
		}
	}

	// Writes header for the file
	private void writeHeader() {
		try {

			out.write("{");
			out.newLine();
			out.write("  \"team\" : \"Nitrogylcerin\",");// Team name
			out.newLine();
			out.write("  \"destination\" : \"mcgillcodejam2012@gmail.com\",");
			out.newLine();
			out.write("  \"transactions\" : [");

		} catch (Exception e) {
			// Catches exception if any.
			System.err.println("Could not write header to file.\nError: "
					+ e.getMessage());
		}
	}

	/**
	 *  Writes transaction info into the JSON file.
	 * @param transaction
	 */
	private void writeTransaction(Transaction transaction) {

		try {
			out.newLine();
			out.write("    {");
			out.newLine();
			out.write("      \"time\" : \"" + transaction.getTime() + "\",");
			out.newLine();
			out.write("      \"type\" : \"" + transaction.getAction() + "\",");
			out.newLine();
			out.write("      \"price\" : \"" + transaction.getPrice() + "\",");
			out.newLine();
			out.write("      \"manager\" : \"" + transaction.getManager()
					+ "\",");
			out.newLine();
			out.write("      \"strategy\" : \"" + transaction.getStrategy()
					+ "\"");
			out.newLine();

		} catch (Exception e) {
			// Catches exception if any.
			System.err.println("Could not write transaction to file.\nError: "
					+ e.getMessage());
		}

	}

	/**
	 * Appends footer to the JSON file.
	 */
	private void writeFooter() {

		try {
			out.newLine();
			out.write("  ]");
			out.newLine();
			out.write("}");
			out.close();

		} catch (Exception e) {
			// Catches exception if any.
			System.err.println("Error: " + e.getMessage());
		}
	}
}
