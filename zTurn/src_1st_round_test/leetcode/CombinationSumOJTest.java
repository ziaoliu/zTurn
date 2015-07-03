package leetcode;

import static org.junit.Assert.*;
import leetcode.CombinationSumOJ.Solution;

import org.junit.Test;

public class CombinationSumOJTest {

	@Test
	public void test() {
		CombinationSumOJ solution = new CombinationSumOJ();
		Solution testCase = solution.new Solution();
		int[] test = {2,3,6,7};
		int target = 7;
		System.out.println(testCase.combinationSum(test, target));
	}

}
