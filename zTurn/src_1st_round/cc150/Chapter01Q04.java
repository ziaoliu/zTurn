package cc150;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * Write a method to replace all spaces in a string with ¡®%20¡¯
 * Input:  "Mr John Smith    "
 * Output: "Mr%20John%20Smith"
 */

public class Chapter01Q04 {
	public static void main(String[] args) {

		int loops = 20;

		for (int i = 0; i < loops; i++) {

			StringBuilder test1 = new StringBuilder();
			// generate the base string
			for (int j = 0; j < 10; j++) {
				String pool = "ab cd efgh ij kl m no pqr stu vw xyz1 234 56 78 90 ";
				Random r = new Random();
				int random = r.nextInt(pool.length());
				test1.append(pool.charAt(random));
			}

			String test = test1.toString();
			char[] c = test.toCharArray();

			// process the string to the assumed string
			int h = 0;
			int e = test.length() - 1;

			int count = 0;

			while (h < e) {
				if (c[e] == ' ')
					e--;
				else {
					if (c[h] == ' ') {
						count++;
					}
					h++;
				}

			}

			int t = count * 2 - (test.length() - 1 - e);
			System.out.println("need " + t + " ' ' in the end.");
			System.out.println(test1.toString() + "|");

			if (t >= 0) {
				for (int w = 0; w < t; w++) {
					test1.append(' ');
				}
			} else {
				String temp = test1.toString();
				temp = temp.substring(0, test.length() + t);
				test1 = new StringBuilder(temp);
			}
			System.out.println("final string to be tested: " + test1.toString()
					+ "|length: " + test1.length());
			System.out.println("====");

			replace(test1.toString());
		}
		replace("mrjohnsmith");
		replace(" 7 sb i  y          ");

	}

	public static void replace(String str) {
		System.out.println("############################");
		System.out.println("input String is |" + str + "|");

		char[] array = str.toCharArray();
		int h = 0;
		int e = str.length() - 1;
		int p = e;
		while (p >= 0) {
			if (array[p] == ' ' && e == str.length() - 1) {
				p--;
				if (p == h) {
					System.out.println("No in between letters found!");
					array = str.toCharArray();
					break;
				}
			} else {
				if (array[p] != ' ') {
					array[e] = array[p];
					p--;
					e--;
				} else {
					e = e -3;
					array[e + 1] = '%';
					array[e + 2] = '2';
					array[e + 3] = '0';
					p--;
				}
			}

		}

		System.out.println("result string is: |" + new String(array) + "|");
		System.out.println("############################");

	}

}
