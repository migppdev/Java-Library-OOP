package models;

import java.util.Map;
import java.util.HashMap;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

public class Library {
	private Map<Book, Integer> bookList = new HashMap<>();
	
	public void addBook(Book newBook, int units) throws BookAlreadyExistsException{
		// If book already exists in the library, throw exception
		if (bookList.containsKey(newBook)) {
			throw new BookAlreadyExistsException(newBook + " already exists in the library");
		}
		// Add book to library
		bookList.put(newBook, units);
	}	
	
	public Book getBookByISBN(String isbn) throws BookNotFoundException{
		for (Book book: bookList.keySet()) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		throw new BookNotFoundException("Book is not in the library");
	}
	        
}

 