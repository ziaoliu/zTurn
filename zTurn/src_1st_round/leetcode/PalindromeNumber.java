package leetcode;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */

public class PalindromeNumber {
	public static void main(String[] args) {
		PalindromeNumber ss = new PalindromeNumber();
		Solution s = ss.new Solution();
		System.out.println(s.isPalindrome(1));
	}

	public class Solution {
		public boolean isPalindrome(int x) {

			int orig = x;
			int result = 0;
			int flag = 1;

			if (x < 0)
				flag = -1;

			while (x > 0) {
				int digit = x % 10;
				x = x / 10;
				result = result * 10 + digit;
			}

			result = flag * result;

			if (orig == result)
				return true;
			else
				return false;

		}

		public boolean isPalindrome2(int x) {

			if (x < 0)
				return false;

			int level = 1;

			while (x / level >= 10) {
				level = level * 10;
			}

			while (x > 0) {
				int l = x / level;
				int r = x % 10;
				if (l != r)
					return false;
				x = (x % level) / 10;
				level = level / 100;
			}
			return true;

		}
	}
}
