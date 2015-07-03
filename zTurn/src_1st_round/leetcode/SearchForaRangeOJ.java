package leetcode;

/* Search for a Range
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * http://fisherlei.blogspot.com/2013/01/leetcode-search-for-range.html
 */
public class SearchForaRangeOJ {
	public class Solution {
		public int[] searchRange(int[] A, int target) {
			int[] result = new int[] { -1, -1 };
			if (null == A || A.length <= 0)
				return result;

			int i = 0;
			int j = A.length - 1;
			boolean flag = false;
			while (i <= j) {
				// nothing found
				if (!flag) {
					int center = (j + i) / 2;
					if (A[center] == target) {
						flag = true;
						i = center;
						j = center;
						result[0] = i;
						result[1] = j;
						continue;
					} else if (A[center] > target) {
						j = center - 1;
					} else {
						i = center + 1;
					}
				} else {
					// found at least one and then expand
					if (i > 0) {
						if (A[i - 1] == target)
							i = i - 1;
					}
					if (j < A.length - 1) {
						if (A[j + 1] == target)
							j = j + 1;
					}

					if (result[0] == i && result[1] == j)
						break;

					result[0] = i;
					result[1] = j;
				}
			}
			return result;
		}//end of method
	}
}
