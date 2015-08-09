package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 http://blog.csdn.net/linhuanmars/article/details/21570835
 */
public class Q047_PermutationsII {
	public class Solution {
		public List<List<Integer>> permuteUnique(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();

			if (nums == null | nums.length == 0)
				return result;

			Arrays.sort(nums);

			dfs(result, list, new boolean[nums.length], nums);

			return result;
		}

		private void dfs(List<List<Integer>> result, List<Integer> list,
				boolean[] used, int[] nums) {
			if (list.size() == nums.length) {
				result.add(new ArrayList<Integer>(list));
				return;
			}
			for (int j = 0; j < nums.length; j++) {
				if (j > 0 && !used[j - 1] && nums[j] == nums[j - 1])
					continue;
				if (!used[j]) {
					used[j] = true;
					list.add(nums[j]);
					dfs(result, list, used, nums);
					list.remove(list.size() - 1);
					used[j] = false;
				}
			}
		}
	}
}
