package taskingBoard.Exception;

public class NoTaskFoundException extends IllegalArgumentException {

	/**
	 *
	 */
	private static final long serialVersionUID = -8141957257946353901L;

	public NoTaskFoundException(String userid) {
		super("No Task found for user " + userid);
	}

	public NoTaskFoundException(int taskid) {
		super("No Task found with id " + taskid);
	}
}
