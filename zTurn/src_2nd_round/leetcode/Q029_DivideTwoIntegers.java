package leetcode;

/*
 Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.

 http://www.cnblogs.com/huntfor/p/3899984.html
 */
public class Q029_DivideTwoIntegers {
	public class Solution {
		public int divide(int dividend, int divisor) {
			if (dividend == 0)
				return 0;

			if (divisor == 0)
				return Integer.MAX_VALUE;

			long absDividend = Math.abs((long) dividend);
			long absDivisor = Math.abs((long) divisor);

			int result = 0;

			if (absDividend < absDivisor)
				return 0;

			while (absDividend >= absDivisor) {
				long dup = absDivisor; // increase divisor by x times
				int temp = 1; // count x times factor
				while (absDividend > dup) {
					dup = dup << 1;
					temp = temp << 1;
				}
				if (absDividend != dup) {
					dup = dup >> 1;
					temp = temp >> 1;
				}
				result = result + temp;
				if (result < 0) // check for overflow
					return (dividend > 0) ^ (divisor > 0) ? Integer.MIN_VALUE
							: Integer.MAX_VALUE;
				absDividend = absDividend - dup;

			}

			return result * ((dividend > 0) ^ (divisor > 0) ? -1 : 1);
		}
	}
}
