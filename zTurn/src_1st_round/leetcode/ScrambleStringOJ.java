package leetcode;

/* Scramble String
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * http://fisherlei.blogspot.com/2013/01/leetcode-scramble-string.html
 * http://www.lifeincode.net/programming/leetcode-scramble-string-java/
 * http://www.cnblogs.com/springfor/p/3896164.html
 * http://blog.csdn.net/linhuanmars/article/details/24506703
 */
public class ScrambleStringOJ {
	public class Solution {

		public boolean isScramble(String s1, String s2) {
			//...
			return false;
		}// end of method

		// recursive approach
		public boolean isScrambleRecur(String s1, String s2) {

			if (null == s1 || null == s2)
				return false;

			if (s1.length() != s2.length())
				return false;

			if (s1.equals(s2))
				return true;

			int[] chars = new int[26];

			for (int i = 0; i < s1.length(); i++) {
				chars[s1.charAt(i) - 'a']++;
				chars[s2.charAt(i) - 'a']--;
			}

			for (int i = 0; i < chars.length; i++) {
				if (chars[i] != 0)
					return false;
			}

			for (int i = 1; i < s1.length(); i++) {
				String s11 = s1.substring(0, i);
				String s12 = s1.substring(i, s1.length());
				String s21 = s2.substring(0, i);
				String s22 = s2.substring(i, s1.length());

				if (isScramble(s11, s21) && isScramble(s12, s22))
					return true;

				s21 = s2.substring(0, s1.length() - i);
				s22 = s2.substring(s1.length() - i, s1.length());

				if (isScramble(s11, s22) && isScramble(s12, s21))
					return true;
			}

			return false;
		}// end of method
	}
}
