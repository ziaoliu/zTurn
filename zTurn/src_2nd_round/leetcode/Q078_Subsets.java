package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 Given a set of distinct integers, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Q078_Subsets {
	public static void main(String[] args) {
		Q078_Subsets test = new Q078_Subsets();
		Solution tt = test.new Solution();
		int[] array = { 0 };
		System.out.println(tt.subsets(array));
	}

	public class Solution {
		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			if (nums == null || nums.length == 0)
				return result;
			// result.add(list); cannot add it here or use new ArrayList(list)
			Arrays.sort(nums);
			dfs(result, list, nums, 0);
			return result;
		}

		private void dfs(List<List<Integer>> result, List<Integer> list,
				int[] nums, int index) {
			if (!result.contains(list))
				result.add(new ArrayList<>(list));
			for (int i = index; i < nums.length; i++) {
				list.add(nums[i]);
				dfs(result, list, nums, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	public class SolutionOLD {
		public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (null == nums || nums.length <= 0)
				return result;

			ArrayList<Integer> list = new ArrayList<Integer>();

			if (nums.length == 1) {
				result.add(new ArrayList<Integer>(list));
				list.add(nums[0]);
				result.add(list);
				return result;
			}

			Arrays.sort(nums);

			dfs(result, nums, list, 0);

			return result;
		}

		public void dfs(ArrayList<ArrayList<Integer>> result, int[] nums,
				ArrayList<Integer> list, int i) {
			if (list.size() > nums.length)
				return;

			if (!result.contains(list)) {
				Collections.sort(list);
				result.add(new ArrayList<Integer>(list));
			}

			for (int index = i; index < nums.length; index++) {
				list.add(nums[index]);
				dfs(result, nums, list, index + 1);
				list.remove(list.size() - 1);
			}
		}
	}
}
