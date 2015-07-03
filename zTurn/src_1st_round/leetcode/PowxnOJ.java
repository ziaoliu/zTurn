package leetcode;

/* Pow(x, n) 
 * 
 * Implement pow(x, n).
 * 
 * Note: when n is negative, result is pow(1/x, n)
 * 
 * http://www.programcreek.com/2012/12/leetcode-powx-n/
 * http://blog.csdn.net/linhuanmars/article/details/20092829
 */

public class PowxnOJ {
	public class Solution {
		public double pow(double x, int n) {
			if (n < 0)
				return 1.0 / power(x, -n);
			else
				return power(x, n);
		}

		private double power(double x, int n) {
			if (n == 0)
				return 1;

			double value = power(x, n / 2);

			if (value % 2 == 0)
				return value * value;
			else
				return value * value * x;
		}
	}
}
