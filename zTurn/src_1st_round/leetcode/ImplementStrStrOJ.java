package leetcode;

/* Implement strStr()
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-implement-strstr-kmp.html
 */

public class ImplementStrStrOJ {
	public class Solution {
		public int strStr(String haystack, String needle) {
			if (null == haystack)
				return -1;

			if (null == needle)
				return -1;

			if (!"".equals(needle) && "".equals(haystack))
				return -1;

			if ("".equals(needle) && !"".equals(haystack))
				return 0;

			if ("".equals(needle) && "".equals(haystack))
				return 0;

			if (needle.length() > haystack.length())
				return -1;

			char[] hArray = haystack.toCharArray();
			char[] nArray = needle.toCharArray();

			int index = -1;
			int j = 0;

			for (int i = 0; i < haystack.length(); i++) {
				if (hArray[i] == nArray[j] && j < needle.length()) {
					if (j == 0)
						index = i;
					if (j + 1 == needle.length())
						return index;
					j++;
				} else {
					if (j != 0)
						i = index;
					j = 0;
					index = -1;
				}
			}

			return -1;
		}
	}
}
