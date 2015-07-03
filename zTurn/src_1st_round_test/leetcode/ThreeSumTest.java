package leetcode;

import static org.junit.Assert.*;
import leetcode.ThreeSum.Solution;

import org.junit.Test;

public class ThreeSumTest {

	@Test
	public void test() {
		ThreeSum solution = new ThreeSum();
		Solution testCase = solution.new Solution();
		int test[] = { -13, 10, 11, -3, 8, 11, -4, 8, 12, -13, 5, -6, -4, -2,
				12, 11, 7, -7, -3, 10, 12, 13, -3, -2, 6, -1, 14, 7, -13, 8,
				14, -10, -4, 10, -6, 11, -2, -3, 4, -13, 0, -14, -3, 3, -9, -6,
				-9, 13, -6, 3, 1, -9, -6, 13, -4, -15, -11, -12, 7, -9, 3, -2,
				-12, 6, -15, -10, 2, -2, -6, 13, 1, 9, 14, 5, -11, -10, 14, -5,
				11, -6, 6, -3, -8, -15, -13, -4, 7, 13, -1, -9, 11, -13, -4,
				-15, 9, -4, 12, -4, 1, -9, -5, 9, 8, -14, -1, 4, 14 };
		// System.out.println(testCase.threeSum(new int[] { -1, 0, 1, 2, -1, -4
		// }));
		long startTime = System.currentTimeMillis();
		System.out.println(testCase.threeSum1(test));
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);

		startTime = System.currentTimeMillis();
		System.out.println(testCase.threeSum(test));
		stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);

	}
}
