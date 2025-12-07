package models;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

public class Library {
	private Map<Book, Integer> bookList = new HashMap<>();
	
	public void addBook(Book newBook, int units) throws BookAlreadyExistsException{
		// If book already exists in the library, throw exception
		if (bookList.containsKey(newBook)) {
			throw new BookAlreadyExistsException(newBook.getTitle() + " already exists in the library");
		}
		// Add book to library
		bookList.put(newBook, units);
	}	

	public void deleteBook(String isbn) throws BookNotFoundException{ 
		// Iterate over bookList
		for (Book book : bookList.keySet()) {
			// If a book with the ISBN exists, remove it
			if (book.getIsbn() == isbn) {
				bookList.remove(book);
				return;
			}
		}
		// return false if the book was not found
		throw new BookNotFoundException("The book with ISBN" + isbn + " was not found");
	}
	
	public Book getBookByISBN(String isbn) throws BookNotFoundException{
		for (Book book : bookList.keySet()) {
			if (book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		throw new BookNotFoundException("Book is not in the library");
	}
	
	public List<Book> getBooksByAuthor(Author author) {
		List<Book> foundBooks = new ArrayList<>();
		
		for (Book book : bookList.keySet()) {
			if (book.getAuthor().getId() == author.getId()) {
				foundBooks.add(book);
			}
		}
		
		return foundBooks;
		
	}
}

 