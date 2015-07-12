package leetcode;

/*
 Determine whether an integer is a palindrome. Do this without extra space.

 */
public class Q009_PalindromeNumber {
	public class Solution {
		public boolean isPalindrome(int x) {
			if (x < 0)
				return false;
			if (x < 10)
				return true;

			int digits = 1;
			while (x / digits >= 10) //<<<<<<<<<<<<<<<<<<< condition!!!!!
				digits = digits * 10;

			while (x > 0) {
				int start = x / digits;
				int end = x % 10;
				if (start != end)
					return false;
				x = (x % digits) / 10;
				digits = digits / 100; // two digits removed
			}
			return true;
		}
	}
}
