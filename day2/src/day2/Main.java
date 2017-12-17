package day2;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<String[]> fileArr = readFileByLine("../testdata/day2.txt");
		int totalPaperReq = 0;
		for(String[] dimensions : fileArr){
			totalPaperReq += calcSurfaceArea(dimensions);
		}
		System.out.println(totalPaperReq);
		
		/*
		//Print entire list
		for(String[] dimensions : fileArr){
			System.out.print("[");
			for (String num : dimensions){
				System.out.print(num);
				System.out.print(',');
			}
			System.out.print("]");
			System.out.println(calcSurfaceArea(dimensions));
		}
		*/
	}
	
	//Spews out in LxWxH in each dimension array
	public static List<String[]> readFileByLine(String filePath){
		List<String[]> arr = new ArrayList<String[]>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = reader.readLine()) != null){
				String[] dimensions = new String[3];
				dimensions = line.split("x");
				arr.add(dimensions);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return arr;
	}
	
	public static int calcSurfaceArea(String[] dimensions){
		int l,w,h;
		int smallestSide;
		int totalSA;
		
		l = Integer.parseInt(dimensions[0]);
		w = Integer.parseInt(dimensions[1]);
		h = Integer.parseInt(dimensions[2]);
		
		smallestSide = l*w;
		if(smallestSide > w*h) smallestSide = w*h;
		if(smallestSide > h*l) smallestSide = h*l;
		
		totalSA = 2*(l*w) + 2*(w*h) + 2*(h*l) + smallestSide;
		
		return totalSA;
		
	}
}
