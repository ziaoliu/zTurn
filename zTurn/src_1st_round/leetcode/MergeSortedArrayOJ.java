package leetcode;

import java.util.Arrays;

/* Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements 
 * from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * http://fisherlei.blogspot.com/2012/12/leetcode-merge-sorted-array.html
 */
public class MergeSortedArrayOJ {
	public class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			if (m == 0 && n == 0)
				return;
//			if (m == 0) {
//				System.arraycopy(nums1, 0, nums2, 0, nums2.length);
//				return;
//			}
			if (n <= 0)
				return;

			while (m > 0 && n > 0) {
				if (nums1[m - 1] >= nums2[n - 1]) {
					nums1[m + n - 1] = nums1[m - 1];
					m--;
				} else {
					nums1[m + n - 1] = nums2[n - 1];
					n--;
				}
			}
			if (n != 0)
				for (; n > 0; n--) {
					nums1[n - 1] = nums2[n - 1];
				}
		}// end of method
	}
}
