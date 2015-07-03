package leetcode;

/* Remove Duplicates from Sorted Array
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/
 */

public class RemoveDuplicatesFromSortedArrayOJ {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArrayOJ solution = new RemoveDuplicatesFromSortedArrayOJ();
		Solution test = solution.new Solution();
		int[] a = { 1, 1, 2, 3, 4, 5 };
		test.removeDuplicates(a);
	}

	public class Solution {
		public int removeDuplicates(int[] A) {
			if (null == A)
				return 0;

			if (A.length <= 1)
				return A.length;

			int slow = 0;

			for (int i = 1; i < A.length; i++) {
				if (A[slow] != A[i]) {
					slow++;
					A[slow] = A[i];
				}
			}

//			 for(int i = 0; i < slow + 1; i++){
//			 System.out.print(A[i] + " ");
//			 }

			return slow + 1;
		}
	}
}
