package resources.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeDB {

	public static void createTables() {
		executeSQL(getAuthorsTableSQL());
		executeSQL(getBooksTableSQL());
		executeSQL(getGenresTableSQL());
		executeSQL(getLoansTableSQL());
		executeSQL(getUsersTableSQL());
	}

	
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
		String sql = "CREATE TABLE IF NOT EXISTS authors ("
				+ "book_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name TEXT NOT NULL,"
				+ "last_name TEXT NOT NULL,"
				+ "birth_date DATE NOT NULL,"
				+ "date_death DATE";	
		
		return sql;
		
	}
	
	private static String getGenresTableSQL() {
		
		String sql = "CREATE TABLE IF NOT EXISTS book_genres ("
				+ "genre_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "genre TEXT NOT NULL";
		
		return sql;
		
	}


	private static String getBooksTableSQL() {
		// Update e-r diagram (id)
		String sql = "CREATE TABLE IF NOT EXISTS books ("
				+ "book_id INTEGER PRIMARY KEY AUTOINCREMENT"
				+ "isbn TEXT NOT NULL,"
				+ "title TEXT NOT NULL,"
				+ "author_id INTEGER REFERENCES authors(id) NOT NULL,"
				+ "genre_id INTEGER REFERENCES book_genres(id) NOT NULL,"
				+ "num_pages INTEGER NOT NULL";	
		
		return sql;
	}


	private static String getUsersTableSQL() {
		String sql = "CREATE TABLE IF NOT EXISTS users("
				+ "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "name TEXT NOT NULL,"
				+ "last_name TEXT"
				+ "age INTEGER NOT NULL";
		return sql;
	}
	
	private static String getLoansTableSQL() {
		String sql = "CREATE TABLE IF NOT EXISTS loans ("
				+ "loan_id TEXT PRIMARY KEY,"
				+ "borrowed_book INTEGER REFERENCES books(isbn) NOT NULL,"
				+ "borrower_user INTEGER REFERENCES users(user_id) NOT NULL,"
				+ "borrow_date DATE NOT NULL"
				+ "expected_return DATE NOT NULL";	
		
		return sql;
	}
}
