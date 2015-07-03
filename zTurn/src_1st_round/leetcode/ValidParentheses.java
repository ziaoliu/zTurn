package leetcode;

import java.util.Stack;

/*
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()", "([])" and "()[]{}" are all valid but "(]" and "([)]" are not.

 http://fisherlei.blogspot.com/2013/01/leetcode-valid-parentheses.html

 */

public class ValidParentheses {
	public static void main(String[] args) {
		ValidParentheses ss = new ValidParentheses();
		Solution s = ss.new Solution();
		System.out.println(s.isValid("([])"));
	}

	public class Solution {
		public boolean isValid(String s) {
			char[] rules = { '(', ')', '{', '}', '[', ']' };

			if (s == null || s.length() < 2 || s.length() % 2 != 0)
				return false;

			Stack<Character> stack = new Stack<Character>();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == rules[0] || c == rules[2] || c == rules[4])
					stack.add(c);
				else {
					char pop = '0';
					if (stack.size() >= 1)
						pop = stack.pop();
					else
						return false;

					if (pop == rules[0] && c == rules[1])
						continue;
					else if (pop == rules[2] && c == rules[3])
						continue;
					else if (pop == rules[4] && c == rules[5])
						continue;
					else
						return false;
				}
			}

			if (stack.size() == 0)
				return true;
			else
				return false;
		}
	}
}
