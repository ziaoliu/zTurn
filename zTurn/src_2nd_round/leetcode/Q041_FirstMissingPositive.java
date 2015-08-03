package leetcode;

/*
 Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.

 http://blog.csdn.net/linhuanmars/article/details/20884585
 */
public class Q041_FirstMissingPositive {
	public class Solution {
		public int firstMissingPositive(int[] A) {
			if (A == null || A.length == 0)
				return 1;
			for (int i = 0; i < A.length; i++) {
				if (A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
					int temp = A[A[i] - 1];
					A[A[i] - 1] = A[i];
					A[i] = temp;
					i--;
				}
			}

			for (int i = 0; i < A.length; i++) {
				if (i + 1 != A[i])
					return i + 1;
			}

			return A.length + 1;
		}
	}
}
