package leetcode;

/*
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


 http://www.cnblogs.com/TenosDoIt/p/3771254.html
 http://blog.csdn.net/linhuanmars/article/details/19743197
 */
import java.util.ArrayList;

public class Q017_LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		Q017_LetterCombinationsOfAPhoneNumber test = new Q017_LetterCombinationsOfAPhoneNumber();
		Solution s = test.new Solution();
		System.out.println(s.letterCombinations("9"));
	}

	public class Solution {
		public ArrayList<String> letterCombinations(String digits) {
			ArrayList<String> result = new ArrayList<>();
			if (digits == null || digits.length() == 0)
				return result;

			StringBuilder sb = new StringBuilder();

			dfs(result, digits, 0, sb);

			return result;
		}

		private void dfs(ArrayList<String> result, String digits, int i,
				StringBuilder sb) {
			if (i > digits.length())
				return;

			if (i == digits.length()) {
				if (!result.contains(sb.toString()))
					result.add(sb.toString());
				return;
			}

			String[] mapping = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
					"tuv", "wxyz" };
			int index = digits.charAt(i) - '0';
			if (index < 2 || index > 9) // <<<<<<<<<<< index and length
				return;

			String curr = mapping[index - 1];
			for (int j = 0; 9 < curr.length(); j++) {
				sb.append(curr.charAt(j));
				dfs(result, digits, i + 1, sb);// <<<<<<<<<<< past sb directly
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
