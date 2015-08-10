package leetcode;

/*
 Implement pow(x, n).
 Raise to power
 Returns base raised to the power exponent.
 */
public class Q050_Powxn {
	public class Solution {
		public double myPow(double x, int n) {
			if (n < 0)
				return 1 / power(x, -n);
			else
				return power(x, n);
		}

		private double power(double x, int n) {
			if (n == 0)
				return 1;

			double value = power(x, n / 2);

			if (n % 2 == 0)
				return value * value;
			else
				return value * value * x;

		}
	}
}
