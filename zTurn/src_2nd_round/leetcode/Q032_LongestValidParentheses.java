package leetcode;

import java.util.LinkedList;

/*
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

 http://blog.csdn.net/worldwindjp/article/details/39460161
 http://blog.csdn.net/linhuanmars/article/details/20439613
 */
public class Q032_LongestValidParentheses {
	public static void main(String[] args) {
		Q032_LongestValidParentheses test = new Q032_LongestValidParentheses();
		Solution t = test.new Solution();
		System.out.println(t.longestValidParentheses("())"));
	}

	public class Solution {
		public int longestValidParentheses(String s) {
			if (s == null || s.length() == 0)
				return 0;
			LinkedList<Integer> stack = new LinkedList<>();

			int max = 0;
			int start = -1;

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(')
					stack.push(i);
				else {
					if (stack.size() != 0) {
						stack.pop();
						if (stack.size() != 0)
							max = Math.max(max, i - stack.peek());
						else
							// stack.size == 0
							max = Math.max(max, i - start);
					} else
						start = i;
				}
			}

			return max;
		}
	}

	public class SolutionWrong {
		public int longestValidParentheses(String s) {
			if (s == null || s.length() == 0)
				return 0;
			LinkedList<Character> stack = new LinkedList<>();
			int max = 0;
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(') {
					stack.push(c);
					continue;
				} else {
					if (stack.size() == 0)
						continue;
					char pre = stack.peek();
					if (pre == '(') {
						stack.pop();
						count = count + 2;
						max = Math.max(max, count);
					} else {
						max = Math.max(max, count);
						count = 0;
					}
				}
			}
			return max;
		}

	}
}
