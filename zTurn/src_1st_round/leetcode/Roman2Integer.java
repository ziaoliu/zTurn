package leetcode;

/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * http://blog.csdn.net/wzy_1988/article/details/17057929
 */

public class Roman2Integer {
	public class Solution {
		public int romanToInt(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int result = helper(s.charAt(0));

			for (int i = 1; i <= s.length() - 1; i++) {
				int pre = helper(s.charAt(i - 1));
				int curr = helper(s.charAt(i));
				if (pre >= curr)
					result = result + curr;
				else
					result = result - pre - pre + curr;
			}

			return result;
		}

		public int helper(char c) {
			int number = 0;
			switch (c) {
			case 'I':
				number = 1;
				break;
			case 'V':
				number = 5;
				break;
			case 'X':
				number = 10;
				break;
			case 'L':
				number = 50;
				break;
			case 'C':
				number = 100;
				break;
			case 'D':
				number = 500;
				break;
			case 'M':
				number = 1000;
				break;
			}
			return number;
		}
	}
}
