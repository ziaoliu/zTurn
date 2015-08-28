package leetcode;

/*
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
 The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class Q088_MergeSortedArray {
	public class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			if ((nums1 == null || nums1.length == 0)
					&& (nums1 == null || nums1.length == 0))
				return;
			if (m == 0 && n == 0)
				return;

			int l = m + n - 1;
			while (m > 0 && n > 0) {
				int tmp = 0;
				if (nums1[m - 1] > nums2[n - 1])
					tmp = nums1[--m];
				else
					tmp = nums2[--n];
				nums1[l--] = tmp;
			}
			while (n > 0) {
				nums1[l--] = nums2[n--];
			}

		}// end of method
	}
}
