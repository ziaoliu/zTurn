package cc150;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 Write code to reverse a C-Style String (C-String means that ¡°abcd¡± is represented as 
 five characters, including the null character )
 */

public class Chapter01Q02 {
	public static void main(String[] args) {

		int loops = 20;

		for (int i = 0; i < loops; i++) {
			StringBuilder test = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				String pool = "abcdefghijklmnopqrstuvwxyz1234567890";
				Random r = new Random();
				int random = r.nextInt(pool.length());
				test.append(pool.charAt(random));
			}

			System.out.print("The String to be validated: " + test + " ");
			System.out.println();
			reverse(test.toString());
			reverseInPlace(test.toString());
			System.out.println();
			// if(tt)
			// System.out.println("is unique tested without data structure.");
			// else
			// System.out.println("is not unique tested without data structure.");
			// System.out.print("The String to be validated: " + test + " ");
			// tt = method_with_data_structure(test.toString());
			// if(tt)
			// System.out.println("is unique tested with data structure.");
			// else
			// System.out.println("is not unique tested with data structure.");
			// System.out.println("===================");
		}
	}

	public static void reverse(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		System.out.println("result after reversing: " + sb.toString());
	}

	public static void reverseInPlace(String str) {
		char[] string = str.toCharArray();
		int h = 0;
		int e = str.length() - 1;
		while(h<=e){
			char temp = string[h];
			string[h] = string[e];
			string[e] = temp;
			h++;
			e--;
		}
		System.out.println("result after reversing: " + new String(string));
	}

}
