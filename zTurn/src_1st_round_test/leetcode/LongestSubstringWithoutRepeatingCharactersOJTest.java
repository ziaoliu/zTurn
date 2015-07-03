package leetcode;

import static org.junit.Assert.*;
import leetcode.LongestSubstringWithoutRepeatingCharactersOJ.Solution;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersOJTest {

	@Test
	public void test() {
		LongestSubstringWithoutRepeatingCharactersOJ solution = new LongestSubstringWithoutRepeatingCharactersOJ();
		Solution testCase = solution.new Solution();
		System.out.println(testCase.lengthOfLongestSubstring("abcabcbb"));
		
	}

}
