package leetcode;

import static org.junit.Assert.*;
import leetcode.String2IntegerOJ.Solution;

import org.junit.Test;

public class String2IntegerOJTest {

	@Test
	public void test() {
		String2IntegerOJ solution = new String2IntegerOJ();
		Solution testCase = solution.new Solution();

		String test = "    10522545459";

		System.out.println(testCase.atoi(test));
		

	}

}
