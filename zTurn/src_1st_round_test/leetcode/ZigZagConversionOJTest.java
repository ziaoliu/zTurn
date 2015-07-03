package leetcode;

import static org.junit.Assert.*;
import leetcode.ZigZagConversionOJ.Solution;

import org.junit.Test;

public class ZigZagConversionOJTest {

	@Test
	public void test() {
		ZigZagConversionOJ solution = new ZigZagConversionOJ();
		Solution testCase = solution.new Solution();

		String test1 = "PAYPALISHIRING";


		System.out.println(testCase.convert2(test1, 3));
	}

}
