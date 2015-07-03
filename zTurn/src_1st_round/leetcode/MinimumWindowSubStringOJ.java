package leetcode;

import java.util.HashMap;

/* Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * http://www.cnblogs.com/lichen782/p/leetcode_minimum_window_substring_3.html
 * http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 * http://www.cnblogs.com/TenosDoIt/p/3461301.html
 */

public class MinimumWindowSubStringOJ {
	public class Solution {

		public String minWindow(String S, String T) {
			if (null == S)
				return null;
			if (null == T || T.length() == 0)
				return "";
			String result = "";
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < T.length(); i++) {
				char temp = T.charAt(i);
				if (!map.containsKey(temp))
					map.put(temp, 1);
				else {
					int c = map.get(temp);
					map.put(temp, c + 1);
				}
			}
			int dup = -1;
			for (int i = 0; i < S.length(); i++) {
				HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>(
						map);

				if (!tempMap.containsKey(S.charAt(i)))
					continue;

				int j = i;
				int counter = 0;
				for (; j < S.length(); j++) {
					char temp = S.charAt(j);
					if (!tempMap.containsKey(temp)) {
						String t = new StringBuilder().append(temp).toString();
						if (T.contains(t))
							break;
						continue;
					}
					int c = tempMap.get(temp);
					counter++;
					if (counter == 2) {
						dup = j;
					}
					if (c > 1) {
						tempMap.put(temp, c - 1);
					} else {
						tempMap.remove(temp);
					}
					if (tempMap.size() == 0) {
						String sub = S.substring(i, j + 1);
						if ("".equals(result))
							result = sub;
						if (result.length() > sub.length())
							result = sub;
						break;
					}
				}
				if (dup != -1) {
					i = dup - 1;
					dup = -1;
				}
			}

			return result;
		}// end of method
	}
}
