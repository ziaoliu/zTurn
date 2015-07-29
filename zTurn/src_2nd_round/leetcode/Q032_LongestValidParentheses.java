package leetcode;

import java.util.LinkedList;

/*
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

 http://blog.csdn.net/worldwindjp/article/details/39460161
 http://blog.csdn.net/linhuanmars/article/details/20439613

 DP
 https://leetcodenotes.wordpress.com/2013/10/19/leetcode-longest-valid-parentheses-%E8%BF%99%E7%A7%8D%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%EF%BC%8C%E6%9C%80%E9%95%BF%E7%9A%84valid%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%E6%9C%89%E5%A4%9A/
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
