package exception;

public class BookAlreadyExists extends Exception{
	private static final long serialVersionUID = 1L;

	public BookAlreadyExists(String message) {
		super(message);
	}
}
