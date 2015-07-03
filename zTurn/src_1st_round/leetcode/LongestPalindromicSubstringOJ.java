package leetcode;

/*
   Longest Palindromic Substring
 
 Given a string S, find the longest palindromic substring in S. 
 You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

 Note: be careful with the boundary conditions

 center locating method O(n^2)

 http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 http://blog.csdn.net/linhuanmars/article/details/20888595
 */

public class LongestPalindromicSubstringOJ {
	public class Solution {
		public String longestPalindrome(String s) {
			if (null == s)
				return "";
			if (s.length() <= 0)
				return "";

			String maxStr = s.substring(0, 1);

			for (int p = 0; p < s.length(); p++) {
				String oddStr = expand(s, p, p);
				if (oddStr.length() > maxStr.length())
					maxStr = oddStr;

				String evenStr = expand(s, p, p + 1);
				if (evenStr.length() > maxStr.length())
					maxStr = evenStr;

			}

			return maxStr;
		}

		private String expand(String s, int i, int j) {
			char[] array = s.toCharArray();
			while (i > -1 && j < s.length()) {
				if (array[i] == array[j]) {
					i--;
					j++;
				} else
					break;
			}
			return s.substring(i + 1, j);
		}

	}// end Solution
}
