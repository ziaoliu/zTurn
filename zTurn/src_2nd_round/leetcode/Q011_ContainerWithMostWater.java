package leetcode;

public class Q011_ContainerWithMostWater {
	public class Solution {
		public int maxArea(int[] height) {
			if (height == null || height.length == 0)
				return 0;

			int i = 0;
			int j = height.length - 1;
			int max = 0;

			while (i < j) {
				int temp = (j - i) * Math.min(height[i], height[j]);
				max = Math.max(max, temp);
				if (height[i] < height[j])
					i++;
				else
					j--;
			}
			return max;
		}
	}
}
