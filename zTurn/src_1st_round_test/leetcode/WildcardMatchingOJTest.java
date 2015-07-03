package leetcode;

import static org.junit.Assert.*;
import leetcode.WildcardMatchingOJ.Solution;

import org.junit.Test;

public class WildcardMatchingOJTest {

	@Test
	public void test() {
		WildcardMatchingOJ solution = new WildcardMatchingOJ();
		Solution test = solution.new Solution();
		System.out.println(test.isMatch("ho", "**ho"));
	}

}
