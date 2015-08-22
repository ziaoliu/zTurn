package leetcode;

/*
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 http://fisherlei.blogspot.com/2013/01/leetcode-set-matrix-zeroes.html
 http://46aae4d1e2371e4aa769798941cef698.devproxy.yunshipei.com/linhuanmars/article/details/24066199
 */
public class Q073_SetMatrixZeros {
	public class Solution {
		public void setZeroes(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return;
			boolean firstRow = false;
			boolean firstCol = false;
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][0] == 0) {
					firstCol = true;
					break;
				}
			}
			for (int i = 0; i < matrix[0].length; i++) {
				if (matrix[0][i] == 0) {
					firstRow = true;
					break;
				}
			}
			for (int i = 1; i < matrix.length; i++)
				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[i][j] == 0) {
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
				}
			for (int i = 1; i < matrix.length; i++)
				for (int j = 1; j < matrix[0].length; j++) {
					if (matrix[i][0] == 0 || matrix[0][j] == 0)
						matrix[i][j] = 0;
				}
			if (firstRow)
				for (int i = 0; i < matrix[0].length; i++)
					matrix[0][i] = 0;
			if (firstCol)
				for (int i = 0; i < matrix.length; i++)
					matrix[i][0] = 0;
		}
	}
}
