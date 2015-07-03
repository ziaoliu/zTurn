package leetcode;

/* Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * 
 */
public class RotateImageOJ {
	public class Solution {
		public void rotate(int[][] matrix) {
			if (null == matrix)
				return;

			int n = matrix.length;

			for (int i = 0; i < n / 2; i++) {
				for (int j = i; j < n - 1 - i; j++) {
					int temp = matrix[i][j]; // top
					matrix[i][j] = matrix[n - 1 - j][i]; // left
					matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // bottom
					matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];// right
					matrix[j][n - 1 - i] = temp;// copy top to right
				}
			}
		}// end of method
	}
}
