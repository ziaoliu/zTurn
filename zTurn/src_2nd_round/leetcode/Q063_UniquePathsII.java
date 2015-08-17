package leetcode;

/*
 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.
 */
public class Q063_UniquePathsII {
	public class Solution {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			if (obstacleGrid == null)
				return 0;
			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;
			int[][] matrix = new int[m][n];

			for (int i = 0; i < m; i++) {
				if (obstacleGrid[i][0] == 1)
					break;
				matrix[i][0] = 1;
			}
			for (int i = 0; i < n; i++) {
				if (obstacleGrid[0][i] == 1)
					break;
				matrix[0][i] = 1;
			}
			for (int i = 1; i < m; i++)
				for (int j = 1; j < n; j++) {
					if (obstacleGrid[i][j] != 1)
						matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
					else
						matrix[i][j] = 0;
				}

			return matrix[m - 1][n - 1];
		}
	}
}
