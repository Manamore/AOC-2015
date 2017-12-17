package day2;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<String[]> fileArr = readFileByLine("../testdata/day2.txt");
		int totalRibbonReq = 0;
		int totalPaperReq = 0;
		for(String[] dimensions : fileArr){
			totalPaperReq += calcPaperReq(dimensions);
			totalRibbonReq += calcRibbonReq(dimensions);
		}
		System.out.println("Total wrapping paper required: " + totalPaperReq);

		System.out.println("Total ribbon required: " + totalRibbonReq);
		
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
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return arr;
	}
	
	public static int calcPaperReq(String[] dimensions){
		int smallestSide;
		int totalSA;
		List<Integer> dimensionList;
		
		dimensionList = sortDimensions(dimensions, "Surface Area");
		smallestSide = dimensionList.get(0);
		totalSA = smallestSide;
		
		for (Integer surfaceArea : dimensionList){
			totalSA += surfaceArea*2;
		}
		
		return totalSA;
		
	}
	
	public static int calcRibbonReq(String[] dimensions){
		List<Integer> dimensionList;
		int ribbon, bow;
		int totalLength;
		dimensionList = sortDimensions(dimensions, "Singular");
		
		ribbon = (dimensionList.get(0) + dimensionList.get(1))*2;
		bow = 1;
		for (Integer dimension : dimensionList){
			bow *= dimension;
		}
		totalLength = ribbon + bow;
		
		return totalLength;
	}
	
	public static List<Integer> sortDimensions(String[] dimensions, String conversionType){
		List<Integer> dimensionList = new ArrayList<Integer>();
		int l,w,h;
		l = Integer.parseInt(dimensions[0]);
		w = Integer.parseInt(dimensions[1]);
		h = Integer.parseInt(dimensions[2]);
		if(conversionType == "Surface Area"){
			dimensionList.add(l*w);
			dimensionList.add(w*h);
			dimensionList.add(h*l);
		}
		else{
			dimensionList.add(l);
			dimensionList.add(w);
			dimensionList.add(h);
		}
		Collections.sort(dimensionList);
		
		return dimensionList;
	}
}
