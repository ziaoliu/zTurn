package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * 
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 *   
 *   http://www.cnblogs.com/springfor/p/3884197.html
 *   http://blog.csdn.net/ljphhj/article/details/22573983
 */
public class PalindromePartitioningOJ {
	public class Solution {
		public List<List<String>> partition(String s) {
			List<List<String>> results = new ArrayList<List<String>>();
			List<String> result = new ArrayList<>();
			if (s == null || s.length() == 0)
				return results;
			dfs(s, result, results);
			return results;
		}

		public void dfs(String s, List<String> result,
				List<List<String>> results) {
			if (s == null || s.length() == 0) {
				results.add(new ArrayList<String>(result));
				return;
			}

			for (int i = 1; i <= s.length(); i++) {
				String sub = s.substring(0, i);
				if (isPalindrome(sub)) {
					result.add(sub);
					dfs(s.substring(i), result, results);
					result.remove(result.size() - 1);
				}
			}
		}

		public boolean isPalindrome(String s) {
			if (s == null || s.length() == 0)
				return true;

			int i = 0;
			int j = s.length() - 1;
			while (i < j) {
				if (s.charAt(i) != s.charAt(j))
					return false;
				i++;
				j--;
			}

			return true;
		}
	}

	public class SolutionCopyFromInternet {
		public List<List<String>> partition(String s) {
			List<String> item = new ArrayList<String>();
			List<List<String>> res = new ArrayList<List<String>>();

			if (s == null || s.length() == 0)
				return res;

			dfs(s, 0, item, res);
			return res;
		}

		public void dfs(String s, int start, List<String> item,
				List<List<String>> res) {
			if (start == s.length()) {
				res.add(new ArrayList<String>(item));
				return;
			}

			for (int i = start; i < s.length(); i++) {
				String str = s.substring(start, i + 1);
				if (isPalindrome(str)) {
					item.add(str);
					dfs(s, i + 1, item, res);
					item.remove(item.size() - 1);
				}
			}
		}

		public boolean isPalindrome(String s) {
			int low = 0;
			int high = s.length() - 1;
			while (low < high) {
				if (s.charAt(low) != s.charAt(high))
					return false;
				low++;
				high--;
			}
			return true;
		}
	}
}
