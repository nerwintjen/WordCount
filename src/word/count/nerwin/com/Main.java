package word.count.nerwin.com;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import word.count.nerwin.com.filter.CharacterFilter;
import word.count.nerwin.com.filter.LengthFilter;

public class Main {
	/**
	 * main method
	 * @param args
	 */
	
	public static void main(String[]args) {
		//read from InputFile.txt
		List<String> stringListInput = new ArrayList<String>();
		 try  {
			 	stringListInput = Files.readAllLines(Paths.get("InputFile.txt"), StandardCharsets.UTF_8);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
		 stringListInput.forEach(System.out::println);
		 //case 1 count and returns the number of words that start with "M" or "m"		 
		 CountWords countwords1 = new CountWords(stringListInput);
		 CharacterFilter charFilter = new CharacterFilter();
		 charFilter.comparingCharacter(0, "m")
		 		   .withCaseSensitivity(false);
		 countwords1.addFilter(charFilter);
		 System.out.printf("Number of words that starts with the letter \"m\" or \"M\" is %s",countwords1.filteredWordCount());
		 
		 //case 2 returns all words longer than 5 character
		 CountWords countwords2 = new CountWords(stringListInput);
		 LengthFilter lengthFilter = new LengthFilter();
//		 
//			List<String> stringListInput = 
//			LengthFilter a = new LengthFilter();
//			CharacterFilter b = new CharacterFilter();
//			CountWords countwords1 = new CountWords(stringListInput);
//			CountWords countwords2 = new CountWords(stringListInput);
//			a.moreThanAndEqualTo(8).lessThanAndEqualTo(10);
//			b.comparingCharacter(0, "ma").withCaseSensitivity(true);
//			countwords1.addFilter(a);
//			countwords2.addFilter(b);
//			System.out.println("List of filtered count words : "+ countwords1.filteredWordCount());
//			countwords1.getListOfStrings().forEach(System.out::println);
//			System.out.println("List of filtered count words : "+ countwords2.filteredWordCount());
//			countwords2.getListOfStrings().forEach(System.out::println);
		
		
	}
}
