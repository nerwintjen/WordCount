package word.count.nerwin.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import word.count.nerwin.com.filter.CharacterFilter;
import word.count.nerwin.com.filter.LengthFilter;

public class Main {
	/**
	 * main method
	 * @param args
	 */
	
	public static void main(String[]args) {
		List<String> stringListInput = Arrays.asList("Menu", "manly","jnasiu23","2343","asdasd","kjnasjdnakjsdnkjs");
		LengthFilter a = new LengthFilter();
		CharacterFilter b = new CharacterFilter();
		CountWords countwords1 = new CountWords(stringListInput);
		CountWords countwords2 = new CountWords(stringListInput);
		a.moreThanAndEqualTo(8).lessThanAndEqualTo(10);
		b.comparingCharacter(0, "ma").withCaseSensitivity(true);
		countwords1.addFilter(a);
		countwords2.addFilter(b);
		System.out.println("List of filtered count words : "+ countwords1.filteredWordCount());
		countwords1.getListOfStrings().forEach(System.out::println);
		System.out.println("List of filtered count words : "+ countwords2.filteredWordCount());
		countwords2.getListOfStrings().forEach(System.out::println);
		
		Path path = Paths.get("InputFile.txt");
		 try (Stream<String> stream = Files.lines(path)) {
	            stream.forEach(System.out::println);
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
}
