package leetcode;

/*
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class Q007_ReverseInteger {
	public class Solution {
		public int reverse(int x) {
			if (x == 0)
				return x;

			boolean neg = false;
			if (x < 0) {
				neg = true;
				x = x * -1;
			}

			int result = 0;
			while (x > 0) {
				result = result * 10 + x % 10;
				x = x / 10;
				if (result > Integer.MAX_VALUE / 10 && x > 0)
					return 0; // overflow

			}

			return neg ? result * -1 : result;
		}
	}
}
