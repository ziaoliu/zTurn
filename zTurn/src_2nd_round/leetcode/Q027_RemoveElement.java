package leetcode;

/*
 Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Q027_RemoveElement {
	public static void main(String[] args) {
		Q027_RemoveElement test = new Q027_RemoveElement();
		Solution t = test.new Solution();
		int[] a = { 2, 2 };
		System.out.println(t.removeElement(a, 5));
	}

	public class SolutionBest {
		public int removeElement(int[] A, int elem) {
			if (A == null || A.length <= 1)
				return A == null ? 0 : A.length;

			int i = 0;
			int j = 0;

			for (; j < A.length; j++) {
				if (A[j] != elem)
					A[i++] = A[j];
			}
			return i;
		}
	}

	public class Solution {
		public int removeElement(int[] A, int elem) {
			if (A == null || A.length <= 1)
				return A == null ? 0 : A.length;

			int i = 0;
			int j = 0;

			for (; j < A.length; j++) {
				if (A[i] == elem) {
					if (A[j] != elem) {
						A[i++] = A[j];
					}
				} else {
					i++;
				}
			}
			return i + 1;
		}
	}
}
