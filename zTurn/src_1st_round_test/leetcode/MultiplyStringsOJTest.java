package leetcode;

import static org.junit.Assert.*;
import leetcode.MultiplyStringsOJ.Solution;

import org.junit.Test;

public class MultiplyStringsOJTest {

	@Test
	public void test() {
		MultiplyStringsOJ solution = new MultiplyStringsOJ();
		Solution s = solution.new Solution();
		System.out.println(s.multiply("9", "9"));
	}

}
