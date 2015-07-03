package leetcode;

/* Search in Rotated Sorted Array
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 */
public class SearchInRotatedSortedArrayOJ {
	public class Solution {
		public int search(int[] A, int target) {
			if (null == A || A.length == 0)
				return -1;

			int i = 0;
			int j = A.length - 1;
			while (i <= j) {
				int center = (i + j) / 2;
				if (A[center] == target)
					return center;
				if (A[center] < A[j]) {
					// higher section is sequential
					if (target > A[center] && target <= A[j])
						i = center + 1;
					else
						j = center - 1;
				} else {
					// lower section is sequential
					if (target >= A[i] && target < A[center])
						j = center - 1;
					else
						i = center + 1;
				}
			}
			return -1;
		}
	}
}
