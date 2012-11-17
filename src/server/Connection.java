package server;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

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

	public boolean fullRoutine() {

		return connect() && receive();
	}

	public static boolean connect() {

		// Open socket at server's port
		try {
			echoSocket = new Socket(machineName, 3000);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			scanner = new Scanner(echoSocket.getInputStream());
			scanner.useDelimiter("\\|");

		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + machineName + ".");
			return false;
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: "
					+ machineName + ".");
			return false;
		}

		return true;

	}

	public boolean receive() {

		// Send signal to server to start sending values
		sendAction(Action.START);

		// Starts stacking up data.
		while (scanner.hasNextDouble()) {
			PriceBank.deposit(scanner.nextDouble());
			// System.out.println(dump.peekLast());
		}
		if (scanner.next().equals("C")) {

			return close();
		}
		return false;
	}

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

	public void sendAction(Action action) {

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