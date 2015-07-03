package leetcode;

/*
 Reverse Integer

 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321 

 Note: need to consider integer overflow
 */

public class ReverseIntegerOJ {
	public class Solution {
		public int reverse(int x) {

			if (x == 0) {
				return x;
			}

			boolean flag = false;

			if (x < 0) {
				x = -1 * x;
				flag = true;
			}

			int sum = 0;

			for (int i = 0; x > 0; i++) {

				int temp = x % 10;
				sum = sum * 10 + temp;
				x = x / 10;
				if (x > 0 && sum > 214748364)
					return 0;
			}

			return flag ? -1 * sum :  sum;
		}
	} // end of solution
}
