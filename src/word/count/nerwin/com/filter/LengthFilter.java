package word.count.nerwin.com.filter;

import word.count.nerwin.com.filter.Exception.InvalidLengthException;

/**
 * LengthFilter only filters the String by its length
 * @author Nerwin Tjen
 *
 */
public class LengthFilter implements iFilter{
	private int maxLength = -1;
	private int minLength = -1;
	

	/**
	 * Check if string length is less than or equal to given number
	 * @param maxLength Maximum length of the string
	 * @return this LengthFilter
	 */
		
	public LengthFilter lessThanAndEqualTo(int maxLength) {
		this.maxLength = maxLength;
		return this;
	}
	
	/**
	 * Check if string length is more than or equal to given number
	 * @param minLength Maximum length of the string
	 * @return this LengthFilter
	 */
	
	public LengthFilter moreThanAndEqualTo(int minLength) {
		this.minLength = minLength;
		return this;
	}
	
	/**
	 * This method checks whether the length of a given string 
	 * and returns true if String length is less than the max length 
	 * and returns true if String length is more than the min length.
	 * returns false otherwise. Throws InvalidLengthException if
	 *  max length is more than min length
	 */
	public boolean filterCheck(String input) {
		try 
		{
			if(0 < maxLength && maxLength < minLength)
				throw new InvalidLengthException("Max length should be larger than or equal to min length");
			if(maxLength > 0  && input.length()>maxLength)
				return false;
			else if(minLength > 0  && input.length()<minLength)
				return false;			
		}
		catch(InvalidLengthException e) 
		{
			System.err.println(e.toString());
		}
		return true;
	}
	
}
