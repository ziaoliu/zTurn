package leetcode;

import java.util.ArrayList;
import java.util.List;


//https://oj.leetcode.com/discuss/23847/220ms-java-iteration-solution-easy-to-understand
//http://www.programcreek.com/2013/02/leetcode-permutations-java/
public class PermutationsOJ {
	public class Solution {
		public List<List<Integer>> permute(int[] num) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();

			if (null == num || num.length < 1)
				return result;

			dfs(0, num, list, result);

			return result;
		}

		public void dfs(int level, int[] num, List<Integer> list,
				List<List<Integer>> result) {
			if (level > num.length)
				return;
			else if (level == num.length) {
				List<Integer> temp = new ArrayList<Integer>(list);
				if (!result.contains(temp))
					result.add(temp);
			} else {
				level++;
				for (int i = 0; i < num.length; i++) {
					if (!list.contains(num[i])) {
						list.add(num[i]);
						dfs(level, num, list, result);
						list.remove(list.size() - 1);
					}
				}
			}
		}
	}
}
