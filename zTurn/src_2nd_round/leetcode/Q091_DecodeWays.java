package leetcode;

/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.

 http://fisherlei.blogspot.com/2013/01/leetcode-decode-ways-solution.html
 http://blog.csdn.net/worldwindjp/article/details/19938131
 http://www.cnblogs.com/springfor/p/3896162.html
 */
public class Q091_DecodeWays {

	public class Solution {
		public int numDecodings(String s) {
			if (s == null || s.length() == 0)
				return 0;
			if (s.charAt(0) == '0')
				return 0;
			int[] dp = new int[s.length() + 1];
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 2; i <= s.length(); i++) {
				if (s.charAt(i - 1) != '0')
					dp[i] = dp[i - 1];
				if (s.charAt(i - 2) != '0') {
					int tmp = Integer.parseInt(s.substring(i - 2, i));
					if (tmp > 0 && tmp <= 26)
						dp[i] += dp[i - 2];
				}
			}
			return dp[s.length()];
		}
	}

	public class SolutionWrongDP {
		public int numDecodings(String s) {
			if (s == null || s.length() == 0)
				return 0;
			int[] dp = new int[s.length()];
			if (s.charAt(0) == '0')
				return 0;
			else
				dp[0] = 1;
			for (int i = 1; i < s.length(); i++) {

				int index = Integer.parseInt(s.substring(i - 1, i + 1));

				if (s.charAt(i) == '0' && (index > 26 || index < 1))
					return 0;

				int count = dp[i - 1];
				if (index <= 26 && index > 10)
					count++;
				dp[i] = count;
			}
			return dp[s.length() - 1];
		}
	}
}
