package leetcode;

/*
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. 
 If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 You are responsible to gather all the input requirements up front. 

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

 3/8/2015
 http://segmentfault.com/blog/code/1190000000452052
 */

public class String2IntegerOJ {

	public class Solution {
		public int atoi(String str) {
			if (null == str)
				return 0;
			if (str.length() < 0)
				return 0;

			char[] array = str.trim().toCharArray();
			boolean sign = false;
			int sum = 0;

			for (int i = 0; i < array.length; i++) {
				char temp = array[i];
				if (i == 0) {
					if (temp == '-') {
						sign = true;
						continue;
					} else if (temp == '+') {
						continue;
					}

				}
				if ("0123456789".indexOf(temp) >= 0) {

					int diff = temp - '0';

					if (sum > 214748364) {
						return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
					} else
						sum = sum * 10 + diff;

					if (sum < 0)
						return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				} else
					return sign ? -1 * sum : sum;

			}
			return sign ? -1 * sum : sum;
		}
	} // end of solution
}
