package leetcode;

/*
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

public class ContainerWithMostWater {
	public class Solution {
	    public int maxArea(int[] height) {
	    	
	    	if(height == null || height.length < 2) return 0;
	    	
	        int l = 0;
	        int r = height.length - 1;
	        int area = 0;
	        
	        while(l < r){
	        	int temp = (r - l) * Math.min(height[l], height[r]);
	            area = Math.max(area, temp);
	            if(height[l] < height[r])
	            	l++;
	            else
	            	r--;
	        }
	        
	        return area;
	    }
	}
}
