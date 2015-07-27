package leetcode;

/*
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Q028_ImplementStrStr {
	public class Solution {
		public int strStr(String haystack, String needle) {
			if (haystack == null || needle == null)
				return -1;

			if (needle.equals(haystack))
				return 0;

			if (needle.length() > haystack.length())
				return -1;

			if (!"".equals(haystack) && "".equals(needle))
				return 0;

			if ("".equals(haystack) && !"".equals(needle))
				return -1;

			char[] hays = haystack.toCharArray();
			char[] nees = needle.toCharArray();

			for (int i = 0; i < hays.length; i++) {
				if (hays[i] == nees[0]) {
					boolean flag = true;
					int j = 0;
					for (; j < nees.length && flag
							&& i + nees.length < hays.length; j++) {
						if (hays[i + j] == nees[j])
							flag = true;
						else
							flag = false;
					}
					if (flag)
						return i;
				}
			}
			return -1;
		}
	}
}
