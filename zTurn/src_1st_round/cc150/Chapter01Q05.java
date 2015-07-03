package cc150;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * Implement a method to perform basic string compression using the counts 
 * of repeated characters. For example, the string aabcccccaaa would become 
 * a2blc5a3. If the "compressed" string would not become smaller than the original string, 
 * your method should return the original string.
 */

public class Chapter01Q05 {
	public static void main(String[] args) {

		int loops = 20;

		for (int i = 0; i < loops; i++) {
			StringBuilder test = new StringBuilder();
			for (int j = 0; j < 10; j++) {
				String pool = "abcde";
				Random r = new Random();
				int random = r.nextInt(pool.length());
				for (int k = 0; k < random - 1; k++)
					test.append(pool.charAt(random));
			}
			System.out.println(test.toString());
			// compress(test.toString());
			System.out.println("The output of the perfect compression is: "
					+ pefectCompress(test.toString()));

		}
		// compress("aabbbccdddda");

		 System.out.println("The output of the perfect compression is: "
		 + pefectCompress("abcf"));

	}

	// weak case: does not handle the case when compressed string is longer
	public static void compress(String str) {
		char[] array = str.toCharArray();
		char s = array[0];
		int count = 1;
		System.out.println("length is: " + countCompressedString(str));
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		for (int i = 1; i < str.length(); i++) {
			if (s != array[i]) {
				sb.append(count);
				sb.append(array[i]);
				count = 1;
				s = array[i];
			} else
				count++;
		}
		sb.append(count);
		System.out.println("result string: " + sb.toString());
	}

	public static String pefectCompress(String str) {
		int compressedStrLength = countCompressedString(str);
		if (compressedStrLength > str.length())
			return str;

		char[] newStr = new char[compressedStrLength];
		char[] c = str.toCharArray();
		char s = c[0];

		newStr[0] = s;

		int count = 1;
		int p = 1;

		for (int i = 1; i < str.length(); i++) {
			if (c[i] == s)
				count++;
			else {
				String sizeOfCount = String.valueOf(count);
				for (char t : sizeOfCount.toCharArray()) {
					newStr[p++] = t;
				}
				newStr[p] = c[i];
				p++;
				count = 1;
				s = c[i];
			}
		}
		String sizeOfCount = String.valueOf(count);
		for (char t : sizeOfCount.toCharArray()) {
			newStr[p++] = t;
		}
		return new String(newStr);

	}

	public static int countCompressedString(String str) {

		char[] c = str.toCharArray();
		char s = c[0];

		int count = 1;
		int size = 0;

		for (int i = 1; i < str.length(); i++) {
			if (c[i] == s)
				count++;
			else {
				size = size + 1 + String.valueOf(count).length();
				count = 1;
				s = c[i];
			}
		}
		size = size + String.valueOf(count).length() + 1;
		return size;
	}

}
