package leetcode;

/*
 Given a sorted array and a target value, return the index if the target is found. 
 If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 ¡ú 2
 [1,3,5,6], 2 ¡ú 1
 [1,3,5,6], 7 ¡ú 4
 [1,3,5,6], 0 ¡ú 0
 
 http://blog.csdn.net/linhuanmars/article/details/20278967
 */
public class Q034_SearchInsertPosition {
	public class Solution {
		public int searchInsert(int[] A, int target) {
			if (A == null || A.length == 0)
				return 0;
			int i = 0;
			int j = A.length - 1;
			while (i <= j) {
				int m = (i + j) / 2;
				if (A[m] == target)
					return m;

				/*
				if (j - i == 1 && A[i] != target) {
					if (target > A[j])
						return j + 1;
					return A[i] < target ? i + 1 : i;
				}
				*/
				if (A[m] < target)
					i = m + 1;
				else
					j = m - 1;
			}
			return i;
		}
	}
}
