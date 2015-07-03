package leetcode;

import static org.junit.Assert.*;
import leetcode.ThreeSumClosestOJ.Solution;

import org.junit.Test;

public class ThreeSumClosestOJTest {

	@Test
	public void test() {
		ThreeSumClosestOJ solution = new ThreeSumClosestOJ();
		Solution testCase = solution.new Solution();
		int[] test = { -1, 2, 1, -4 };
		int target = 1;
		System.out.println(testCase.threeSumClosest(test, target));
	}

}
