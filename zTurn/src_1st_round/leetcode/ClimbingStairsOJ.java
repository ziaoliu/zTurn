package leetcode;

/* Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * http://www.cnblogs.com/springfor/p/3886576.html
 * http://blog.csdn.net/kenden23/article/details/17377869
 */
public class ClimbingStairsOJ {
	public class Solution {
		public int climbStairs(int n) {
			if (n < 3)
				return n;
			int[] array = new int[n + 1];
			array[0] = 0;
			array[1] = 1;
			array[2] = 2;
			for (int i = 3; i < array.length; i++) {
				array[i] = array[i - 1] + array[i - 2];
			}
			return array[n];
		}

		// Recursive
		public int climbStairsRecursive(int n) {
			if (n == 0)
				return 0;
			else if (n == 1)
				return 1;
			else if (n == 2)
				return 2;
			else
				return climbStairsRecursive(n - 1)
						+ climbStairsRecursive(n - 2);
		}
	}
}
