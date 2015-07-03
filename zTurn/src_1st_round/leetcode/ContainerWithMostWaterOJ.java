package leetcode;

/* 
 * Container With Most Water
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container. 
 * 
 * https://oj.leetcode.com/discuss/1074/anyone-who-has-a-o-n-algorithm
 * http://www.cnblogs.com/lautsie/p/3219461.html
 * http://jane4532.blogspot.com/2013/05/container-with-most-water-leetcode.html
 */

public class ContainerWithMostWaterOJ {
	public class Solution {
		public int maxArea(int[] height) {
			if(null == height)
				return 0;
			if(height.length <= 1)
				return 0;
			
			int max = 0;
			
			int start = 0;
			int end = height.length - 1;
			
			while(end > start){
				
				int temp = (end - start) * Math.min(height[start], height[end]);
				if(temp > max)
					max = temp;
				if(height[start] > height[end])
					end--;
				else
					start++;
			}
			return max;
		}
	} // end of solution
}
