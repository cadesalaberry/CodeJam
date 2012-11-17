package server;

public class ConnectionManager {

	Connection connection;
	
	public ConnectionManager() {
		connection = new Connection();
	}
	
	public Connection getConnection(){
		return this.connection;
	}
	
}
