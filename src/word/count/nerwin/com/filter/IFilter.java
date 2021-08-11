package word.count.nerwin.com.filter;


/**
 * This is the iFilter interface which we use as 
 * a base for all our Filter classes
 * @author Nerwin Tjen
 *
 */

public interface IFilter {

	/**
	 * This method checks whether or not our 
	 * string pass the filter
	 * @param input String to be checked
	 * @return true if String pass the filter and false otherwise.
	 */
	public boolean filterCheck(String input);
}
