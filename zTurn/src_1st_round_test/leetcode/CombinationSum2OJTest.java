package leetcode;

import static org.junit.Assert.*;
import leetcode.CombinationSum2OJ.Solution;

import org.junit.Test;

public class CombinationSum2OJTest {

	@Test
	public void test() {
		CombinationSum2OJ solution = new CombinationSum2OJ();
		Solution testCase = solution.new Solution();
		int[] test = {1,2};
		int target = 4;
		System.out.println(testCase.combinationSum2(test, target));
	}

}
