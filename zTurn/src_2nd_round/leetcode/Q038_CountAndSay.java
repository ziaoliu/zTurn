package leetcode;

/*
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 http://blog.csdn.net/linhuanmars/article/details/20679963
 */
public class Q038_CountAndSay {
	public class Solution {
		public String countAndSay(int n) {
			if (n <= 0)
				return "";

			StringBuilder sb = new StringBuilder();
			sb.append(1);

			for (int i = 0; i < n - 1; i++) {
				String temp = sb.toString();
				sb = new StringBuilder();
				int j = 1;
				int count = 1;
				while (j < temp.length()) {
					if (temp.charAt(j) != temp.charAt(j - 1)) {
						sb.append(count).append(temp.charAt(j - 1));
						count = 1;
					} else
						count++;
					j++;
				}
				sb.append(count).append(temp.charAt(j - 1));
			}

			return sb.toString();
		}
	}
}
