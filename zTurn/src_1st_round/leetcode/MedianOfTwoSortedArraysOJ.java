package leetcode;

import java.util.Arrays;

/*
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

//http://leetcode.com/2011/03/median-of-two-sorted-arrays.html
//http://codeganker.blogspot.com/2014/02/median-of-two-sorted-arrays-leetcode.html
//http://yucoding.blogspot.com/2013/01/leetcode-question-50-median-of-two.html
public class MedianOfTwoSortedArraysOJ {
	public class Solution {
		public double findMedianSortedArrays(int a[], int b[]) {

			if (a.length <= 0 && b.length <= 0)
				return Integer.MAX_VALUE;
			else if (a.length <= 0 || b.length <= 0)
				return a.length <= 0 ? median(b, 0, b.length - 1) : median(a,
						0, a.length - 1);

			int startA = 0, endA = a.length - 1, startB = 0, endB = b.length - 1;
			while (true) {
				double aM = median(a, startA, endA);
				double bM = median(b, startB, endB);

				System.out.println(startA + " : " + endA + " | " + startB + " : " + endB);

				int lengthA = endA - startA + 1;
				int lengthB = endB - startB + 1;

				if (lengthA <= 2 && lengthB <= 2)
					return (double)(Math.max(a[startA], b[startB]) + Math.min(a[endA],
							b[endB])) / 2;

				if (aM < bM) {
					if (lengthA > 2)
						if ((endA - startA + 1) % 2 == 0)
							startA = (endA - startA + 1) / 2 - 1;
						else
							startA = (endA - startA + 1) / 2;
					if (lengthB > 2)
						endB = (endB - startB + 1) / 2;
				} else if (aM > bM) {
					if (lengthB > 2)
						if ((endB - startB + 1) % 2 == 0)
							startB = (endB - startB + 1) / 2 - 1;
						else
							startB = (endB - startB + 1) / 2;
					if (lengthA > 2)
						endA = (endA - startA + 1) / 2;
				} else {
					return aM;
				}

			}

		}

		public double median(int[] array, int i, int j) {
			if (null == array || array.length <= 0)
				return Double.MAX_VALUE;

			int length = j - i + 1;

			if (length == 1)
				return array[i];

			boolean even = length % 2 == 0;

			if (even)
				return (double) (array[i + length / 2] + array[i + length / 2
						- 1]) / 2;
			else
				return array[i + length / 2];
		}

	}// end Solution
}
