package leetcode;

/* Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *  Integers in each row are sorted from left to right.
 *  The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 * Given target = 3, return true.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24216235
 * http://www.cnblogs.com/springfor/p/3857959.html
 * http://www.programcreek.com/2013/01/leetcode-search-a-2d-matrix-java/
 */
public class SearchA2DMatrixOJ {
	public class Solution {
		public boolean searchMatrix(int[][] matrix, int target) {
			if (null == matrix)
				return false;
			int start = 0;
			int end = matrix.length - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (target == matrix[mid][0])
					return true;
				else if (target < matrix[mid][0])
					end = mid - 1;
				else
					start = mid + 1;
			}
			int targetRow = end; // !!!!!!!!!!!
			if (targetRow < 0)
				return false;

			start = 0;
			end = matrix[targetRow].length - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (target == matrix[targetRow][mid])
					return true;
				else if (target < matrix[targetRow][mid])
					end = mid - 1;
				else
					start = mid + 1;
			}

			return false;
		}

		public boolean searchMatrixFirstAttempt(int[][] matrix, int target) {
			if (null == matrix)
				return false;
			int rowNo = matrix.length;
			if (target > matrix[matrix.length - 1][matrix[0].length - 1])
				return false;
			for (int i = 0; i < matrix.length; i++) {
				if (target == matrix[i][0])
					return true;
				else if (target < matrix[i][0]) {
					rowNo = i - 1;
					break;
				}
			}
			if (rowNo == -1)
				return false;
			if (rowNo == matrix.length)
				rowNo = matrix.length - 1;

			for (int i = 0; i < matrix[0].length; i++) {
				if (matrix[rowNo][i] == target)
					return true;
			}

			return false;
		}// end of method
	}
}
