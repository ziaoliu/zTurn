package leetcode;

/* Search in Rotated Sorted Array
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 * Yes, impact. Worse case O(n)
 * 
 * http://fisherlei.blogspot.com/2013/01/leetcode-search-in-rotated-sorted-array_3.html
 * http://blog.csdn.net/linhuanmars/article/details/20588511
 */
public class SearchInRotatedSortedArrayIIOJ {
	public class Solution {
		public boolean search(int[] A, int target) {
			if (null == A || A.length == 0)
				return false;

			int i = 0;
			int j = A.length - 1;
			while (i <= j) {
				int center = (i + j) / 2;
				if (A[center] == target)
					return true;
				if (A[center] < A[i]) {
					// higher section is sequential
					if (target > A[center] && target <= A[j])
						i = center + 1;
					else
						j = center - 1;
				} else if (A[center] > A[i]) {
					// lower section is sequential
					if (target >= A[i] && target < A[center])
						j = center - 1;
					else
						i = center + 1;
				} else {// A[center] = A[i] = A[j]
					i++;
				}
			}
			return false;
		}
	}
}
