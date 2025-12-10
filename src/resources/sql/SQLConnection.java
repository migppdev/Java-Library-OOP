package resources.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	public static Connection connect() {
		String url = "jdbc:sqlite:library.db";
		Connection conn = null;

		try {
			// Get the connection to the URL
			conn = DriverManager.getConnection(url);
			System.out.println("Successful connection");
		} catch (SQLException e ) { 
			System.out.println(e.getMessage());
		} 
		return conn;
	}
}
