package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Q090_SubsetsII {
	public class Solution {
		public List<List<Integer>> subsetsWithDup(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();

			if (nums == null || nums.length == 0)
				return result;

			Arrays.sort(nums);
			dfs(result, list, nums, 0);

			return result;
		}

		private void dfs(List<List<Integer>> result, List<Integer> list,
				int[] nums, int i) {
			if (!result.contains(list)) {
				result.add(new ArrayList<Integer>(list));
			}
			if (i >= nums.length)
				return;
			for (int index = i; index < nums.length; index++) {
				list.add(nums[index]);
				dfs(result, list, nums, index + 1);
				list.remove(list.size() - 1);
				// meat of the q
				while (index < nums.length - 1
						&& nums[index] == nums[index + 1])
					index++;
			}
		}
	}
}
