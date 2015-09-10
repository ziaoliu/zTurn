package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class Q131_PalindromePartitioning {
	public static void main(String[] args) {
		Q131_PalindromePartitioning test = new Q131_PalindromePartitioning();
		Solution s = test.new Solution();
		System.out.println(s.partition("a"));
	}

	public class Solution {
		public List<List<String>> partition(String s) {
			List<List<String>> result = new ArrayList<>();
			if (s == null || s.length() == 0)
				return result;
			List<String> list = new ArrayList<>();
			dfs(result, list, s, 0);
			return result;
		}

		private void dfs(List<List<String>> result, List<String> list,
				String s, int i) {
			if (i == s.length()) {
				if (!result.contains(list))
					result.add(new ArrayList<>(list));
				return;
			}
			if (i > s.length())
				return;
			for (int index = i + 1; index <= s.length(); index++) {
				String tmp = s.substring(i, index);
				if (tmp == null || tmp.length() == 0)
					continue;
				if (isPalindrome(tmp)) {
					list.add(tmp);
					dfs(result, list, s, index);
					list.remove(list.size() - 1);
				}
			}
		}

		private boolean isPalindrome(String tmp) {
			int s = 0;
			int e = tmp.length() - 1;
			char[] array = tmp.toCharArray();
			while (s <= e) {
				if (array[s] == array[e]) {
					s++;
					e--;
				} else
					return false;
			}
			return true;
		}
	}
}
