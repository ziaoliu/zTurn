package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/* Maximal Rectangle
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * 
 * http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
 * http://blog.csdn.net/linhuanmars/article/details/24444491
 */
public class MaximalRectangleOJ {
	public class Solution {
		public int maximalRectangle(char[][] matrix) {
			if (null == matrix || matrix.length == 0 || matrix[0].length == 0)
				return 0;
			int max = 0;
			int[] height = new int[matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					height[j] = (matrix[i][j] == '1') ? height[j] + 1 : 0;
				}
				max = Math.max(max, largestRectangleArea(height));
			}
			return max;
		}// end of method

		public int largestRectangleArea(int[] height) {
			if (null == height || height.length==0)
				return 0;
			int max = 0;
			int i = 0;
			LinkedList<Integer> stack = new LinkedList<Integer>();
			int[] array = new int[height.length + 1];
			array = Arrays.copyOf(height, height.length + 1);

			while (i < array.length) {
				if (stack.isEmpty() || array[i] >= array[stack.peek()])
					stack.push(i++);
				else {
					int tempHeight = stack.pop();
					
					//tempHeight to get the index of the height
					int tempArea = array[tempHeight]
							* (stack.isEmpty() ? i : i - stack.peek() - 1);
					max = Math.max(max, tempArea);
				}
			}

			return max;
		}// end of largestRectangleArea

	}
}
