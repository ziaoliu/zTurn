package leetcode;

/* Search Insert Position
 * 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * 
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-search-insert-position.html
 */
public class SearchInsertPositionOJ {
	public class Solution {
		public int searchInsert(int[] A, int target) {
			if (null == A || A.length == 0)
				return -1;

			int i = 0;
			int j = A.length - 1;
			while (i <= j) {
				int center = (i + j) / 2;
				if (A[center] == target)
					return center;
				else if (A[center] > target) {
					// take lower part
					j = center - 1;
				} else {
					// take higher part
					i = center + 1;
				}
			}

			return i;

		}

		public int searchInsert2(int[] A, int target) {
			if (null == A || A.length == 0)
				return -1;

			int i = 0;
			int j = A.length - 1;
			while (i <= j) {
				int center = (i + j) / 2;
				if (A[center] == target)
					return center;
				else if (A[center] > target) {
					// take lower part
					if (center - 1 < 0)
						break;
					j = center - 1;
				} else {
					// take higher part
					if (center + 1 > A.length - 1)
						break;
					i = center + 1;
				}
			}

			if (A[i] > target)
				return i;
			else if (A[i] < target)
				return j + 1;
			else
				return j;

		}
	}
}
