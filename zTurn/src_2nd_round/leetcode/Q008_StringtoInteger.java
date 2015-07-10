package leetcode;

/*
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, 
 please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 You are responsible to gather all the input requirements up front.

 */
public class Q008_StringtoInteger {
	public class Solution {
		public int myAtoi(String str) {
			if (str == null || str.length() == 0)
				return 0;

			char[] array = str.trim().toCharArray();
			boolean negative = false;

			int result = 0;
			for (int i = 0; i < array.length; i++) {
				char curr = array[i];
				if (i == 0) {
					if (curr == '-') {
						negative = true;
						continue;
					}
					if (curr == '+')
						continue;
				}
				if (curr >= '0' && curr <= '9') {
					// overflow
					if (result > Integer.MAX_VALUE / 10)
						return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

					result = result * 10 + (curr - '0');

					// overflow
					if (result < 0)
						return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

				} else
					return negative ? result * -1 : result;
			}
			return negative ? result * -1 : result;
		}
	}
}
