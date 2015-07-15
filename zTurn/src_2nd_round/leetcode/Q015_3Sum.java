package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)

 http://articles.leetcode.com/2010/04/finding-all-unique-triplets-that-sums.html
 http://blog.csdn.net/linhuanmars/article/details/19711387
 http://gongxuns.blogspot.com/2012/12/leetcode3sum.html
 http://www.cnblogs.com/tenosdoit/p/3649607.html
 */
public class Q015_3Sum {
	public static void main(String[] args) {
		Q015_3Sum ans = new Q015_3Sum();
		Solution s = ans.new Solution();
		int[] array = { -7, 2, 1, 10, 9, -10, -5, 4, 13, -9, -4, 6, 11, -12,
				-6, -9, -6, -9, -11, -4, 10, 10, -3, -1, -4, -7, -12, -15, 11,
				5, 14, 11, -7, -8, 6, 9, -2, 9, -10, -12, -15, 2, 10, 4, 5, 11,
				10, 6, -13, 6, -13, 12, -7, -9, -12, 4, -9, 13, -4, 10, 4, -12,
				6, 4, -5, -10, -2, 0, 14, 4, 4, 6, 13, -9, -5, -5, -13, 12,
				-14, 11, 3, 10, 8, 11, -13, 4, -8, -7, 2, 4, 10, 13, 7, 2, 2,
				9, -1, 8, -5, -10, -3, 6, 3, -5, 12, 6, -3, 6, 3, -2, 2, 14,
				-7, -13, 10, -13, -2, -12, -4, 8, -1, 13, 6, -9, 0, -14, -15,
				6, 9 };
		// Arrays.sort(array);
		// for (int i = 0; i < array.length; i++) {
		// System.out.print(array[i] + " ");
		// }
		long start = System.currentTimeMillis();
		s.threeSum(array);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public class Solution {
		// O(n ^ 2)
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (nums == null || nums.length <= 2)
				return result;
			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 2; i++) {
				int target = -nums[i];
				int start = i + 1;
				int end = nums.length - 1;
				while (start < end) {
					if (nums[start] + nums[end] == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[start]);
						list.add(nums[end]);
						if (!result.contains(list))
							result.add(list);
						end--;
						start++;
						// needed for big data set in Leetcode
						while (start < end && nums[end] == nums[end + 1])
							end--;
						while (start < end && nums[start] == nums[start - 1])
							start++;

					} else if (nums[start] + nums[end] > target) {
						end--;
					} else
						start++;

				}
			}
			return result;
		}
	}

	public class SolutionO3 {
		public List<List<Integer>> threeSum(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (nums == null || nums.length <= 2)
				return result;

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++)
				map.put(nums[i], i);

			for (int i = 0; i < nums.length; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					int a = nums[i];
					int b = nums[j];
					int c = 0 - a - b;
					if (map.get(c) == null)
						continue;

					int temp = map.get(c);

					if (temp != i && temp != j) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(a);
						list.add(b);
						list.add(c);
						Collections.sort(list);
						if (!result.contains(list))
							result.add(list);
					}

				}
			}
			return result;
		}
	}
}
