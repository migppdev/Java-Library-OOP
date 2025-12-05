package exception;

public class BookNotFound extends Exception{
	private static final long serialVersionUID = 1L;

	public BookNotFound(String message) {
		super(message);
	}
}
