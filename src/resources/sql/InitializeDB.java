package resources.sql;

public class InitializeDB {
	public static void createTables() {
		String authorsTable = "CREATE TABLE IF NOT EXISTS authors ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT"
				+ "name TEXT NOT NULL"
				+ "lastName TEXT NOT NULL"
				+ "birthDate DATE NOT NULL"
				+ "dateDeath DATE";		
		
		String bookGenres = "CREATE TABLE IF NOT EXISTS book_genres ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT"
				+ "genre TEXT NOT NULL";
		
		String booksTable = "CREATE TABLE IF NOT EXISTS books ("
				+ "isbn TEXT PRIMARY KEY"
				+ "title TEXT NOT NULL"
				+ "author_id INTEGER REFERENCES authors(id) NOT NULL"
				+ "genre_id INTEGER REFERENCES book_genres(id) NOT NULL"
				+ "num_pages INTEGER NOT NULL";			
	}
}
