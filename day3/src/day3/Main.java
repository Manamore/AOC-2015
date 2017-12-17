package day3;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		List<Character> input_arr = readFileByChar("../testdata/day3.txt");
		Set<Point> coord_arr = new HashSet<>();
		//List<Point> coord_arr = new ArrayList<>(); To make sure all values print as expected
		int counter = 1;
		
		Point coord_curr = new Point(0, 0);
		//Prep position 0
		coord_arr.add(coord_curr);
		//System.out.println("Counter [" + counter + "] " + "- : " + coord_curr.x + ", " + coord_curr.y);
		
		//Assign coords from input
		for(char c : input_arr){
			counter += 1;
			coord_curr = new Point(coord_curr.x, coord_curr.y);
			double x = coord_curr.x;
			double y = coord_curr.y;
			switch (c){
				case '>': 	coord_curr.setLocation(x += 1, y);
							break;
				case '<':	coord_curr.setLocation(x -= 1, y);
							break;
				case '^':	coord_curr.setLocation(x, y += 1);
							break;
				case 'v':	coord_curr.setLocation(x, y -= 1);
							break;
			}

			//System.out.println("Counter [" + counter + "] " + c + " : " + coord_curr.x + ", " + coord_curr.y);
			coord_arr.add(coord_curr);
		}
		
		//Coords recorded as expected
		/*for(Point p : coord_arr){
			System.out.println(p.x + ", " + p.y);
		}*/
		
		//Print answer
		System.out.println("Answer: " + coord_arr.size());
	}

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
		
		/* Array as expected
		for(char c : arr){
			System.out.print(c);
		}
		*/
		
		return arr;
	}
}
