package leetcode;

/*
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front. 

 Possible input cases:

 1. "", empty string

 2. "123", simple valid string

 3. "+123", valid string with '+' sign

 4. "-123", valid string with '-' sign

 5. " 123abc ", string with space and other characters

 6. "abc123", invalid input string

 7. "33333333333333", "-3333333333333", invalid overflow string

 http://www.cnblogs.com/freeneng/archive/2013/04/15/3022107.html
 http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
 */

public class String2Integer {
	public static void main(String[] args) {
		String2Integer ss = new String2Integer();
		Solution s = ss.new Solution();
		System.out.println(s.atoi("1"));
	}

	public class Solution {
		public int atoi(String str) {

			if (str == null || str.equals(""))
				return 0;

			String newStr = str.trim();
			if (newStr.equals(""))
				return 0;

			char sign = '+';
			int index = 0;
			double result = 0;

			if (newStr.charAt(0) == '-') {
				sign = '-';
				index++;
			} else if (newStr.charAt(index) == '+')
				index++;

			while (index < newStr.length() && newStr.charAt(index) >= '0'
					&& newStr.charAt(index) <= '9') {
				result = result * 10 + (newStr.charAt(index) - '0');
				index++;
			}

			if (sign == '-')
				result = result * (-1);

			if (result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if (result < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;

			return (int) result;
		}
	}
}
