package leetcode;

/* Sort Colors
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24286349
 * http://fisherlei.blogspot.com/2013/01/leetcode-sort-colors.html
 */
public class SortColorsOJ {
	public class Solution {
		public void sortColors(int[] A) {
			if (A == null || A.length == 0)
				return;
			int idx0 = 0;
			int idx1 = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] == 0) {
					A[i] = 2;
					A[idx1++] = 1;
					A[idx0++] = 0;
				} else if (A[i] == 1) {
					A[i] = 2;
					A[idx1++] = 1;
				}
			}
		}

		public void sortColorsFirstAttempt(int[] nums) {// two pass
			int[] colors = new int[3];
			for (int color : nums) {
				colors[color]++;
			}
			int i = 0;
			int j = 0;
			int color = 0;
			while (i < nums.length && color < 3) {
				if (colors[color] != 0) {
					if (nums[j] == color) {
						colors[color]--;
						int temp = nums[j];
						nums[j] = nums[i];
						nums[i] = temp;
						i++;
					}
					j++;
				} else {
					color++;
					j = i;
				}
			}
		}// end of method
	}
}
