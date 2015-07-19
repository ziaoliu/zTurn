package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:( n = 8, 1430 patterns??? perf on dfs: 1800 ms [too much manipulation on string])

 "((()))", "(()())", "(())()", "()(())", "()()()" 

 http://blog.csdn.net/fightforyourdream/article/details/14159435

 */

public class GenerateParenthesesOJ {

	public static void main(String[] args) {
		GenerateParenthesesOJ solution = new GenerateParenthesesOJ();
		Solution test = solution.new Solution();
		long start = System.currentTimeMillis();
		System.out.println(test.generateParenthesis(8).size());
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public class Solution2_TLE {
		public List<String> generateParenthesis(int n) {
			ArrayList<String> result = new ArrayList<String>();
			if (n <= 0) {
				result.add("");
				return result;
			}

			dfs(0, n, "()", result);

			return result;
		}

		private void dfs(int i, int n, String str, ArrayList<String> result) {
			if (i >= n - 1) {
				if (!result.contains(str))
					result.add(str);
			} else {
				StringBuilder sb = new StringBuilder(str);
				for (int j = 0; j < str.length(); j++) {

					sb.insert(j, "()");

					dfs(i + 1, n, sb.toString(), result);

					sb = new StringBuilder(str);
				}
			}

		}

	}

	public class Solution {
		public List<String> generateParenthesis(int n) {
			ArrayList<String> result = new ArrayList<String>();
			if (n <= 0) {
				result.add("");
				return result;
			}

			recur(0, 0, n, "", result);

			return result;
		}

		private void recur(int left, int right, int n, String str,
				ArrayList<String> result) {
			if (left < right)
				return;

			if (left == n && right == n) {
				if (!result.contains(str))
					result.add(str);
				return;
			}

			if (left == n) {
				recur(left, right + 1, n, str + ")", result);
				return;
			}

			recur(left + 1, right, n, str + "(", result);
			recur(left, right + 1, n, str + ")", result);

		}

	}// end of solution
}
