package leetcode;

/*
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * http://xiangyixie.blogspot.com/2014/04/regular-expression-matching-leetcode.html
 * http://wizardrichard.blogspot.com/2013/02/leetcode-regular-expression-matching.html
 */

public class RegularExpressionMatchingDP {
	public static void main(String[] args) {
		RegularExpressionMatchingDP ss = new RegularExpressionMatchingDP();
		Solution s = ss.new Solution();
		System.out.println(s.isMatch("aaa", "a.a"));
	}

	public class Solution {
		public boolean isMatch(String s, String p) {
			
			return isMatch(s, p.substring(2));
		}
	}
}
