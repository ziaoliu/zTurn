package leetcode;

import java.util.ArrayList;

/* Gray Code
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
 * A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * http://www.cnblogs.com/springfor/p/3889222.html
 * http://blog.csdn.net/linhuanmars/article/details/24511221
 * http://blog.csdn.net/worldwindjp/article/details/21536103
 */
public class GrayCodeOJ {
	public class Solution {
		public ArrayList<Integer> grayCode(int n) {
			if (n == 0) {
				ArrayList<Integer> results = new ArrayList<Integer>();
				results.add(0);
				return results;
			}

			ArrayList<Integer> half = grayCode(n - 1);
			int add = 1 << (n - 1);
			ArrayList<Integer> results = new ArrayList<Integer>(half);
			for (int i = half.size() - 1; i >= 0; i--) {
				results.add(results.get(i) + add);
			}
			return results;
		}
	}
}
