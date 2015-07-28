package leetcode;

/*
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 ¡ú 1,3,2
 3,2,1 ¡ú 1,2,3
 1,1,5 ¡ú 1,5,1

 http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
 */
public class Q031_NextPermutation {
	public class Solution {
		public void nextPermutation(int[] num) {
			if (num == null || num.length == 0)
				return;

			int i = num.length - 1;
			int j = num.length - 1;

			for (; i > 0; i--) {
				if (num[i - 1] < num[i]) {
					break;
				}
			}

			if (i != 0) {
				i--;
				for (; j >= 0; j--) {
					if (num[i] < num[j]) {
						break;
					}
				}

				int temp = num[j];
				num[j] = num[i];
				num[i] = temp;

				i++;
			}

			for (j = num.length - 1; j >= i; j--, i++) {
				int temp = num[j];
				num[j] = num[i];
				num[i] = temp;
			}

		}// end of method
	}
}
