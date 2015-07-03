package leetcode;

/* Divide Two Integers
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * 
 * http://www.lifeincode.net/programming/leetcode-divide-two-integers-java/
 * http://www.cnblogs.com/huntfor/p/3899984.html
 */

public class DivideTwoIntegersOJ {
	public static void main(String[] args) {
		DivideTwoIntegersOJ test = new DivideTwoIntegersOJ();
		Solution s = test.new Solution();
		long start = System.currentTimeMillis();
		System.out.println(s.divide(-2147483648, -1));
		long end = System.currentTimeMillis();
		//System.out.println((end - start));
	}

	public class Solution {
		public int divide(int dividend, int divisor) {
			if (divisor == 0)
				return Integer.MAX_VALUE;
			if (divisor == 1)
				return dividend;
			if (dividend == 0)
				return 0;
			if (dividend == Integer.MIN_VALUE && divisor == -1)
			    return Integer.MAX_VALUE;
			
			boolean flag = false;
			
			if (dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0)
				flag = false;
			else
				flag = true;
			
			int result = 0;
			long longDividend = Math.abs((long)dividend);
			long longDivisor = Math.abs((long)divisor);

			if (longDividend < longDivisor)
				return 0;

			while (longDividend >= longDivisor) {
				long counter = 1;
				long temp = longDivisor;
				while (temp < longDividend) {
					temp = temp << 1;
					counter = counter << 1;
				}
				if (temp != longDivisor) {
					temp = temp >> 1;
					counter = counter >> 1;
				}
				result = result + (int) counter;
				longDividend = longDividend - temp;
			}

			return flag ? -result : result;
		}

	}
}
