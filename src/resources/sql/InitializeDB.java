package resources.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeDB {

	/*
	public static void createTables() {
		System.out.println("");
	}
	*/
	
	private static void executeSQL(String sql) {
		try {
			Connection conn = SQLConnection.connect();
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		}	catch (SQLException e) {
			System.err.println("Error creating table" + e.getMessage());
		}
	}
	
	private static String getAuthorsTableSQL() {
		String authorsTable = "CREATE TABLE IF NOT EXISTS authors ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name TEXT NOT NULL,"
				+ "lastName TEXT NOT NULL,"
				+ "birthDate DATE NOT NULL,"
				+ "dateDeath DATE";	
		
		return authorsTable;
		
	}
	
	private static String getGenresTableSQL() {
		
		String bookGenres = "CREATE TABLE IF NOT EXISTS book_genres ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "genre TEXT NOT NULL";
		
		return bookGenres;
		
	}


	private static String getBooksTableSQL() {
		String booksTable = "CREATE TABLE IF NOT EXISTS books ("
				+ "isbn TEXT PRIMARY KEY,"
				+ "title TEXT NOT NULL,"
				+ "author_id INTEGER REFERENCES authors(id) NOT NULL,"
				+ "genre_id INTEGER REFERENCES book_genres(id) NOT NULL,"
				+ "num_pages INTEGER NOT NULL";	
		
		return booksTable;
	}
	
		
	
}
