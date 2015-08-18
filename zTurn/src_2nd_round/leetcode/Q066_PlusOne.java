package leetcode;

/*
 Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 http://blog.csdn.net/linhuanmars/article/details/22365957
 */
public class Q066_PlusOne {
	public class Solution {
		public int[] plusOne(int[] digits) {
			if (digits == null || digits.length == 0)
				return digits;
			int carryOver = 1;
			for (int i = digits.length - 1; i >= 0; i--) {
				int sum = carryOver + digits[i];
				digits[i] = sum % 10;
				carryOver = sum / 10;
				if (carryOver == 0)
					return digits;
			}
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}
	}

	public class SolutionStupid {
		public int[] plusOne(int[] digits) {
			if (digits == null || digits.length == 0)
				return digits;
			int carryOver = 1;
			for (int i = digits.length - 1; i >= 0; i--) {
				int sum = carryOver + digits[i];
				if (sum >= 10) {
					digits[i] = sum - 10;
					carryOver = 1;
				} else {
					digits[i] = sum;
					carryOver = 0;
				}
			}
			if (carryOver > 0) {
				int[] newDigits = new int[digits.length + 1];
				newDigits[0] = 1;
				for (int i = 0; i < digits.length; i++)
					newDigits[i + 1] = digits[i];
				return newDigits;
			}
			return digits;
		}
	}
}
