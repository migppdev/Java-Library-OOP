package app;
import models.Book;
import models.Library;
import java.time.LocalDate;
import models.Author;
import exception.BookAlreadyExistsException;

public class Main {
	public static void main(String[] args) {
		Author orwell = new Author("George", "Orwell", LocalDate.of(1903, 6, 25), LocalDate.of(1950, 1, 21));
		Book book1 = new Book("9781443434973", "1984", orwell, "Political", 328);
		Library library = new Library();
		try {
			library.addBook(book1, 5);
			library.addBook(book1, 5);
		} catch (BookAlreadyExistsException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println(book1.getAuthor().getFullName());
	}
}
