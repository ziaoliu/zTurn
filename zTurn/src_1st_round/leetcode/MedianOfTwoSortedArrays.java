package leetcode;

/*
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
		Solution a = solution.new Solution();
		int[] aa = {1, 3, 5, 7};
		int[] bb = { 2, 4, 6 };
		double result = a.findMedianSortedArrays(aa, bb);
		System.out.println(result);
	}

	public class Solution {
		public double findMedianSortedArrays(int A[], int B[]) {
			if (A == null && B == null)
				return Double.MAX_VALUE;
			if (A.length + B.length == 0)
				return Double.MAX_VALUE;
			if (!isSorted(A) || !isSorted(B))
				return Double.MAX_VALUE;

			if (A.length + B.length == 1)
				return A.length == 0 ? B[0] : A[0];

			boolean even = ((A.length + B.length) % 2 == 0);
			int medianIndex = (A.length + B.length) / 2;

			// even => return ( medianIndex and medianIndex + 1) / 2
			// old => medianIndex
			if (even) {
				return (get(medianIndex - 1, A, B) + get(medianIndex, A, B)) / 2;
			} else {
				return get(medianIndex, A, B);
			}
		}

		// return the nth smallest number
		public double get(int index, int[] a, int[] b) {

			int m = 0;
			int n = 0;
			int pointer = 0;

			while (pointer <= index) {

				int aVal = 0;
				int bVal = 0;
				double s = 0;

				if (m < a.length)
					aVal = a[m];
				else
					aVal = Integer.MAX_VALUE;

				if (n < b.length)
					bVal = b[n];
				else
					bVal = Integer.MAX_VALUE;

				if (aVal > bVal) {
					s = bVal;
					n++;
					if (pointer == index)
						return s;
					pointer++;
				} else {
					s = aVal;
					m++;
					if (pointer == index)
						return s;
					pointer++;
				}

			}

			return Double.MAX_VALUE;
		}

		public boolean isSorted(int[] a) {

			if (a.length == 0 || a.length == 1)
				return true;

			for (int i = 1; i < a.length; i++) {
				if (a[i] < a[i - 1]) {
					return false;
				}
			}

			return true;
		}
	}
}
