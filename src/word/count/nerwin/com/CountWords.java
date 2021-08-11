package word.count.nerwin.com;

import java.util.List;
import java.util.stream.Collectors;

import word.count.nerwin.com.filter.IFilter;


/**
 * Utility Class to filter words(with custom filter) in a list.
 * and get the filtered list of Strings and amount of filtered
 * list of Strings. 
 * @author Nerwin Tjen
 *
 */
public class CountWords 
{
	//List of input strings
	private List<String> listOfStrings;
	
	/**
	 * Class constructor specifying the list 
	 * containing strings to be filtered
	 * @param listOfStrings
	 */
	public CountWords(List<String> listOfStrings) {
		this.listOfStrings = listOfStrings;
	}
	
	/**
	 * Method to add filter to use in the CountWords instance.
	 * We can combine different filters with this method, by method chaining.
	 * @return this CountWords class instance
	 */
	public CountWords addFilter(IFilter ifilter){
		this.listOfStrings = listOfStrings.stream()
										  .filter(ifilter::filterCheck)
										  .collect(Collectors.toList());	
		return this;
	}
	
	/**
	 * Get the amount of words left after list has been filtered
	 * @return amount of words left in the list
	 */
	public int filteredWordCount() {
		return this.listOfStrings.size();
	}

	/**
	 * Getters for listOfStrings
	 * @return listOfStrings
	 */
	
	public List<String> getListOfStrings() {
		return listOfStrings;
	}
	

	/**
	 * Setters for listOfStrings
	 * @param listOfStrings
	 */
	public void setListOfStrings(List<String> listOfStrings) {
		this.listOfStrings = listOfStrings;
	}
	
	
}