package leetcode;

import static org.junit.Assert.*;
import leetcode.Permutations2OJ.Solution;

import org.junit.Test;

public class Permutations2OJTest {

	@Test
	public void test() {
		Permutations2OJ solution = new Permutations2OJ();
		Solution testCase = solution.new Solution();
		int[] test = {3,3,0,0,2,3,2};
		System.out.println(testCase.permuteUnique(test));
	}

}
