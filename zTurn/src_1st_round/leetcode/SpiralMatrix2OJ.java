package leetcode;

/* Spiral Matrix
 * 
 *Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * https://leetcodenotes.wordpress.com/2013/11/23/leetcode-spiral-matrix-%E6%8A%8A%E4%B8%80%E4%B8%AA2d-matrix%E7%94%A8%E8%9E%BA%E6%97%8B%E6%96%B9%E5%BC%8F%E6%89%93%E5%8D%B0/
 */

public class SpiralMatrix2OJ {
	public static void main(String[] args) {
		SpiralMatrix2OJ solution = new SpiralMatrix2OJ();
		Solution test = solution.new Solution();
		int n = 2;
		int[][] t = test.generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public class Solution {
		public int[][] generateMatrix(int n) {
			if (n == 0)
				return new int[][] {};

			if (n == 1)
				return new int[][] { { 1 } };

			int[][] result = new int[n][n];
			int now = 1;
			int level = n / 2;

			for (int l = 0; l < level; l++) {
				// top
				for (int j = l; j < n - l - 1; j++) {
					result[l][j] = now++;
				}
				// right
				for (int i = l; i < n - l - 1; i++) {
					result[i][n - l - 1] = now++;
				}
				// bottom
				for (int j = n - l - 1; j > l; j--) {
					result[n - l - 1][j] = now++;
				}
				// left
				for (int i = n - l - 1; i > l; i--) {
					result[i][l] = now++;
				}
			}
			if (n % 2 == 1)
				result[level][level] = now;
			return result;
		}// end of method
	}
}
