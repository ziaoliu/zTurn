package leetcode;

/* Wildcard Matching
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 Some examples:
 isMatch("aa","a") ¡ú false
 isMatch("aa","aa") ¡ú true
 isMatch("aaa","aa") ¡ú false
 isMatch("aa", "*") ¡ú true
 isMatch("aa", "a*") ¡ú true
 isMatch("ab", "?*") ¡ú true
 isMatch("aab", "c*a*b") ¡ú false
 *
 *http://shmilyaw-hotmail-com.iteye.com/blog/2154716
 *http://blog.csdn.net/linhuanmars/article/details/21198049
 */
public class WildcardMatchingOJ {
	public class Solution {

		public boolean isMatch(String str, String pattern) {
			int s = 0, p = 0, match = 0, starIdx = -1;
			while (s < str.length()) {
				// regular comparison
				if (p < pattern.length()
						&& (str.charAt(s) == pattern.charAt(p) || pattern
								.charAt(p) == '?')) {
					s++;
					p++;
				}
				// found '*' in pattern
				else if (p < pattern.length() && pattern.charAt(p) == '*') {
					starIdx = p;
					match = s;
					p++;
				}
				// compare char in pattern after '*' with string
				else if (starIdx != -1) {
					match++;
					s = match;
					p = starIdx + 1;
				} else
					// current pattern char is not '*', and previous pattern
					// char is
					// not '*'
					return false;
			}

			// trim extra '*' in pattern
			while (p < pattern.length() && pattern.charAt(p) == '*') {
				p++;
			}

			return p == pattern.length();
		}

		public boolean isMatchAns(String str, String pattern) {
			int s = 0, p = 0, match = 0, starIdx = -1;
			while (s < str.length()) {
				// advancing both pointers
				if (p < pattern.length()
						&& (pattern.charAt(p) == '?' || str.charAt(s) == pattern
								.charAt(p))) {
					s++;
					p++;
				}
				// * found, only advancing pattern pointer
				else if (p < pattern.length() && pattern.charAt(p) == '*') {
					starIdx = p;
					match = s;
					p++;
				}
				// last pattern pointer was *, advancing string pointer
				else if (starIdx != -1) {
					p = starIdx + 1;
					match++;
					s = match;
				}
				// current pattern pointer is not star, last patter pointer was
				// not *
				// characters do not match
				else
					return false;
			}

			// check for remaining characters in pattern
			while (p < pattern.length() && pattern.charAt(p) == '*')
				p++;

			return p == pattern.length();
		}
	}
}
