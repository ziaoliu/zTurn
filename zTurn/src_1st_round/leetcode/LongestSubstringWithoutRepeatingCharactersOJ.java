package leetcode;

/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

//https://oj.leetcode.com/discuss/23883/11-line-simple-java-solution-o-n-with-explanation
public class LongestSubstringWithoutRepeatingCharactersOJ {
	public class Solution {
		public int lengthOfLongestSubstring(String s) {
			if (null == s || s.length() <= 0)
				return 0;

			int max = 1;
			int length = 0;

			char[] array = s.toCharArray();
			boolean[] set = new boolean[256];
			int start = 0;
			int end = 0;

			while (end < s.length()) {
				char temp = array[end];
				// char exists
				if (set[temp]) {
					start++;
					set = new boolean[256];
					end = start;
					length = 0;
				} else {// char does not exist
					set[temp] = true;
					length++;
					end++;
				}

				if (length > max)
					max = length;
			}

			return max;
		}
	}// end Solution

}
