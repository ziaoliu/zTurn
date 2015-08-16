package leetcode;

/*
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid 
 (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 http://www.cnblogs.com/springfor/p/3886603.html
 http://siddontang.gitbooks.io/leetcode-solution/content/dynamic_programming/unique_paths.html
 */
public class Q062_UniquePaths {
	public class SolutionRecurr {
		public int uniquePaths(int m, int n) {
			return recur(0, 0, m, n);
		}

		private int recur(int row, int col, int m, int n) {
			if (row == m && col == n)
				return 1;
			if (row > m || col > n)
				return 0;
			return recur(row + 1, col, m, n) + recur(row, col + 1, m, n);
		}
	}

	public class Solution {
		public int uniquePaths(int m, int n) {
			if (m == 0 && n == 0)
				return 1;
			int[][] matrix = new int[m][n];
			for (int i = 0; i < m; i++)
				matrix[i][0] = 1;
			for (int i = 0; i < n; i++)
				matrix[0][i] = 1;
			for (int i = 1; i < m; i++)
				for (int j = 1; j < n; j++)
					matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
			return matrix[m - 1][n - 1];
		}
	}
}
