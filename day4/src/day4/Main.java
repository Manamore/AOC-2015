package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	
	final static String puzzleInput = "iwrupvqb";
	public static void main(String[] args) {
		int number = 0;
		boolean pass = false;
		do{
			String hexString = generateHash(Integer.toString(number));
			System.out.println(hexString.substring(0, 5));
			if(hexString.substring(0, 5).equals("00000")){
				pass = true;
				System.out.println("Passed with \'" + number + "\'");
			}
			else
			{
				number += 1;
			}
		} while (pass == false);
		
	}
	
	public static String generateHash(String testInput){
		try{
			String combinedString = puzzleInput + testInput;
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(combinedString.getBytes());
			byte[] digest = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (byte b : digest) {
				hexString.append(String.format("%02x", b));
			}
			return hexString.toString();
		} catch(Exception e){
			System.out.println(e);

			return testInput;
		}
		
	}
	
	public static String readFile(String filePath){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			reader.close();
			return reader.readLine();
		} catch (Exception e) {
			System.out.println(e);
			return "failed to read";
		}
	}
}
