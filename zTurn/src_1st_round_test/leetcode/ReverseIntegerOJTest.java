package leetcode;

import static org.junit.Assert.*;
import leetcode.ReverseIntegerOJ.Solution;

import org.junit.Test;

public class ReverseIntegerOJTest {

	@Test
	public void test() {
		ReverseIntegerOJ solution = new ReverseIntegerOJ();
		Solution testCase = solution.new Solution();

		int test = 1534236469;
		System.out.println(testCase.reverse(test));
	}

}
