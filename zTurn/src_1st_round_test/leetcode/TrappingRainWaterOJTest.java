package leetcode;

import static org.junit.Assert.*;
import leetcode.TrappingRainWaterOJ.Solution;

import org.junit.Test;

public class TrappingRainWaterOJTest {

	@Test
	public void test() {
		TrappingRainWaterOJ solution = new TrappingRainWaterOJ();
		Solution test = solution.new Solution();
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(test.trap(A));

	}

}
