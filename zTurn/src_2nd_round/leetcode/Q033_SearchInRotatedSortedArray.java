package leetcode;

/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 
 http://blog.csdn.net/linhuanmars/article/details/20525681
 */
public class Q033_SearchInRotatedSortedArray {
	public class Solution {
		public int search(int[] A, int target) {
			if (A == null || A.length == 0)
				return 0;
			if (A.length == 1)
				return A[0] == target ? 0 : -1;

			int i = 0;
			int j = A.length - 1;

			while (i <= j) {
				int m = (i + j) / 2;
				if (A[m] == target)
					return m;
				if (A[m] < A[j])
					if (A[m] < target && A[j] >= target)
						i = m + 1;
					else
						j = m - 1;
				else {
					if (A[m] > target && A[i] <= target)
						j = m - 1;
					else
						i = m + 1;
				}
			}
			return -1;
		}
	}
}
