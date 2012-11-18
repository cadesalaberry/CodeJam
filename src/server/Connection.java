package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import scheduling.Timer;
import strategies.StrategyMaster;

import finance.Action;

public class Connection {

	static Socket echoSocket;
	static PrintWriter out;
	static String machineName;
	PriceBank bank;
	static Scanner scanner;

	public Connection(String machineName) {
		Connection.machineName = machineName;

		bank = new PriceBank();
	}

	public Connection() {
		this("localhost");
	}

	/**
	 * Connects to and receive from server.
	 * 
	 * @return
	 */
	public boolean fullRoutine() {

		return connect() && receive();
	}

	/**
	 * Establishes the connection to the server. Starts receiving the data.
	 * 
	 * @return
	 */
	public static boolean connect() {

		try {
			// Open socket at server's port
			echoSocket = new Socket(machineName, 3000);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			scanner = new Scanner(echoSocket.getInputStream());
			scanner.useDelimiter("\\|");

		} catch (IOException e) {
			System.err
					.println("The exchange server on "
							+ machineName
							+ "cannot be found. Please check your network configuration and run the program again.");
			return false;
		}
		return true;

	}

	/**
	 * Returns true if the connection is complete.
	 * 
	 * @return
	 */
	public boolean receive() {

		// Send signal to server to start sending values
		sendAction(Action.START);
		String received = scanner.next();

		// Increments time before to make the timer start at 1.
		Timer.incrementTime();

		System.out.println("time:" + Timer.getTime() + "\t" + received);

		if (received.equals("C") || !scanner.hasNext()) {
			System.out.println("Connection closed.");
			return close();
		} else if (received.equals("E")) {
			System.out.println("An Error has been reported from the server.");
		}

		// Starts communicating the data.
		{
			double newPrice = Double.parseDouble(received);
			PriceBank.deposit(newPrice);
			StrategyMaster.addPrice(newPrice);
			return false;
		}
	}

	/**
	 * Closes connection with the server.
	 * 
	 * @return
	 */
	public static boolean close() {
		try {
			out.close();
			echoSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Sends a specific action to be performed
	 * 
	 * @param action
	 */
	public static void sendAction(Action action) {

		switch (action) {
		case START: {
			out.println('H');
			break;
		}
		case BUY: {
			out.println('B');
			break;
		}
		case SELL: {
			out.println('S');
			break;
		}
		case DO_NOTHING:
			break;

		}
	}
}
