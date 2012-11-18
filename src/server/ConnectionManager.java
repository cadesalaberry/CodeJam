package server;

import strategies.Strategy;
import manager.StrategyManager;

public class ConnectionManager extends StrategyManager {

	Connection connection;

	public ConnectionManager(Strategy one, Strategy two) {
		super(one, two);
		initiateConnection();
	}

	public ConnectionManager() {
		super();
		initiateConnection();
	}
	
	/**
	 * Returns the connection initiated by the connection manager.
	 * @return
	 */
	public Connection getConnection() {
		return this.connection;
	}
	/**
	 * Initiates a connection. Only used locally.
	 */
	private void initiateConnection() {
		connection = new Connection();
	}
}
