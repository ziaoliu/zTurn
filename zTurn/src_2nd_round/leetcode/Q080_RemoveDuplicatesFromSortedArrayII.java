package leetcode;

/*
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
 It doesn't matter what you leave beyond the new length.
 */
public class Q080_RemoveDuplicatesFromSortedArrayII {
	public class Solution {
		public int removeDuplicates(int[] A) {
			if (A == null || A.length <= 2)
				return A == null ? 0 : A.length;

			int i = 1;
			for (int j = 2; j < A.length; j++) {
				if (A[i - 1] != A[j])
					A[++i] = A[j];
			}

			return i + 1;
		}
	}

	public class SolutionSlow {
		public int removeDuplicates(int[] A) {
			if (A == null || A.length == 0)
				return 0;

			boolean flag = true;
			int i = 0;
			for (int j = 1; j < A.length; j++) {
				if (A[i] != A[j]) {
					A[++i] = A[j];
					flag = true;
				} else if (A[i] == A[j] && flag) {
					A[++i] = A[j];
					flag = false;
				}
			}
			return i + 1;
		}
	}
}
