package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Q046_Permutations {
	public class Solution {
		public List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (nums == null || nums.length == 0)
				return result;

			dfs(result, 0, nums);

			return result;
		}

		private void dfs(List<List<Integer>> result, int i, int[] nums) {
			if (i > nums.length)
				return;
			if (i == nums.length - 1) {
				List<Integer> list = new ArrayList<Integer>();
				for (int t = 0; t < nums.length; t++)
					list.add(nums[t]);

				if (!result.contains(list))
					result.add(list);
				return;
			}

			for (int j = i; j < nums.length; j++) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;

				dfs(result, i + 1, nums);

				temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			}
		}

	}
}
