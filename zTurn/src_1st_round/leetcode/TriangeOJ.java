package leetcode;

import java.util.List;

/*
 *  Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 *  For example, given the following triangle
 *  [
 *  [2],
 *  [3,4],
 *  [6,5,7],
 *  [4,1,8,3]
 *  ]
 *  The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 *  Note:
 *  Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *  
 *  http://blog.csdn.net/linhuanmars/article/details/23230657
 *  http://www.cnblogs.com/TenosDoIt/p/3436532.html
 */

public class TriangeOJ {
	public class Solution {
		public int minimumTotal(List<List<Integer>> triangle) {
			if (triangle == null || triangle.size() == 0)
				return 0;
			if (triangle.size() == 1)
				return triangle.get(0).get(0);

			List<Integer> list = triangle.get(triangle.size() - 1);
			int[] dp = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				dp[i] = list.get(i);
			}
			for (int i = triangle.size() - 2; i >= 0; i--) {
				for (int j = 0; j <= i; j++) {
					dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
				}
			}
			return dp[0];
		}// end of method
	}
}
