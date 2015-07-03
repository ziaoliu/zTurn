package cc150;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * Given two strings, write a method to decide if one is a permutation of the other.
 */

public class Chapter01Q03 {
	public static void main(String[] args) {

		int loops = 20;

		for (int i = 0; i < loops; i++) {
			StringBuilder test1 = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				String pool = "abcdefghijklmnopqrstuvwxyz1234567890";
				Random r = new Random();
				int random = r.nextInt(pool.length());
				test1.append(pool.charAt(random));
			}

			StringBuilder test2 = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				String pool = "abcdefghijklmnopqrstuvwxyz1234567890";
				Random r = new Random();
				int random = r.nextInt(pool.length());
				test2.append(pool.charAt(random));
			}

		}

		String s1 = "";
		String s2 = "";
		if (find(s1, s2))
			System.out.println("Permutation IT IS");

	}

	public static boolean find(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		
		int[] string = new int[256];

		int count = 0;
		for (char c : str1.toCharArray()) {
			if (string[c] == 0)
				count++;
			string[c]++;
		}

		for (char c : str2.toCharArray()) {
			string[c]--;
			if (string[c] == 0)
				count--;
			if (string[c] < 0)
				return false;
		}

		if (count != 0)
			return false;

		return true;
	}

}
