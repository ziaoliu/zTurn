package leetcode;

/*
 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class Q013_RomanToInteger {
	public class Solution {
		public int romanToInt(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int result = 0;
			int i = 0;
			while (i < s.length()) {
				String curr = s.substring(i, i + 1);
				String next = "";
				int temp = -1;
				if (i < s.length() - 1) {
					next = s.substring(i + 1, i + 2);
					if (help(next) > help(curr))
						temp = help(s.substring(i, i + 2));
				}
				if (temp != -1) {
					result = result + temp;
					i = i + 2;
				} else {
					result = result + help(curr);
					i++;
				}
			}
			return result;
		}

		// String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
		// "X", "IX", "V", "IV", "I" };
		// int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
		// 1 };
		private int help(String str) {
			int result = 0;
			switch (str) {
			case "M":
				result = 1000;
				break;
			case "CM":
				result = 900;
				break;
			case "D":
				result = 500;
				break;
			case "CD":
				result = 400;
				break;
			case "C":
				result = 100;
				break;
			case "XC":
				result = 90;
				break;
			case "L":
				result = 50;
				break;
			case "XL":
				result = 40;
				break;
			case "X":
				result = 10;
				break;
			case "IX":
				result = 9;
				break;
			case "V":
				result = 5;
				break;
			case "IV":
				result = 4;
				break;
			case "I":
				result = 1;
				break;
			default:
				result = 0;
				break;
			}
			return result;
		}

	}
}
