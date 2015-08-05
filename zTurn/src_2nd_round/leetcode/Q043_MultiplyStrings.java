package leetcode;

/*
 Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.

 https://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/comment-page-1/#comment-179
 */
public class Q043_MultiplyStrings {
	public static void main(String[] args) {
		Q043_MultiplyStrings test = new Q043_MultiplyStrings();
		Solution t = test.new Solution();
		System.out.println(t.multiply("0", "0"));
	}

	public class Solution {
		public String multiply(String num1, String num2) {
			if (num1 == null || num2 == null || num1.length() == 0
					|| num2.length() == 0)
				return "0";

			num1 = new StringBuilder(num1).reverse().toString();
			num2 = new StringBuilder(num2).reverse().toString();

			int[] sum = new int[num1.length() + num2.length()];

			// find multiplication digit by digit
			for (int i = 0; i < num2.length(); i++) {
				int one = num2.charAt(i) - '0';
				for (int j = 0; j < num1.length(); j++) {
					int two = num1.charAt(j) - '0';
					sum[i + j] = sum[i + j] + one * two;
				}
			}

			StringBuilder result = new StringBuilder();
			// sum up all digits
			for (int i = 0; i < sum.length; i++) {
				int carryOver = sum[i] / 10;
				int digit = sum[i] % 10;
				result.insert(0, digit);
				if (carryOver > 0 && i + 1 < sum.length)
					sum[i + 1] = sum[i + 1] + carryOver;
			}

			// trim leading 0
			while (result.length() > 0 && result.charAt(0) == '0')
				result.deleteCharAt(0);

			return result.length() == 0 ? "0" : result.toString();
		}
	}
}
