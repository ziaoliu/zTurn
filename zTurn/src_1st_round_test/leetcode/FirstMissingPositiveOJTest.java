package leetcode;

import static org.junit.Assert.*;
import leetcode.FirstMissingPositiveOJ.Solution;

import org.junit.Test;

public class FirstMissingPositiveOJTest {

	@Test
	public void test() {
		FirstMissingPositiveOJ solution = new FirstMissingPositiveOJ();
		Solution test = solution.new Solution();
		int[] array = { 2, 1 };
		System.out.println(test.firstMissingPositive(array));
	}

}
