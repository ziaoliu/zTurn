package leetcode;

/*
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Q070_ClimbingStairs {

	public static void main(String[] args) {
		Q070_ClimbingStairs test = new Q070_ClimbingStairs();
		Solution s = test.new Solution();
		System.out.println(s.climbStairs(44));
	}

	public class Solution {
		// dp
		public int climbStairs(int n) {
			if (n <= 1)
				return n;
			int[] dp = new int[n + 1];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
			return dp[n];
		}
	}

	public class SolutionRecur {
		public int climbStairs(int n) {
			if (n < 0)
				return 0;
			if (n == 0)
				return 1;

			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}
}
