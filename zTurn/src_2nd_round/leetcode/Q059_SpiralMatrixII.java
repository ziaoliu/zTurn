package leetcode;

/*
 Given an integer n, generate a square matrix filled with elements from 1 to n*n in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class Q059_SpiralMatrixII {
	public class Solution {
		public int[][] generateMatrix(int n) {
			int[][] result = new int[n][n];
			if (n == 0)
				return result;

			int count = 1;
			int level = n / 2;
			for (int i = 0; i < level; i++) {
				for (int j = i; j < n - 1 - i; j++)
					result[i][j] = count++;
				for (int j = i; j < n - 1 - i; j++)
					result[j][n - 1 - i] = count++;
				for (int j = n - 1 - i; j > i; j--)
					result[n - 1 - i][j] = count++;
				for (int j = n - 1 - i; j > i; j--)
					result[j][i] = count++; // < =========== columns
			}

			if (n % 2 == 1) {
				result[level][level] = count;
			}

			return result;
		}
	}
}
