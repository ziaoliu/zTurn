package leetcode;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 * http://www.programcreek.com/2013/02/leetcode-palindrome-number-java/
 */

public class PalindromeNumberOJ {

	public class Solution {
		public boolean isPalindrome(int x) {
			if (x < 0)
				return false;
			if (x > 0 && x / 10 == 0)
				return true;

			boolean sign = false;

			if (x < 0) {
				sign = true;
				x = -1 * x;
			}

			int sum = 0;
			int copy = x;

			while (x > 0) {
				int digit = x % 10;
				x = x / 10;
				if (sum <= Integer.MAX_VALUE)
					sum = sum * 10 + digit;
				else
					return false;
				if (sum < 0)
					return false;
			}

			return sign ? copy == -1 * sum : copy == sum;

		}

		public boolean isPalindrome2(int x) {
			if (x < 0)
				return false;
			if (x < 10)
				return true;

			int scale = 1;

			while (x / scale >= 10) { // can be equal to 10 
				scale = scale * 10;
			}

			while (x > 0) {
				int left = x / scale;
				int right = x % 10;

				if (left != right)
					return false;

				x = (x % scale) / 10;
				scale = scale / 100; // taking out two digits
			}
			return true;

		}
	} // end of solution
}
