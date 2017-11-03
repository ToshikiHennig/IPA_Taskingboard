package taskingBoard.Exception;

public class NoUserFoundException extends IllegalArgumentException {

	/**
	 *
	 */
	private static final long serialVersionUID = -8141957257946353901L;

	public NoUserFoundException() {
		super("No User found");
	}
}
