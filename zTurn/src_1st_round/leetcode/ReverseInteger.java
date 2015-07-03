package leetcode;

/*
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321 
 
 Note: need to consider integer overflow
 */

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		Solution s = ri.new Solution();
		System.out.println(s.reverse(123));
	}

	public class Solution {
		public int reverse(int x) {
			int flag = 1;
			if (x < 0) {
				flag = -1;
				x = x * flag;
			}

			int result = 0;

			while (x > 0) {
				int digit = x % 10;
				x = x / 10;
				result = result * 10 + digit;
				if (result * 10 > Integer.MAX_VALUE)
					return -1;
			}

			return result * flag;
		}
	}
}
