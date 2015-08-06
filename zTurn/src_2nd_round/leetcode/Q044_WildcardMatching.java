package leetcode;

/*
 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ¡ú false
 isMatch("aa","aa") ¡ú true
 isMatch("aaa","aa") ¡ú false
 isMatch("aa", "*") ¡ú true
 isMatch("aa", "a*") ¡ú true
 isMatch("ab", "?*") ¡ú true
 isMatch("aab", "c*a*b") ¡ú false

 http://simpleandstupid.com/2014/10/26/wildcard-matching-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
 http://shmilyaw-hotmail-com.iteye.com/blog/2154716

 */
public class Q044_WildcardMatching {
	public class Solution {
		public boolean isMatch(String str, String pattern) {
			int i = 0;
			int j = 0;
			int star = -1;
			int mark = -1;
			while (i < str.length()) {
				if (j < pattern.length()
						&& (str.charAt(i) == pattern.charAt(j) || pattern
								.charAt(j) == '?')) {
					i++;
					j++;
				} else if (j < pattern.length() && pattern.charAt(j) == '*') {
					star = j;
					j++;
					mark = i;
				} else if (star != -1) {
					j = star + 1;
					mark++;
					i = mark;
				} else {
					return false;
				}
			}

			while (j < pattern.length() && pattern.charAt(j) == '*')
				j++;
			return j == pattern.length();
		}
	}
}
