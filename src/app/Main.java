package app;
import models.Book;
import java.time.LocalDate;
import models.Author;

public class Main {
	public static void main(String[] args) {
		Author orwell = new Author("George", "Orwell", LocalDate.of(1903, 6, 25), LocalDate.of(1950, 1, 21));
		Book book1 = new Book("9781443434973", "1984", orwell, "Political", 328);
		
		System.out.println(book1.getAuthor().getFullName());
		
	}
}
