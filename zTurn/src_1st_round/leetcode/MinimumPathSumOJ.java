package leetcode;

/* Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * http://fisherlei.blogspot.com/2012/12/leetcode-minimum-path-sum.html
 * http://blog.csdn.net/linhuanmars/article/details/22257673
 */

public class MinimumPathSumOJ {
	public class Solution {
		public int minPathSum(int[][] grid) {
			if (grid == null)
				return 0;
			int m = grid.length;
			int n = grid[0].length;
			if (m == 0 || n == 0)
				return 0;
			if (m == 1 && n == 1)
				return grid[0][0];
			int[][] dp = new int[m][n];
			dp[0][0] = grid[0][0];
			for (int i = 1; i < n; i++) {
				dp[0][i] = dp[0][i - 1] + grid[0][i];
			}
			for (int i = 1; i < m; i++) {
				dp[i][0] = dp[i - 1][0] + grid[i][0];
			}
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
				}
			}
			return dp[m - 1][n - 1];
		}
	}
}
