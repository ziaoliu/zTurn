package leetcode;

import java.util.ArrayList;
import java.util.List;

/* Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 * 
 * http://blog.csdn.net/linhuanmars/article/details/21260217
 * http://www.cnblogs.com/springfor/p/3877168.html
 */
public class CombinationsOJ {
	public class Solution {
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
