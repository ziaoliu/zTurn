package leetcode;

/*
 Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 compute how much water it is able to trap after raining.

 For example, 
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 http://www.lifeincode.net/programming/leetcode-trapping-rain-water-java/
 http://blog.csdn.net/linhuanmars/article/details/20888505
 */
public class Q042_TrappingRainWater {
	public class Solution {
		public int trap(int[] A) {
			if (A == null || A.length == 0)
				return 0;
			int[] maxLeft = new int[A.length];
			int[] maxRight = new int[A.length];

			int max = A[0];
			for (int i = 1; i < A.length; i++) {
				maxLeft[i] = max;
				if (A[i] > max)
					max = A[i];
			}

			max = A[A.length - 1];
			for (int i = A.length - 2; i >= 0; i--) {
				maxRight[i] = max;
				if (A[i] > max)
					max = A[i];
			}

			int sum = 0;
			for (int i = 0; i < A.length; i++) {
				int bucket = Math.min(maxLeft[i], maxRight[i]) - A[i];
				if (bucket <= 0)
					continue;
				sum = sum + bucket;
			}
			return sum;
		}
	}

	public class SolutionTLE {
		public int trap(int[] A) {
			if (A == null || A.length == 0)
				return 0;
			int[] maxLeft = new int[A.length];
			int[] maxRight = new int[A.length];

			// max left
			for (int i = 1; i < A.length; i++) {
				int max = 0;
				for (int j = i; j >= 0; j--) {
					if (A[j] > max)
						max = A[j];
				}
			}

			// max right
			for (int i = 1; i < A.length; i++) {
				int max = 0;
				for (int j = i; j < A.length; j++) {
					if (A[j] > max)
						max = A[j];
				}
			}

			int sum = 0;
			// calculate bucket by bucket
			for (int i = 0; i < A.length; i++) {
				int bucket = 0;
				if (maxLeft[i] <= A[i] || maxRight[i] <= A[i])
					continue;
				bucket = A[i] - Math.min(maxLeft[i], maxRight[i]);
				sum = sum + bucket;
			}
			return sum;
		}
	}
}
