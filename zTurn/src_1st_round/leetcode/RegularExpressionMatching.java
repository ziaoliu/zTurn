package leetcode;

/*
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * http://harrifeng.github.io/algo/leetcode/regular-expression-matching.html
 * 
 * when * is the second char, every iteration needs to consider remaining s and remaining p (after *)
 */

public class RegularExpressionMatching {
	public static void main(String[] args) {
		RegularExpressionMatching ss = new RegularExpressionMatching();
		Solution s = ss.new Solution();
		System.out.println(s.isMatch("aaa", "a.a"));
	}

	public class Solution {
		public boolean isMatch(String s, String p) {
			if (p.length() == 0) {
				return s.length() == 0;
			}

			if (p.length() == 1) {
				return s.length() == 1
						&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
			}

			// second char is not *
			if (p.charAt(1) != '*') {
				if (s.length() < 1) {
					return false;
				} else {
					if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
						return isMatch(s.substring(1), p.substring(1));
					} else
						return false;

				}
			}

			// second char is *
			while (s.length() > 0
					&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s, p.substring(2)))
					return true;
				s = s.substring(1);
			}
			return isMatch(s, p.substring(2));
		}
	}
}
