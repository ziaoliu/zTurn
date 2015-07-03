package leetcode;

/* Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * http://www.programcreek.com/2012/12/leetcode-set-matrix-zeroes-java/
 */

public class SetMatrixZeroesOJ {
	public static void main(String[] args) {
		SetMatrixZeroesOJ test = new SetMatrixZeroesOJ();
		Solution s = test.new Solution();
		int[][] tt = { { 1 } };
		s.setZeroes(tt);
	}

	public class Solution {
		public void setZeroes(int[][] matrix) {
			if (null == matrix)
				return;
			int rowLen = 0; // m
			int colLen = 0; // n
			if (matrix.length != 0)
				rowLen = matrix.length;
			if (matrix[0].length != 0)
				colLen = matrix[0].length;

			System.out.println(rowLen + "" + colLen);

			boolean[] row = new boolean[rowLen];
			boolean[] col = new boolean[colLen];

			if (rowLen == 1) {
				boolean flag = false;
				for (int j = 0; j < colLen; j++) {
					if ((matrix[0][j] == 0 || col[j]) && !flag) {
						col[j] = true;
						flag = true;
					}
				}
				if (flag)
					for (int j = 0; j < colLen; j++) {
						matrix[0][j] = 0;
					}
				return;
			}
			if (colLen == 1) {
				boolean flag = false;
				for (int j = 0; j < rowLen; j++) {
					if ((matrix[j][0] == 0 || col[0]) && !flag) {
						row[j] = true;
						flag = true;
					}
				}
				if (flag)
					for (int j = 0; j < rowLen; j++) {
						matrix[j][0] = 0;
					}
				return;
			}
			for (int i = 0; i < rowLen; i++) {
				for (int j = 0; j < colLen; j++) {
					if (matrix[i][j] == 0) {
						row[i] = true;
						col[j] = true;
					}
				}
			}
			for (int i = 0; i < rowLen; i++) {
				for (int j = 0; j < colLen; j++) {
					if (row[i]) {
						matrix[i][j] = 0;
					}
					if (col[j]) {
						matrix[i][j] = 0;
					}
				}
			}

//			for (int i = 0; i < rowLen; i++) {
//				for (int j = 0; j < colLen; j++) {
//					System.out.print(matrix[i][j] + " ");
//				}
//				System.out.println();
//			}

		}// end of method
	}
}
