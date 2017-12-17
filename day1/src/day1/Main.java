package day1;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Character> charArray = readFileByChar("../testdata/day1.txt");
		int floorNum = 0;
		for(char input : charArray){
			if(input == '(') floorNum += 1;
			else floorNum -= 1;
		}
		System.out.print(floorNum);
	}
	
	/* Since buffered reader + file reader didnt register brackets longer than a certain number of chars, used
	 * reading by single char and append to an array. Less efficient but for little things itll do. :(
	 */
	public static List<Character> readFileByChar(String filepath){
		List<Character> arr = new ArrayList<Character>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), Charset.forName("UTF-8")));
			int c;
			while((c = reader.read()) != -1){
				arr.add((char) c);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return arr;
	}
}
