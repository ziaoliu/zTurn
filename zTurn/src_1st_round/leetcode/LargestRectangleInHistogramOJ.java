package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/* Largest Rectangle in Histogram
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 * http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * http://blog.csdn.net/linhuanmars/article/details/20524507
 * http://fisherlei.blogspot.com/2012/12/leetcode-largest-rectangle-in-histogram.html
 */
public class LargestRectangleInHistogramOJ {
	public class Solution {

		// O(n) solution
		public int largestRectangleArea(int[] height) {
			if (null == height)
				return 0;

			int max = 0;
			int i = 0;

			int[] array = new int[height.length + 1];
			array = Arrays.copyOf(height, height.length + 1);

			// key point: keeps track of indexes
			// stack will be incremental
			LinkedList<Integer> stack = new LinkedList<Integer>();

			while (i < array.length) {
				if (stack.isEmpty() || array[i] >= array[stack.peek()]) {
					stack.push(i++);
				} else {
					int tempHeight = stack.pop();
					int tempArea = array[tempHeight]
							* (stack.isEmpty() ? i : i - stack.peek() - 1);
					max = Math.max(max, tempArea);
				}
			}

			return max;
		}

		// time out solution
		public int largestRectangleAreaTLE(int[] height) {
			if (null == height)
				return 0;

			int max = 0;

			for (int i = 0; i < height.length; i++) {
				if (i + 1 < height.length && height[i] <= height[i + 1])
					continue;
				int tempMinHeight = height[i];
				for (int j = i; j >= 0; j--) {
					if (height[j] < tempMinHeight)
						tempMinHeight = height[j];
					int tempArea = tempMinHeight * (i - j + 1);
					if (tempArea > max)
						max = tempArea;
				}
			}
			return max;
		}// end of method
	}
}
