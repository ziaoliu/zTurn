package leetcode;

/*
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * http://stupidcodergoodluck.wordpress.com/2014/03/31/leetcode-integer-to-roman/
 * http://en.wikipedia.org/wiki/Roman_numerals
 */

public class Integer2RomanOJ {
	public class Solution {
		public String intToRoman(int num) {
			char[] symbol = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
			int[] value = { 1, 5, 10, 50, 100, 500, 1000 };
			StringBuilder sb = new StringBuilder();

			for (int i = value.length - 1; i >= 0 && num != 0;) {
				if (num / value[i] > 0) {
					sb.append(symbol[i]);
					num = num - value[i];
				} else if ((i == 1 || i == 3 || i == 5)
						&& (num + value[i - 1]) / value[i] > 0) {
					sb.append(symbol[i - 1]);
					sb.append(symbol[i]);
					num = num - (value[i] - value[i - 1]);
				} else if ((i == 2 || i == 4 || i == 6)
						&& (num + value[i - 2]) / value[i] > 0) {
					sb.append(symbol[i - 2]);
					sb.append(symbol[i]);
					num = num - (value[i] - value[i - 2]);
				} else
					i--;
			}
			return sb.toString();
		}
	} // end of solution
}
