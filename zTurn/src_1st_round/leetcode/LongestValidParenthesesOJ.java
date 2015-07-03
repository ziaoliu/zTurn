package leetcode;

/* Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * http://blog.csdn.net/worldwindjp/article/details/39460161
 * http://shanjiaxin.blogspot.com/2014/04/longest-valid-parentheses-leetcode.html
 * 
 */

import java.util.Stack;

public class LongestValidParenthesesOJ {
	public class Solution {
		public int longestValidParentheses(String s) {
			if (null == s)
				return 0;
			if (s.length() <= 1)
				return 0;
			char[] array = s.toCharArray();
			int max = 0;
			int invalid = -1;
			// only '(' can be pushed into stack
			Stack<Integer> stack = new Stack<Integer>();
			for (int i = 0; i < s.length(); i++) {
				char chr = array[i];
				// if '('
				if (chr == '(')
					stack.push(i);
				// if ')'
				else {
					if (!stack.empty()) {
						stack.pop();
						if (stack.empty())
							// ( ) matched up, current length is from [invalid
							// to current position i]
							max = Math.max(max, i - invalid);
						else
							// ( remaining, current length is from [ last ( to
							// current position i]
							max = Math.max(max, i - stack.peek());
					} else
						invalid = i;
				}
			}
			return max;
		}

		public int longestValidParentheses2(String s) {
			if (null == s)
				return 0;
			if (s.length() <= 1)
				return 0;
			char[] array = s.toCharArray();
			int i = 0;
			int max = 0;
			int temp = 0;
			while (i < s.length()) {
				if (array[i] == '(') {
					String check = check(i, s);
					if (null != check) {
						// System.out.println("i: " + i + " check: " + check);
						temp = temp + check.length();
						i = i + check.length();
						continue;
					}
				}

				if (temp > max)
					max = temp;
				temp = 0;

				i++;
			}

			if (temp != 0 && temp > max)
				max = temp;

			return max;
		}

		public String check(int i, String s) {
			char[] array = s.toCharArray();
			Stack<Character> stack = new Stack<Character>();
			stack.push(array[i]);
			int j = i + 1;
			for (; j < array.length && stack.size() != 0; j++) {
				if (stack.peek() == '(' && array[j] == ')')
					stack.pop();
				else
					stack.push(array[j]);
			}
			if (stack.size() != 0)
				return null;

			return s.substring(i, j);
		}
	}
}
