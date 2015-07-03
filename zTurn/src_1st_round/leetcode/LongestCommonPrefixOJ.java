package leetcode;

/*
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * http://rleetcode.blogspot.com/2014/02/longest-common-prefix-java.html
 */
public class LongestCommonPrefixOJ {

	public class Solution {
		public String longestCommonPrefix(String[] strs) {
			// http://sbzhouhao.net/2014/08/28/LeetCode-Longest-Common-Prefix/
			if (null == strs)
				return "";
			if (strs.length == 1)
				return strs[0];
			if (strs.length < 1)
				return "";

			if (strs[0].length() == 0)
				return "";

			String prefix = strs[0];

			for (int i = 1; i < strs.length; i++) { // select string from array

				int j = 0;
				for (; j < prefix.length() && j < strs[i].length(); j++) {
					// compare char with prefix
					if (prefix.charAt(j) != strs[i].charAt(j))
						break;
				}
				prefix = prefix.substring(0, j);

				if (prefix.length() == 0)
					return "";

			}

			return prefix;
		}

		public String longestCommonPrefix2(String[] strs) {
			if (null == strs)
				return "";
			if (strs.length == 1)
				return strs[0];
			if (strs.length < 1)
				return "";

			if (strs[0].length() == 0)
				return "";

			String prefix = strs[0];

			for (int i = 0; i < strs[0].length(); i++) {
				// go thru prefix

				for (int j = 1; j < strs.length; j++) {
					// find a string in the array
					if (strs[j].length() == i
							|| strs[j].charAt(i) != strs[0].charAt(i))
						return strs[0].substring(0, i);

				}
			}
			return prefix;
		}
	} // end of solution
}
