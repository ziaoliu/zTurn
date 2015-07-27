package leetcode;

/*
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
 It doesn't matter what you leave beyond the new length.
 */
public class Q026_RemoveDuplicatesFromSortedArray {
	public class SolutionSimple {
		public int removeDuplicates(int[] A) {
			if (A == null || A.length <= 1)
				return A == null ? 0 : A.length;
			int i = 0;
			for (int j = 1; j < A.length; j++) {
				if (A[i] != A[j]) {
					A[++i] = A[j];
				}
			}
			return i + 1;
		}
	}

	public class SolutionComplex {
		public int removeDuplicates(int[] A) {
			if (A == null || A.length <= 1)
				return A == null ? 0 : A.length;
			int i = 0;
			int j = 1;
			while (j < A.length) {
				if (A[i] == A[j]) {
					while (j < A.length && A[j] == A[i])
						j++;
					if (j >= A.length)
						return i + 1;
					A[++i] = A[j];
				} else {
					i++;
					j++;
				}
			}
			return i + 1;
		}
	}
}
