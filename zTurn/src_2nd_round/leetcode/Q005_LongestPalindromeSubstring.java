package leetcode;

/*
 Given a string S, find the longest palindromic substring in S. 
 You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Q005_LongestPalindromeSubstring {
	public class Solution {
		public String longestPalindrome(String s) {
			if (s == null || s.length() == 0)
				return null;
			String max = "";
			for (int i = 0; i < s.length(); i++) {
				// odd string length
				String curr = check(s, i, i);
				if (max.length() < curr.length())
					max = curr;
				// even string length
				curr = check(s, i, i + 1);
				if (max.length() < curr.length())
					max = curr;
			}

			return max;
		}

		private String check(String s, int i, int j) {
			char[] array = s.toCharArray();
			while (i > -1 && j < s.length()) {// <======== start/end
				if (array[i] == array[j]) {
					// max = s.substring(i, j + 1);
					i--;
					j++;
				} else
					break;
			}
			return s.substring(i + 1, j);// <======== start/end
		}
	}

	public class SolutionTLE {
		public String longestPalindrome(String s) {
			if (s == null || s.length() == 0)
				return null;
			String max = "";
			for (int i = 0; i < s.length(); i++) {
				String curr = check(s, i);
				if (max.length() < curr.length())
					max = curr;
			}

			return max;
		}

		private String check(String s, int i) {
			int start = i;
			int end = i;
			String max = "";
			// odd string length
			while (start > 0 && end < s.length() - 1) {
				if (s.charAt(start) == s.charAt(end)) {
					max = s.substring(start, end + 1);
					start--;
					end++;
				} else
					break;
			}

			start = i;
			end = i + 1;
			String temp = "";
			if (end < s.length() - 1) {
				while (start > 0 && end < s.length() - 1) {
					if (s.charAt(start) == s.charAt(end)) {
						start--;
						end++;
					} else
						break;
				}
				temp = s.substring(start, end + 1);
			}

			max = temp.length() > max.length() ? temp : max;
			return max;
		}

	}
}
