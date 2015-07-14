package leetcode;

/*
 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.

 https://stupidcodergoodluck.wordpress.com/2014/03/31/leetcode-integer-to-roman/
 */
public class Q012_IntegerToRoman {
	public static void main(String[] args) {
		Q012_IntegerToRoman test = new Q012_IntegerToRoman();
		Solution tt = test.new Solution();
		System.out.println(tt.intToRoman(4));
	}

	public class Solution {
		public String intToRoman(int num) {
			String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
					"X", "IX", "V", "IV", "I" };
			int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
					1 };

			StringBuilder result = new StringBuilder();

			for (int i = 0; i < symbols.length; i++) {
				while (num >= values[i]) {
					result.append(symbols[i]);
					num = num - values[i];
				}
			}

			return result.toString();
		}
	}
}
