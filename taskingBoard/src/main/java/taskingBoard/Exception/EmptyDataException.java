package taskingBoard.Exception;

public class EmptyDataException extends IllegalArgumentException {

	/**
	 *
	 */
	private static final long serialVersionUID = -8141957257946353901L;

	public EmptyDataException() {
		super("Not all required fields are filled");
	}

}