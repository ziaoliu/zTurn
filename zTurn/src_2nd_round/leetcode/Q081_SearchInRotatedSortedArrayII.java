package leetcode;

/*
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.

 http://fisherlei.blogspot.com/2013/01/leetcode-search-in-rotated-sorted-array_3.html
 http://blog.csdn.net/linhuanmars/article/details/20588511
 */
public class Q081_SearchInRotatedSortedArrayII {
	public class Solution {
		public boolean search(int[] A, int target) {
			if (A == null || A.length == 0)
				return false;
			int i = 0;
			int j = A.length - 1;
			while (i <= j) {
				int c = (i + j) / 2;
				if (A[c] == target)
					return true;
				if (A[i] > A[c]) {
					if (A[c] < target && target <= A[j])
						i = c + 1;
					else
						j = c - 1;
				} else if (A[i] < A[c]) {
					if (A[i] <= target && target < A[c])
						j = c - 1;
					else
						i = c + 1;
				} else
					i++;
			}
			return false;
		}
	}
}
