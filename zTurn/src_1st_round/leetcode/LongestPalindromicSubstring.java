package leetcode;

/*
 Given a string S, find the longest palindromic substring in S. 
 You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 
 Note: be careful with the boundary conditions
 
 center locating method O(n^2)
 
 http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 */

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubstring ss = new LongestPalindromicSubstring();
		Solution s = ss.new Solution();
		System.out.println(s.longestPalindrome("aabbaa"));

	}

	public class Solution {
		public String longestPalindrome(String s) {
			if (s == null || s.equals(""))
				return null;
			if (s.length() == 1 || s.length() == 2)
				return s;

			String max = null;
			int maxInt = 1;

			for (int i = 0; i < s.length(); i++) {
				String oddStr = parse(s, i, i);
				String evenStr = oddStr;
				if (i + 1 <= s.length())
					evenStr = parse(s, i, i + 1);

				String curr = null;
				if (null == evenStr)
					curr = oddStr;
				else
					curr = oddStr.length() > evenStr.length() ? oddStr
							: evenStr;

				if (curr.length() > maxInt) {
					max = curr;
					maxInt = max.length();
				}
			}

			return max;
		}

		public String parse(String s, int a, int b) {
			char[] str = s.toCharArray();
			if (a < 0 || b >= s.length())
				return null;
			int start = a;
			int end = b;

			System.out.println("input===>" + a + " : " + b);
			
			for (int i = 0; i < s.length(); i++) {
				if (start >= 0 && end <= s.length() - 1 && str[start] == str[end]) {
					start = a - i;
					end = b + i;
				} else {
					break;
				}
			}
			
			System.out.println("output===>" + (start ) + " : " + end + " = " + s.substring(start + 1, end));
			
			return s.substring(start + 1, end);
		}
	}
}
