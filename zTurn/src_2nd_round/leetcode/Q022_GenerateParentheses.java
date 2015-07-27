package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"

 http://blog.csdn.net/linhuanmars/article/details/19873463
 http://blog.csdn.net/fightforyourdream/article/details/14159435
 */
public class Q022_GenerateParentheses {
	public static void main(String[] args) {
		Q022_GenerateParentheses test = new Q022_GenerateParentheses();
		Solution s = test.new Solution();
		System.out.println(s.generateParenthesis(8).size());
	}

	public class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> result = new ArrayList<String>();

			if (n < 1)
				return result;

			dfs(result, "", n, n);

			return result;
		}

		private void dfs(List<String> result, String str, int l, int r) {
			if (l > r)
				return;
			if (l == 0 && r == 0) {
				if (!result.contains(str))
					result.add(str);
				return;
			}

			if (l > 0)
				dfs(result, str + "(", l - 1, r);
			if (r > 0)
				dfs(result, str + ")", l, r - 1);

		}
	}

	public class SolutionStupidDFS {
		public List<String> generateParenthesis(int n) {
			List<String> result = new ArrayList<String>();

			if (n < 1)
				return result;

			dfs(result, new StringBuilder("()"), 1, n);

			return result;
		}

		private void dfs(List<String> result, StringBuilder sb, int i, int n) {
			if (i >= n) {
				String str = sb.toString();
				if (!result.contains(str))
					result.add(str);
				return;
			}

			for (int j = 0; j < sb.length(); j++) {
				StringBuilder dup = new StringBuilder(sb);
				dfs(result, dup.insert(j, "()"), i + 1, n);
			}

		}
	}
}
