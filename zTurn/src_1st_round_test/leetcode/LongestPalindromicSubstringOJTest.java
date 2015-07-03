package leetcode;

import static org.junit.Assert.*;
import leetcode.LongestPalindromicSubstringOJ.Solution;

import org.junit.Test;

public class LongestPalindromicSubstringOJTest {

	@Test
	public void test() {
		LongestPalindromicSubstringOJ solution = new LongestPalindromicSubstringOJ();
		Solution testCase = solution.new Solution();
		String test1 = "cabac";
		System.out.println(testCase.longestPalindrome(test1));
	}

}
