package leetcode;

/* Distinct Subsequences
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-distinct-subsequences.html
 * http://www.cnblogs.com/springfor/p/3896152.html
 * http://blog.csdn.net/abcbc/article/details/8978146
 * http://blog.csdn.net/linhuanmars/article/details/23589057
 */
public class DistinctSubsequencesOJ {
	public class Solution {
		public int numDistinct(String s, String t) {
			if (s == null && t == null)
				return 1;
			if (s == null || t == null || s.length() == 0 || t.length() == 0
					|| t.length() > s.length())
				return 0;

			int[][] dp = new int[t.length() + 1][s.length() + 1]; // dp[i(t)][j(s)]
			dp[0][0] = 1;

			for (int col = 1; col < s.length() + 1; col++) // t is empty
				dp[0][col] = 1;
			for (int row = 1; row < t.length() + 1; row++) // s is empty
				dp[row][0] = 0;

			for (int i = 1; i < t.length() + 1; i++) {
				for (int j = 1; j < s.length() + 1; j++) {
					dp[i][j] = dp[i][j - 1];
					if (t.charAt(i - 1) == s.charAt(j - 1))
						dp[i][j] += dp[i - 1][j - 1];
				}
			}

			return dp[t.length()][s.length()];
		}
	}
}
