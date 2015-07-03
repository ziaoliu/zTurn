package leetcode;

import static org.junit.Assert.*;
import leetcode.LongestValidParenthesesOJ.Solution;

import org.junit.Test;

public class LongestValidParenthesesOJTest {

	@Test
	public void testCheck() {
		LongestValidParenthesesOJ test = new LongestValidParenthesesOJ();
		Solution testCase = test.new Solution();
		String s = "()(()())";

//		System.out.println(testCase.check(0, s));
		System.out.println(testCase.longestValidParentheses(s));

	}
	
	

}
