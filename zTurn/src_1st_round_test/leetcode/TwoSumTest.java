package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoSumTest {

	@Test
	public void test() {
		TwoSum solution = new TwoSum();
		TwoSum.Solution test_case = solution.new Solution();
		int[] test = {2, 7, 11, 15};
		int[] result = test_case.twoSum(test, 9);
		System.out.println(result[0] + " : " + result[1]);
		
	}

}
