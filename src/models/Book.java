package models;

public class Book {
	private String isbn;
	private String title;
	private Author author;
	private String genre;
	private int numPages;
	
	// Contructor
	public Book (String isbn, String title, Author author,
			String genre, int numPages) {
		
		// Validate ISBN using a regular expression
		if (isbn.matches("^(97[89])\\d{10}$")) {
			this.isbn = isbn;	
		} else {
			throw new IllegalArgumentException("Incorrect ISBN-13 format (Only numbers)");
		}
		
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.numPages = numPages;
		
	}
	
	// Getters
	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public int getNumPages() {
		return numPages;
	}

}

