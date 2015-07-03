package leetcode;

import java.util.ArrayList;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * http://www.cnblogs.com/TenosDoIt/p/3771254.html
 * http://shanjiaxin.blogspot.com/2014/02/letter-combinations-of-phone-number.html
 */

public class LetterCombinationsofPhoneNumbersOJ {
	public static void main(String[] args) {
		Solution s = new LetterCombinationsofPhoneNumbersOJ().new Solution();
		System.out.println(s.letterCombinations("234"));
	}

	public class Solution {
		public ArrayList<String> letterCombinations(String digits) {

			ArrayList<String> result = new ArrayList<String>();

			if (null == digits || digits.length() <= 0)
				return result;

			dfs(digits, 0, result, new StringBuilder());

			return result;
		}

		private void dfs(String digits, int i, ArrayList<String> result,
				StringBuilder str) {
			// exit condition
			if (i == digits.length()) {
				result.add(str.toString());
				return;
			}

			// visit node
			String temp = getLetters(digits.charAt(i));
			for (int j = 0; j < temp.length(); j++) {
				if (i == 0)
					str = new StringBuilder();
				dfs(digits, i + 1, result, str.append(temp.charAt(j)));
				str.deleteCharAt(str.length() - 1);
				//str = new StringBuilder(str.substring(0, str.length() - 1));???

			}

		}

		private String getLetters(char c) {
			String temp = null;
			switch (c) {
			case '2':
				temp = "abc";
				break;
			case '3':
				temp = "def";
				break;
			case '4':
				temp = "ghi";
				break;
			case '5':
				temp = "jkl";
				break;
			case '6':
				temp = "mno";
				break;
			case '7':
				temp = "pqrs";
				break;
			case '8':
				temp = "tuv";
				break;
			case '9':
				temp = "wxyz";
				break;
			}
			return temp;
		}

	} // end of solution
}
