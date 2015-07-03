package leetcode;

/* Multiply Strings 
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * http://www.cnblogs.com/TenosDoIt/p/3735309.html
 * https://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/
 */
public class MultiplyStringsOJ {
	public class Solution {
		public String multiply(String num1, String num2) {
			if (null == num1 || null == num2)
				return null;
			if (num1.length() == 0 || num2.length() == 0)
				return null;

			num1 = new StringBuilder(num1).reverse().toString();
			num2 = new StringBuilder(num2).reverse().toString();

			int[] temp = new int[num1.length() + num2.length()];

			for (int i = 0; i < num2.length(); i++) {
				int a = num2.charAt(i) - '0';
				for (int j = 0; j < num1.length(); j++) {
					int b = num1.charAt(j) - '0';
					temp[i + j] = temp[i + j] + a * b;
				}
			}

			StringBuilder result = new StringBuilder();
			for (int i = 0; i < temp.length; i++) {
				int digit = temp[i] % 10;
				int carryOver = temp[i] / 10;
				result.insert(0, digit);
				if (i < temp.length - 1 && carryOver != 0) 
					temp[i + 1] = temp[i + 1] + carryOver;
			}

			while (result.length() > 0 && result.charAt(0) == '0') {
				result.deleteCharAt(0);
			}

			return result.length() == 0 ? "0" : result.toString();
		}// end of method

	}
}
