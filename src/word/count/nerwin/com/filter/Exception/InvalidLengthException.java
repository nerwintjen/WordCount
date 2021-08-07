package word.count.nerwin.com.filter.Exception;

/**
 * Exception for invalid string length input 
 * @author Nerwin Tjen
 *
 */


public class InvalidLengthException extends Exception {
	public InvalidLengthException(String errorMessage) {
		super(errorMessage);
	}
}
