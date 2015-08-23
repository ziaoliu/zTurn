package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 https://leetcode.com/discuss/42034/java-solution-easy-understood
 */
public class Q077_Combinations {
	public static void main(String[] args) {
		Q077_Combinations test = new Q077_Combinations();
		Solution t = test.new Solution();
		System.out.println(t.combine(1, 1));
	}

	public class Solution {
		public List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			if (k <= 0)
				return result;

			dfs(result, list, 1, n, k);

			return result;
		}

		private void dfs(List<List<Integer>> result, List<Integer> list,
				int curr, int n, int k) {
			if (list.size() == k) {
				result.add(new ArrayList<>(list));
				return;
			}
			if (curr > n || list.size() > k) // add results before checking
				return;
			for (int i = curr; i <= n; i++) {
				list.add(i);
				dfs(result, list, i + 1, n, k);// use i + 1 instead of curr + 1
				list.remove(list.size() - 1);
			}
		}
	}

	public class SolutionOLD {
		public ArrayList<ArrayList<Integer>> combine(int n, int k) {
			ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> list = new ArrayList<Integer>();

			if (k <= 0 || k > n)
				return results;

			dfs(results, list, n, k, 1);

			return results;
		}

		public void dfs(ArrayList<ArrayList<Integer>> results,
				ArrayList<Integer> list, int n, int k, int i) {
			if (list.size() == k) {
				results.add(new ArrayList<Integer>(list));
				return;
			} else {
				for (int index = i; index <= n; index++) {
					list.add(index);
					dfs(results, list, n, k, index + 1);
					list.remove(list.size() - 1);
				}
			}
		}
	}
}
