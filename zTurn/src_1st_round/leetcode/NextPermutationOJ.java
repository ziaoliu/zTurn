package leetcode;

/* Next Permutation
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
 * 
 * http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
 * http://www.lifeincode.net/programming/leetcode-next-permutation-java/
 */

public class NextPermutationOJ {
	public static void main(String[] args) {
		NextPermutationOJ test = new NextPermutationOJ();
		Solution t = test.new Solution();
		int[] array = { 3, 2, 1 };
		t.nextPermutation(array);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public class Solution {
		public void nextPermutation(int[] num) {

			if (null == num || num.length <= 1)
				return;

			int i = 0;
			int j = 0;

			for (i = num.length - 1; i > 0; i--) {
				if (num[i] > num[i - 1])
					break;
			}

			if (i != 0) {
				i = i - 1;
				for (j = num.length - 1; j >= 0; j--) {
					if (num[j] > num[i])
						break;
				}
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				i++;
			}

			for (j = num.length - 1; j >= i; i++, j--) {
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}

		}
	}
}
