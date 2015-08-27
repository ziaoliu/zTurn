package leetcode;

import java.util.LinkedList;

/*
 Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

 http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
 http://blog.csdn.net/linhuanmars/article/details/24444491
 */
public class Q085_MaximalRectangle {
	public class Solution {
		public int maximalRectangle(char[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
				return 0;
			int max = 0;
			int[] array = new int[matrix[0].length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					array[j] = matrix[i][j] == '0' ? 0 : array[j] + 1;
				}
				max = Math.max(max, max(array));
			}

			return max;
		}

		public int max(int[] array) {
			if (array == null || array.length == 0)
				return 0;
			int max = 0;
			LinkedList<Integer> stack = new LinkedList<>();
			for (int i = 0; i < array.length; i++) {
				while (!stack.isEmpty() && array[i] <= array[stack.peek()]) {
					int index = stack.pop();
					int area = 0;
					if (stack.isEmpty())
						area = i * array[index];
					else
						area = (i - stack.peek() - 1) * array[index];
					max = Math.max(max, area);
				}
				stack.push(i);
			}
			while (!stack.isEmpty()) {
				int index = stack.pop();
				int area = 0;
				if (stack.isEmpty())
					area = array.length * array[index];
				else
					area = (array.length - stack.peek() - 1) * array[index];
				max = Math.max(max, area);
			}

			return max;
		}
	}
}
