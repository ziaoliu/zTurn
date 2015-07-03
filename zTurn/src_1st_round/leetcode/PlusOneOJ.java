package leetcode;

/* Plus One
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/22365957
 */

public class PlusOneOJ {
	public class Solution {
		public int[] plusOne(int[] digits) {
			if (null == digits || digits.length == 0)
				return digits;
			int carry = 1;
			for (int i = digits.length - 1; i >= 0; i--) {
				int digit = (digits[i] + carry) % 10;
				carry = (digits[i] + carry) / 10;
				digits[i] = digit;
				if (carry == 0)
					return digits;
			}

			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}
	}
}
