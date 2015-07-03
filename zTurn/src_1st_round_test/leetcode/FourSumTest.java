package leetcode;

import static org.junit.Assert.*;
import leetcode.FourSum.Solution;

import org.junit.Test;

public class FourSumTest {

	@Test
	public void test() {
		FourSum solution = new FourSum();
		Solution testCase = solution.new Solution();
		int[] test = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println("=====>test: " + testCase.fourSum(test, target));
	}

}
