package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*
 Given a string, find the length of the longest substring without repeating characters. For example, the longest substring 
 without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

 http://harrifeng.github.io/algo/leetcode/longest-substring-without-repeating-characters.html
 */
public class Q003_LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		Q003_LongestSubstringWithoutRepeatingCharacters tt = new Q003_LongestSubstringWithoutRepeatingCharacters();
		Solution ttt = tt.new Solution();
		ttt.lengthOfLongestSubstring("aab");
	}

	public class Solution {
		public int lengthOfLongestSubstring(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int max = 1;
			int temp = 0;
			int[] table = new int[256];
			Arrays.fill(table, -1);

			for (int i = 0; i < s.length(); i++) {
				char curr = s.charAt(i);
				if (table[curr] != -1) {// char exists
					int j = table[curr];
					Arrays.fill(table, -1);
					i = j + 1;

					max = Math.max(max, temp);
					temp = 0;
				}
				table[s.charAt(i)] = i;
				temp++;
			}
			return Math.max(max, temp);
		}
	}
}
