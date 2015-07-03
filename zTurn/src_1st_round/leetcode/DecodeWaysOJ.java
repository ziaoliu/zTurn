package leetcode;

/* Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 * http://blog.csdn.net/worldwindjp/article/details/19938131
 * http://www.cnblogs.com/springfor/p/3896162.html
 */
public class DecodeWaysOJ {
	public static void main(String[] args) {
		DecodeWaysOJ test = new DecodeWaysOJ();
		Solution solution = test.new Solution();
		System.out
				.println(solution
						.numDecodings("1168963884134125126536966946586868418993819971673459188478711546479621135253876271366851168524933185"));
	}

	// DP
	public class Solution {
		public int numDecodings(String s) {
			if (s == null || s.length() == 0)
				return 0;
			if (s.charAt(0) == '0')
				return 0;

			int[] dp = new int[s.length() + 1];
			dp[0] = dp[1] = 1;

			int current = 0;

			for (int i = 2; i < dp.length; i++) {
				current = Integer.parseInt(s.substring(i - 1, i));
				if (current != 0)
					dp[i] += dp[i - 1];

				if (s.charAt(i - 2) != '0') {
					current = Integer.parseInt(s.substring(i - 2, i));
					if (current <= 26)
						dp[i] += dp[i - 2];
				}
			}

			return dp[s.length()];
		}
	}

	// DFS
	// http://blog.csdn.net/u011095253/article/details/9248109
	public class SolutionDFS {
		public int numDecodings(String s) {
			if (s == null || s.length() == 0)
				return 0;

			int result = dfs(s, 0, "");

			return result;
		}

		public int dfs(String s, int i, String temp) {
			if (i == s.length())
				return 1;
			else if (i > s.length()) {
				return 0;
			} else {
				int oneChar = dfs(s, i + 1, temp + s.charAt(i));
				int twoChars = 0;
				if (i + 2 <= s.length() && s.charAt(i) - '0' < 3
						&& s.charAt(i + 1) - '0' < 7)
					twoChars = dfs(s, i + 2,
							temp + s.charAt(i) + s.charAt(i + 1));

				return oneChar + twoChars;
			}
		}
	}
}
