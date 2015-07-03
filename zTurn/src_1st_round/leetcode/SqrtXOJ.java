package leetcode;

/* Sqrt(x) 
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * http://www.cnblogs.com/AnnieKim/archive/2013/04/18/3028607.html
 * http://yucoding.blogspot.com/2013/03/leetcode-question-102-sqrtx.html
 */

public class SqrtXOJ {
	public class Solution {
		public int mySqrt(int x) {
			if (x <= 0)
				return 0;
			if (x == 1)
				return 1;

			long i = 0;
			long j = x / 2 + 1;

			while (i <= j) {
				long mid = (i + j) / 2;
				long squre = mid * mid;
				if(squre == x)
					return (int)mid;
				else if(squre < x)
					i = mid + 1;
				else
					j = mid - 1;
			}

			return (int)j;
		}
	}
}
