package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7, 
 A solution set is: 
 [7] 
 [2, 2, 3] 

 http://blog.csdn.net/linhuanmars/article/details/20828631
 */
public class Q039_CombinationSum {
	public class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<>();
			if (candidates == null || candidates.length == 0 || target <= 0)
				return result;

			Arrays.sort(candidates);
			dfs(result, list, 0, target, candidates);

			return result;
		}

		private void dfs(List<List<Integer>> result, List<Integer> list, int i,
				int target, int[] candidates) {
			if (target < 0)
				return;

			if (target == 0) {
				if (!result.contains(list))
					result.add(new ArrayList<>(list));
				return;
			}

			for (; i < candidates.length; i++) {
				if (i > 0 && candidates[i] == candidates[i - 1])
					continue;
				list.add(candidates[i]);
				dfs(result, list, i, target - candidates[i], candidates);
				list.remove(list.size() - 1);
			}
		}// end of dfs
	}
}
