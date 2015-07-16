package leetcode;

import java.util.Arrays;

/*
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 http://www.cnblogs.com/springfor/p/3860175.html
 */
public class Q016_3SumClosest {
	public class Solution {
		public int threeSumClosest(int[] nums, int target) {
			int result = 0;
			int min = Integer.MAX_VALUE;

			if (nums == null || nums.length < 3)
				return min;

			Arrays.sort(nums); // need to be sorted

			for (int i = 0; i < nums.length - 2; i++) {
				int temp = target - nums[i]; // have to prepare the target
				int start = i + 1;
				int end = nums.length - 1;
				while (start < end) {
					int diff = temp - nums[start] - nums[end];
					if (Math.abs(diff) < min) {
						result = nums[i] + nums[start] + nums[end];
						min = Math.abs(diff);
					}
					if (nums[start] + nums[end] == temp)
						return target;
					else if (nums[start] + nums[end] > temp)
						end--;
					else
						start++;

				}
			}
			return result;
		}
	}
}
