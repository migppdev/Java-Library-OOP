package models;
import java.time.LocalDate;

public class Loan {
	private Book borrowedBook;
	private User borrowerUser;
	private LocalDate dateOfBorrow;
	private LocalDate expectedReturn;
	// Constructor
	public Loan(Book borrowedBook, User borrowerUser,
			LocalDate dateofBorrow, LocalDate expectedReturn) {
		this.borrowedBook = borrowedBook;
		this.borrowerUser = borrowerUser;
		this.dateOfBorrow = dateofBorrow;
		this.expectedReturn = expectedReturn;
	}

	// Getters
	public LocalDate getDateBorrow() {
		return this.dateOfBorrow;
	}
	
	public LocalDate getExpectedReturn() {
		return this.expectedReturn;
	}
	
	public Book getBorrowedBook() {
		return this.borrowedBook;
	}
	
	public User getBorrower() {
		return this.borrowerUser;
	}
	
}
