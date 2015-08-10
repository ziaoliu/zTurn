package leetcode;

/*
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 */
public class Q048_RotateImage {
	public class Solution {
		public void rotate(int[][] matrix) {
			if (matrix == null || matrix.length == 0)
				return;

			int n = matrix.length;

			for (int i = 0; i < n / 2; i++) {// col
				for (int j = i; j < n - 1 - i; j++) {// row
					int temp = matrix[i][j];
					matrix[i][j] = matrix[n - 1 - j][i];
					matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
					matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
					matrix[j][n - 1 - i] = temp;
				}
			}
		}// end of method
	}
}
