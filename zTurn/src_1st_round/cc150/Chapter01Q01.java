package cc150;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
Implement an algorithm to determine if a string has all unique characters 
What if you can not use additional data structures?
 */

public class Chapter01Q01 {
	public static void main(String[] args) {
		
		int loops = 20;
		
		for(int i = 0; i < loops; i++){
			StringBuilder test = new StringBuilder();
			for(int j = 0; j < 10; j++){
				String pool = "abcdefghijklmnopqrstuvwxyz1234567890";
				Random r = new Random();
				int random = r.nextInt(pool.length());
				test.append(pool.charAt(random));
			}
			
			System.out.print("The String to be validated: " + test + " ");
			boolean tt = method_without_data_structure(test.toString());
			if(tt) System.out.println("is unique tested without data structure.");
			else System.out.println("is not unique tested without data structure.");
			System.out.print("The String to be validated: " + test + " ");
			tt = method_with_data_structure(test.toString());
			if(tt) System.out.println("is unique tested with data structure.");
			else System.out.println("is not unique tested with data structure.");
			System.out.println("===================");
		}
	}

	public static boolean method_with_data_structure(String str) {
		Set set = new HashSet<String>();
		for(int i=0; i < str.length(); i++){
			boolean tt = set.add(str.charAt(i));
			if(!tt) return false; 
		}
		return true;
	}

	public static boolean method_with_data_structure2(String str) {
		boolean[] set = new boolean[256];
		for(char c : str.toCharArray()){
			if(!set[c]) set[c]=true;
			else return false;
		}
		return true;
	}
	
	public static boolean method_without_data_structure(String str) {
		boolean[] cArray = new boolean[255];
		
		for(int i=0; i < str.length(); i++){
			if(cArray[str.charAt(i)] == false)
				cArray[str.charAt(i)] = true;
			else
				return false;
		}
		
		return true;
	}
}
