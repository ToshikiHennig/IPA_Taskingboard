package taskingBoard.Exception;

public class LoginSessionException extends IllegalArgumentException {

	/**
	 *
	 */
	private static final long serialVersionUID = -8141957257946353901L;

	public LoginSessionException() {
		super("Login Session not valid");
	}

}