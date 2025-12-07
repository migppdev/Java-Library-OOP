package models;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

public class Library {
	// Map to store books and its ISBN <ISBN, Book>
	private Map<String, Book> bookMap = new HashMap<>();
    // Map to store units available, <ISBN, units>
	private Map<String, Integer> bookUnits = new HashMap<>();

    public void addBook(Book newBook, int units) throws BookAlreadyExistsException {
        String isbn = newBook.getIsbn();
        if (bookMap.containsKey(isbn)) {
            throw new BookAlreadyExistsException(newBook.getTitle() + " already exists in the library");
        }
        bookMap.put(isbn, newBook);
        bookUnits.put(isbn, units);
    }

    public void deleteBook(String isbn) throws BookNotFoundException {
        if (!bookMap.containsKey(isbn)) {
            throw new BookNotFoundException("The book with ISBN " + isbn + " was not found");
        }
        bookMap.remove(isbn);
        bookUnits.remove(isbn);
    }

    public Book getBookByISBN(String isbn) throws BookNotFoundException {
        Book book = bookMap.get(isbn);
        if (book == null) {
            throw new BookNotFoundException("Book is not in the library");
        }
        return book;
    }

    public List<Book> getBooksByAuthor(Author author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : bookMap.values()) {
            if (book.getAuthor().getId() == author.getId()) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}


 