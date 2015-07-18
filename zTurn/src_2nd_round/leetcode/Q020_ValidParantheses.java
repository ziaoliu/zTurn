package leetcode;

import java.util.LinkedList;

/*
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 
 http://fisherlei.blogspot.com/2013/01/leetcode-valid-parentheses.html
 */
public class Q020_ValidParantheses {
	public class Solution {
		public boolean isValid(String s) {
			if (s == null || s.length() == 0)
				return true;

			LinkedList<Character> stack = new LinkedList<>();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (i == 0) {
					stack.push(c);
					continue;
				}

				if (c == '(' || c == '[' || c == '{')
					stack.push(c);
				else {
					if (stack.size() == 0)
						return false;
					char pre = stack.peek();
					if (pre == '(' && c == ')' || pre == '[' && c == ']'
							|| pre == '{' && c == '}')
						stack.pop();
					else
						return false;
				}
			}
			if (stack.size() > 0)
				return false;

			return true;
		}
	}
}
