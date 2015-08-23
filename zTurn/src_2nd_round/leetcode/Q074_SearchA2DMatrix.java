package leetcode;

/*
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.

 http://www.cnblogs.com/springfor/p/3857959.html
 */
public class Q074_SearchA2DMatrix {
	public static void main(String[] args) {
		Q074_SearchA2DMatrix test = new Q074_SearchA2DMatrix();
		Solution s = test.new Solution();
		int[][] tt = { { 1, 3 } };
		System.out.println(s.searchMatrix(tt, 2));
	}

	public class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return false;
			int m = matrix.length;
			int n = matrix[0].length;
			int rowStart = 0;
			int rowEnd = m - 1;
			while (rowStart <= rowEnd) {
				int rowMid = (rowStart + rowEnd) / 2;
				if (target == matrix[rowMid][0])
					return true;
				if (target < matrix[rowMid][0])
					rowEnd = rowMid - 1;
				else if (target > matrix[rowMid][n - 1])
					rowStart = rowMid + 1;
				// if(matrix[i][0] <= n && n <= matrix[i][n-1])
				else {
					int colStart = 0;
					int colEnd = n - 1;
					while (colStart <= colEnd) {
						int colMid = (colStart + colEnd) / 2;
						if (target == matrix[rowMid][colMid])
							return true;
						if (target < matrix[rowMid][colMid])
							colEnd = colMid - 1;
						else { // if(n > matrix[rowMid][colMid])
							colStart = colMid + 1;
						}
					}
					return false;
				}
			}
			return false;
		}// end of method
	}
}
