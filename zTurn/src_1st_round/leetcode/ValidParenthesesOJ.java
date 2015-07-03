package leetcode;

import java.util.Stack;

/*
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()", "([])" and "()[]{}" are all valid but "(]" and "([)]" are not.

 http://fisherlei.blogspot.com/2013/01/leetcode-valid-parentheses.html

 */

public class ValidParenthesesOJ {
	public static void main(String[] args) {
		ValidParenthesesOJ ss = new ValidParenthesesOJ();
		Solution s = ss.new Solution();
		System.out.println(s.isValid("([])"));
	}

	public class Solution {
		public boolean isValid(String s) {

			if (null == s)
				return true;

			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				Character peek = null;
				if (stack.size() > 0)
					peek = stack.peek();
				if (temp == '(' || temp == '{' || temp == '[') {
					// push case
					stack.push(temp);

				} else if (temp == ')' || temp == '}' || temp == ']') {
					// pop case
					if (null == peek) {
						return false;
					} else if (peek == '(' || peek == '{' || peek == '[') {
						if (peek == '(' && temp == ')')
							stack.pop();
						else if (peek == '{' && temp == '}')
							stack.pop();
						else if (peek == '[' && temp == ']')
							stack.pop();
						else
							return false;
					} else if (peek == ')' || peek == '}' || peek == ']') {
						return false;
					}
				}
			}
			if (stack.size() != 0)
				return false;
			return true;
		}
	} // end of solution
}
