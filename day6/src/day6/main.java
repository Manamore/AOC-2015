package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	
	
	public static void main(String[] args) {
		int[][]  lights = new int[1000][1000];
		List<String> lightControls = readFileByLine("../testdata/day6.txt");
		List<String> splitArray = new ArrayList<String>();
		//String[] res = controls.get(0).find("(?<=\\s)\\d+\\,\\d+");
		
		for(String line: lightControls){
			splitArray = new ArrayList<String>(Arrays.asList(line.split("(?<=\\d)(?=\\D)|(?=\\d)(?<=\\D)"))); //Digit befre and non-digit after | digit after and non digit before
			//0 = toggletype, 1 = point x1, 3 = point y1, 5 = point x2, 7 = point y2
			System.out.println(splitArray);
			int x1, y1, x2, y2;
			int xChange, yChange;
			x1 = Integer.parseInt(splitArray.get(1));
			y1 = Integer.parseInt(splitArray.get(3));
			x2 = Integer.parseInt(splitArray.get(5));
			y2 = Integer.parseInt(splitArray.get(7));
			if(x1 < x2) xChange = 1;
			else xChange = -1;
			if(y1 < y2) yChange = 1;
			else yChange = -1;
			y2 += yChange;
			x2 += xChange;
			
			if(splitArray.get(0).contains("on")){
				while(x1 != x2){
					int y = y1;
					while(y != y2){
						lights[x1][y] = 1;
						y += yChange;
					}
					x1 += xChange;
				}
			}
			else if(splitArray.get(0).contains("off")){
				while(x1 != x2){
					int y = y1;
					while(y != y2){
						lights[x1][y] = 0;
						y += yChange;
					}
					x1 += xChange;
				}
			}
			else{
				while(x1 != x2){
					int y = y1;
					while(y != y2){
						if(lights[x1][y] == 1) lights[x1][y] = 0;
						else lights[x1][y] = 1;
						y += yChange;
					}
					x1 += xChange;
				}
			}
			
			
			/*System.out.println(splitArray);
			xDiff = Math.abs(Integer.parseInt(splitArray.get(1)) - Integer.parseInt(splitArray.get(5)));
			yDiff = Math.abs(Integer.parseInt(splitArray.get(3)) - Integer.parseInt(splitArray.get(7)));
			System.out.println(">> " + yDiff + " _ " + xDiff);
			lights[1][1] = 1;
			for(int x = 0)*/
			/*
			if(splitArray.get(0).contains("on")){
				for(int x = 0; x <= xDiff; x++){
					for(int y = 0; y <= yDiff; y++){
						lights[x][y] = 1;
					}
				}
			}
			else if(splitArray.get(0).contains("off")){
				for(int x = 0; x <= xDiff; x++){
					for(int y = 0; y <= yDiff; y++){
						lights[x][y] = 0;
					}
				}
			}
			else{
				for(int x = 0; x <= xDiff; x++){
					for(int y = 0; y <= yDiff; y++){
						if(lights[x][y] == 1){
							lights[x][y] = 0;
						}
						else{
							lights[x][y] = 1;
						}
					}
				}
			}*/
			
			
			/*
			for(String z : splitArray){
				System.out.println(z);
			}*/
			
		}
		
		int lightCounter = 0;
		for(int[] row : lights){
			for(int cell : row){
				lightCounter += cell;
				System.out.print(cell);
			}
			System.out.println();
		}
		
		System.out.println(" FINAL TALLY : " + lightCounter);
		System.exit(0);
		
	}
	
	public void toggle(int[] cell){
		
	}
	
	public void turnOff(int[] cell){
		
	}
	
	public void turnOn(int[] cell){
		
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
