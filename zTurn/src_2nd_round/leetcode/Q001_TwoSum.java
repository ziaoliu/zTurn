package leetcode;

import java.util.HashMap;

/*
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
 Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 
 http://blog.csdn.net/linhuanmars/article/details/19711387
 */
public class Q001_TwoSum {
	public class Solution {
		public int[] twoSum(int[] nums, int target) {
			int[] results = new int[2];

			if (nums == null || nums.length < 2)
				return results;

			// define map: <num to find, current index>
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(nums[i])) {
					int j = map.get(nums[i]);
					if (j > i) {
						results[0] = i + 1;
						results[1] = j + 1;
					} else {
						results[0] = j + 1;
						results[1] = i + 1;
					}
					break;
				} else {
					map.put(target - nums[i], i);

				}
			}
			return results;
		}
	}
}
