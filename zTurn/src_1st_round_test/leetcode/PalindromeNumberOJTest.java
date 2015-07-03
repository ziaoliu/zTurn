package leetcode;

import static org.junit.Assert.*;
import leetcode.PalindromeNumberOJ.Solution;

import org.junit.Test;

public class PalindromeNumberOJTest {

	@Test
	public void test() {
		PalindromeNumberOJ solution = new PalindromeNumberOJ();
		Solution testCase = solution.new Solution();

		int test = 1001;
		System.out.println(testCase.isPalindrome2(test));
	}

}
