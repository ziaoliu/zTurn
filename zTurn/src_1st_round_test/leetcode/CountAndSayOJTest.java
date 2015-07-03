package leetcode;

import static org.junit.Assert.*;
import leetcode.CountAndSayOJ.Solution;

import org.junit.Test;

public class CountAndSayOJTest {

	@Test
	public void test() {
		CountAndSayOJ solution = new CountAndSayOJ();
		Solution test = solution.new Solution();
		for (int i = 0; i < 10; i++) {
			System.out
					.println("n = " + i + ", result = " + test.countAndSay(i));
		}
	}

}
