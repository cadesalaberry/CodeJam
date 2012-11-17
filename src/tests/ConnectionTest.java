package tests;

import static org.junit.Assert.*;
import server.Connection;
import org.junit.Test;

public class ConnectionTest {

	@Test
	public void testGetValuesFromServer() {
		Connection connection = new Connection();
		
		assertTrue(connection.fullRoutine());
	}
}
