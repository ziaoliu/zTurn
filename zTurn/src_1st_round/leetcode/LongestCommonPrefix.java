package leetcode;

/*
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * http://rleetcode.blogspot.com/2014/02/longest-common-prefix-java.html
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		LongestCommonPrefix ss = new LongestCommonPrefix();
		Solution s = ss.new Solution();
		String[] strs = { "abc", "abcd" };
		System.out.println(s.longestCommonPrefix(strs));
	}

	public class Solution {
		public String longestCommonPrefix(String[] strs) {
			if (strs.length == 0 || strs[0] == null)
				return "";
			StringBuilder sb = new StringBuilder();
			sb.append("");

			for (int i = 0; i < strs[0].length(); i++) {
				char c = strs[0].charAt(i);

				for (int j = 0; j < strs.length; j++) {
					if (strs[j] != null && strs[j].length() > i
							&& strs[j].charAt(i) == c)
						continue;
					else
						return sb.toString();
				}
				sb.append(c);
			}
			return sb.toString();
		}
	}
}
