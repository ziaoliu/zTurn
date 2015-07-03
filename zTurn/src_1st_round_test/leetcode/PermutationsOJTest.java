package leetcode;

import static org.junit.Assert.*;
import leetcode.PermutationsOJ.Solution;

import org.junit.Test;

public class PermutationsOJTest {

	@Test
	public void test() {
		PermutationsOJ solution = new PermutationsOJ();
		Solution testCase = solution.new Solution();
		int[] test = {1,2,3};
		System.out.println(testCase.permute(test));
	}

}
