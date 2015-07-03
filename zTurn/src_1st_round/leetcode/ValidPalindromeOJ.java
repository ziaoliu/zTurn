package leetcode;

/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindromeOJ {
	public static void main(String[] args) {
		ValidPalindromeOJ test = new ValidPalindromeOJ();
		Solution cas = test.new Solution();
		System.out.println(cas.isPalindrome("ab"));
	}

	public class Solution {
		public boolean isPalindrome(String s) {
			if (s == null || s.trim().length() == 0)
				return true;
			s = s.trim().toLowerCase();
			int i = 0, j = s.length() - 1;
			while (i <= j) {
				char start = s.charAt(i);
				if ((start > 'z' || start < 'a')
						&& (start < '0' || start > '9')) {
					i++;
					continue;
				}

				char end = s.charAt(j);
				if ((end > 'z' || end < 'a') && (end < '0' || end > '9')) {
					j--;
					continue;
				}
				if (start == end) {
					i++;
					j--;
				} else
					return false;
			}
			return true;
		}
	}
}
