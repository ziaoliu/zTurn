package leetcode;

/* Unique Paths II
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 
 * The total number of unique paths is 2.
 * http://yucoding.blogspot.com/2013/04/leetcode-question-117-unique-path-ii.html
 * http://www.cnblogs.com/huntfor/p/3900291.html
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-unique-paths-i-ii.html
 */
public class UniquePaths2OJ {
	public static void main(String[] args) {
		Solution test = new UniquePaths2OJ().new Solution();
		test.uniquePathsWithObstacles(new int[][] { { 0, 1 } });
	}

	public class Solution {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {

			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;

			if (m == 0 || n == 0)
				return 0;
			if (m == 1 && n == 1)
				return obstacleGrid[0][0] == 1 ? 0 : 1;
			int[][] dp = new int[m][n];

			for (int i = 0; i < n; i++) {
				if (obstacleGrid[0][i] != 1)
					dp[0][i] = 1;
				else
					break;
			}
			for (int i = 0; i < m; i++) {
				if (obstacleGrid[i][0] != 1)
					dp[i][0] = 1;
				else
					break;
			}

			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					if (obstacleGrid[i][j] != 1) {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					} else
						dp[i][j] = 0;
				}
			}
			return dp[m - 1][n - 1];
		}
	}
}
