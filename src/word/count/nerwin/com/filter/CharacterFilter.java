package word.count.nerwin.com.filter;

/**
 * CharacterFilter only filters a String by a character 
 * in an exact position. (from 0 to string length)
 * @author Nerwin Tjen
 *
 */
public class CharacterFilter implements iFilter {
	//position of string to be compared
	private int position = -1;
	//string to be compared
	private String substring = null;
	//is the comparison case sensitive?
	private boolean isCaseSensitive = true;

	/**
	 * setting the position and character string to be compared
	 * @param position position at the string
	 * @param character string character 
	 * @return
	 */
	public CharacterFilter comparingCharacter(int position, String input) {
		this.position = position;
		this.substring = input;
		return this;
	}
	/**
	 * set the case sensitivity for this Filter
	 * @param isCaseSensitive
	 * @return this class
	 */
	public CharacterFilter withCaseSensitivity(boolean isCaseSensitive) {
		this.isCaseSensitive = isCaseSensitive;
		return this;
	}
	/**
	 * check if the input string passed the filter
	 * returns true if it does, false otherwise.
	 */
	@Override
	public boolean filterCheck(String input) {
		if(this.position < 0 || this.position+this.substring.length() > input.length() )
			return false;
		else if(this.substring == null)
			return false;
		else {
			if(this.isCaseSensitive)
				return input.substring(this.position, this.position+this.substring.length()).compareTo(this.substring)==0;
			else 
				return input.substring(this.position, this.position+this.substring.length()).compareToIgnoreCase(this.substring)==0;
		}
	}

}
