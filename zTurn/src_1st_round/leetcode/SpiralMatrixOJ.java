package leetcode;

/* Spiral Matrix
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * http://blog.csdn.net/linhuanmars/article/details/21667181
 */
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixOJ {
	public static void main(String[] args) {
		SpiralMatrixOJ solution = new SpiralMatrixOJ();
		Solution test = solution.new Solution();
		int[][] t = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(test.spiralOrder(t));
	}

	public class Solution {
		public List<Integer> spiralOrder(int[][] matrix) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			if (null == matrix || matrix.length == 0 || matrix[0].length == 0)
				return result;
			int min = Math.min(matrix.length, matrix[0].length);
			int level = min / 2;
			for (int l = 0; l < level; l++) {
				// top: move column to right
				for (int j = l; j < matrix[0].length - 1 - l; j++) {
					result.add(matrix[l][j]);
				}
				// right: move row down
				for (int i = l; i < matrix.length - 1 - l; i++) {
					result.add(matrix[i][matrix[0].length - 1 - l]);
				}
				// bottom: move column to left
				for (int j = matrix[0].length - 1 - l; j > l; j--) {
					result.add(matrix[matrix.length - 1 - l][j]);
				}
				// left: move row up
				for (int i = matrix.length - 1 - l; i > l; i--) {
					result.add(matrix[i][l]);
				}
			}
			if (min % 2 == 1)
				if (matrix.length > matrix[0].length) {
					for (int i = level; i < matrix.length - level; i++) {
						result.add(matrix[i][level]);
					}
				} else {
					for (int i = level; i < matrix[0].length - level; i++) {
						result.add(matrix[level][i]);
					}
				}
			return result;
		}// end of method
	}
}
