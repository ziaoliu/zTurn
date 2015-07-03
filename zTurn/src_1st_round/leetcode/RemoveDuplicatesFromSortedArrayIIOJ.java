package leetcode;

/*  * Remove Duplicates from Sorted Array II
 *  * 
 *  * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *  * Do not allocate extra space for another array, you must do this in place with constant memory.
 *  * For example,
 *  * Given input array A = [1,1,2],
 *  * Your function should return length = 2, and A is now [1,2].
 * 
 * http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/
 * 
 * =====================================================
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-remove-duplicates-from-sorted.html
 */

public class RemoveDuplicatesFromSortedArrayIIOJ {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayIIOJ solution = new RemoveDuplicatesFromSortedArrayIIOJ();
		Solution test = solution.new Solution();
		int[] a = { 1, 1 };
		System.out.println(test.removeDuplicates(a));
	}
	
	public int removeDuplicates(int[] A) {
		if (null == A)
			return 0;

		if (A.length <= 2)
			return A.length;

		int j = 1;
		for (int i = 2; i < A.length; i++) {
			if (A[j - 1] != A[i])
				A[++j] = A[i];
		}

		return j + 1;
	}

	public class Solution {
		public int removeDuplicates(int[] A) {
			if (null == A)
				return 0;

			if (A.length <= 1)
				return A.length;

			int j = 0;
			int counter = 1;
			for (int i = 1; i < A.length; i++) {
				if (A[i] != A[j]) {
					j++;
					A[j] = A[i];
					counter = 1;
				} else if (A[i] == A[j] && counter == 1) {
					j++;
					A[j] = A[i];
					counter++;
				}else if(A[i] == A[j] && counter > 1)
					counter++;

			}

			return j + 1;
		}
	}
}
