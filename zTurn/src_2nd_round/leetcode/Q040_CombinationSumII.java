package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 A solution set is: 
 [1, 7] 
 [1, 2, 5] 
 [2, 6] 
 [1, 1, 6] 
 
 http://blog.csdn.net/linhuanmars/article/details/20829099
 */
public class Q040_CombinationSumII {
	public class Solution {
		public List<List<Integer>> combinationSum2(int[] candidates, int target) {
			List<List<Integer>> result = new ArrayList<>();
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
					result.add(new ArrayList<Integer>(list));
				return;
			}
			for (; i < candidates.length; i++) {
				list.add(candidates[i]);
				dfs(result, list, i + 1, target - candidates[i], candidates);
				list.remove(list.size() - 1);
			}
		}// end of method
	}
}
