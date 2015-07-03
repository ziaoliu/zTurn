package leetcode;

/* Interleaving String
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24683159
 * http://blog.csdn.net/u011095253/article/details/9248073
 * http://fisherlei.blogspot.com/2012/12/leetcode-interleaving-string.html
 * http://blog.welkinlan.com/2015/04/28/interleaving-string-leetcode-java-dp/
 */
public class InterleavingStringOJ {
	public class Solution {
		public boolean isInterleave(String s1, String s2, String s3) {
			if (s1 == null || s2 == null || s3 == null)
				return false;
			if (s1.length() + s2.length() != s3.length())
				return false;

			boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
			dp[0][0] = true;

			for (int i = 1; i < s1.length() + 1; i++)
				if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0])
					dp[i][0] = true;
			for (int i = 1; i < s2.length() + 1; i++)
				if (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1])
					dp[0][i] = true;

			for (int i = 1; i < s1.length() + 1; i++) {
				for (int j = 1; j < s2.length() + 1; j++) {
					if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]
							|| s2.charAt(j - 1) == s3.charAt(i + j - 1)
							&& dp[i][j - 1])
						dp[i][j] = true;
				}
			}

			return dp[s1.length()][s2.length()];
		}
	}
}
