package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/*
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 find the area of largest rectangle in the histogram.
 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given height = [2,1,5,6,2,3],
 return 10.

 http://blog.csdn.net/linhuanmars/article/details/20524507
 http://fisherlei.blogspot.com/2012/12/leetcode-largest-rectangle-in-histogram.html
 http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 */
public class Q084_LargestRectangleInHistogram {
	public class Solution {
		public int largestRectangleArea(int[] height) {
			if (height == null || height.length == 0)
				return 0;
			int max = 0;
			LinkedList<Integer> stack = new LinkedList<>();
			for (int i = 0; i < height.length; i++) {
				while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
					int index = stack.pop();
					int area = 0;
					if (stack.isEmpty())
						area = i * height[index];
					else
						area = (i - stack.peek() - 1) * height[index];
					max = Math.max(area, max);
				}
				stack.push(i);
			}

			while (!stack.isEmpty()) {
				int index = stack.pop();
				int area = 0;
				if (stack.isEmpty())
					area = height.length * height[index];
				else
					area = (height.length - stack.peek() - 1) * height[index];
				max = Math.max(area, max);
			}
			return max;
		}
	}

	public class SolutionOJ {
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
	}
}
