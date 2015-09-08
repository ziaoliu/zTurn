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
public class Q125_ValidPalindrome {
	public class Solution {
		public boolean isPalindrome(String s) {
			if (s == null || s.trim().length() == 0)
				return true;
			s = s.trim().toLowerCase();
			int start = 0;
			int end = s.length() - 1;
			while (start <= end) {
				char startChar = s.charAt(start);
				if ((startChar < 'a' || startChar > 'z')
						&& (startChar < '0' || startChar > '9')) {
					start++;
					continue;
				}
				char endChar = s.charAt(end);
				if ((endChar < 'a' || endChar > 'z')
						&& (endChar < '0' || endChar > '9')) {
					end--;
					continue;
				}
				if (startChar != endChar)
					return false;
				else {
					start++;
					end--;
				}
			}
			return true;
		}
	}
}
