package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	//http://adventofcode.com/2015/day/5
	
	public static void main(String[] args) {
		List<String> inputs = readFileByLine("../testdata/day5.txt");
		int naughty = 0;
		int nice = 0;
		for (String input : inputs){
			if(isNice(input)){
				nice+=1;
			}
			else
			{
				naughty += 1;
			}
		}
		System.out.println("Nice: " + nice + "\nNaughty: " + naughty);
		
	}
	
	public static boolean isNice(String input){
		
		List<String> charPairArray = new ArrayList<String>();
		boolean seperatedChars = false;
				
		for(int i = 0; i < input.length()-1; i ++){
			//Grab pairs
			charPairArray.add("" + input.charAt(i) + input.charAt(i+1));
			//Prevent OOB
			if(i != input.length() - 2){
				//Catch all trips
				if(input.charAt(i) == input.charAt(i+1) && input.charAt(i+1) == input.charAt(i+2)){
					return false;
				}
				//Catch seperated xyx
				if(input.charAt(i) == input.charAt(i+2)){
					seperatedChars = true;
				}
			}
		}
		
		Set<String> charPairSet = new HashSet<String>(charPairArray);
		/*System.out.print("\n " + input + " : ");
		if(seperatedChars){
			System.out.print("Enough seperation, ");
		}
		if(charPairArray.size() > charPairSet.size()){
			System.out.print("Enough pairs.");
		}*/
		
		//Check more than one pair of pair exists and there is seperated char
		if(seperatedChars && charPairArray.size() > charPairSet.size()){
			return true;
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
