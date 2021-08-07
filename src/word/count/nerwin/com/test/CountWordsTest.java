package word.count.nerwin.com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import word.count.nerwin.com.CountWords;
import word.count.nerwin.com.filter.CharacterFilter;
import word.count.nerwin.com.filter.LengthFilter;

/**
 * CountWords unit test
 * @author Nerwin Tjen
 *
 */
public class CountWordsTest {
	
	

	//testing for length filter	
	@Test
	@DisplayName("length filter should work")
	public void testLengthFilter() {
		List<String> testList = Arrays.asList("moon","base","jupiter","marie","June","john","Motherhood");
		
		//first test
		CountWords countwords = new CountWords(testList);
		LengthFilter filter = new LengthFilter();
		
		//check for any words with length between 5 and 7
		filter.moreThanAndEqualTo(5).lessThanAndEqualTo(7);
		countwords.addFilter(filter);
		
		//should only return 2 words jupiter and marie
		assertEquals(2,countwords.filteredWordCount());
		assertEquals(Arrays.asList("jupiter","marie"),countwords.getListOfStrings());
		
		//check for any words with length between 5 and 10
		filter.moreThanAndEqualTo(5).lessThanAndEqualTo(10);		
		countwords.addFilter(filter);
		
		//should only return 2 words : jupiter and marie
		assertEquals(2,countwords.filteredWordCount());
		assertEquals(Arrays.asList("jupiter","marie"),countwords.getListOfStrings());
		
		//Second test
		CountWords countwords2 = new CountWords(testList);
		LengthFilter filter2 = new LengthFilter();
		
		//check for any words with length between 1 and 5
		filter2.moreThanAndEqualTo(1).lessThanAndEqualTo(5);
		countwords2.addFilter(filter2);
		
		//should only return 5 words : moon, base, marie, June, john
		assertEquals(5,countwords2.filteredWordCount());
		assertEquals(Arrays.asList("moon","base","marie","June", "john"),countwords2.getListOfStrings());
		
			
		//Third test
		CountWords countwords3 = new CountWords(testList);
		LengthFilter filter3 = new LengthFilter();
				
		//check for any words with length more than or equal to 1
		filter3.moreThanAndEqualTo(1);
		countwords3.addFilter(filter3);
				
		//should return all words
		assertEquals(7,countwords3.filteredWordCount());
		assertEquals(Arrays.asList("moon","base","jupiter","marie","June","john","Motherhood"),countwords3.getListOfStrings());
				

		
	}
	
	//testing for character filter	
	@Test
	@DisplayName("character filter should work")
	public void testCharacterFilter() {
		List<String> testList = Arrays.asList("moon","base","jupiter","marie","June","john","Motherhood");
		CountWords countwords = new CountWords(testList);
		CharacterFilter filter = new CharacterFilter();
		
		//checking forst character beginning with m, case insensitive
		filter.comparingCharacter(0, "m").withCaseSensitivity(false);
		countwords.addFilter(filter);
		
		//should result in moon, marie and Motherhood
		assertEquals(Arrays.asList("moon","marie","Motherhood"),countwords.getListOfStrings());
		
		CountWords countwords2 = new CountWords(testList);
		CharacterFilter filter2 = new CharacterFilter();
		
		//checking forst character beginning with j, case sensitive
		filter2.comparingCharacter(0, "j").withCaseSensitivity(true);
		countwords2.addFilter(filter2);
		
		//should result in jupiter, and john
		assertEquals(Arrays.asList("jupiter","john"),countwords2.getListOfStrings());
	}

}
