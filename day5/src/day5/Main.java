package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	//http://adventofcode.com/2015/day/5
	
	public static void main(String[] args) {
		List<String> inputs = readFileByLine("../testdata/day5.txt");
		int naughty = 0;
		int nice = 0;
		for (String input : inputs){
			if(!isNaughty(input) && isNice(input)){
				nice += 1;
			}
			else{
				naughty += 1;
			}
		}
		System.out.println("Nice: " + nice + "\nNaughty: " + naughty);
		
	}
	
	public static boolean isNaughty(String input){
		String[] naughtyValues = {"ab", "cd", "pq", "xy"};
		
		for (String naughtyString : naughtyValues){
			if(input.contains(naughtyString)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isNice(String input){
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		int vowelCounter = 0;
		boolean doubleChar = false;
		
		for (int i = 0; i<=input.length() - 1; i++){
			for (char vowel : vowels){
				if (input.charAt(i) == vowel){
					vowelCounter ++;
				}
			}
			if(!doubleChar && i+1 != input.length() && input.charAt(i) == input.charAt(i+1)){ //catch final val to prevent index oob
				doubleChar = true;
			}
			
			if (doubleChar && vowelCounter >= 3){
				return true;
			}
		}
		return false;

	}
	
	public static List<String> readFileByLine(String filePath){
		List<String> arr = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = reader.readLine()) != null){
				arr.add(line);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return arr;
	}
}
