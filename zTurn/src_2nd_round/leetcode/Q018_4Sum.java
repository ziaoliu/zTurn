package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 */
public class Q018_4Sum {
	public class Solution {
		public List<List<Integer>> fourSum(int[] nums, int target) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (nums == null || nums.length < 4)
				return result;
			Arrays.sort(nums);// <<<<<<<<< sort
			for (int a = 0; a < nums.length - 3; a++) {
				for (int b = a + 1; b < nums.length - 2; b++) {
					int c = b + 1;
					int d = nums.length - 1;

					while (c < d) {
						int sum = nums[a] + nums[b] + nums[c] + nums[d];
						if (sum == target) {
							List<Integer> list = new ArrayList<Integer>();
							list.add(nums[a]);
							list.add(nums[b]);
							list.add(nums[c]);
							list.add(nums[d]);
							if (!result.contains(list))
								result.add(list);
							c++;
							d--;
							while (c < d && nums[c] == nums[c - 1])
								c++;
							while (c < d && nums[d] == nums[d + 1])
								d--;

						} else if (sum > target)
							d--;
						else
							c++;
					}
				}
			}
			return result;
		}
	}
}
