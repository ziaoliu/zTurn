package leetcode;

/*
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 http://www.lifeincode.net/programming/leetcode-sort-colors-java/
 http://blog.csdn.net/linhuanmars/article/details/24286349
 */
public class Q075_SortColors {
	public class Solution {
		public void sortColors(int[] A) {
			if (A == null || A.length == 0)
				return;
			int zero = 0;
			int one = 0;
			int two = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] == 0) {
					A[two++] = 2;
					A[one++] = 1;
					A[zero++] = 0;
				} else if (A[i] == 1) {
					A[two++] = 2;
					A[one++] = 1;
				} else if (A[i] == 2) {
					A[two++] = 2;
				}
			}
		}// end of method
	}
}
