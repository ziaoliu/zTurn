package leetcode;

/* Count and Say
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * 
 * 
 */
public class CountAndSayOJ {
	public class Solution {
		public String countAndSay(int n) {
			if (n <= 0)
				return "";

			String result = "1";
			if (n == 1)
				return result;

			for (int i = 1; i < n; i++) {
				StringBuilder temp = new StringBuilder();
				int count = 1;
				char c = result.charAt(0);
				for (int j = 1; j < result.length(); j++) {
					if (result.charAt(j) != c) {
						temp.append(count).append(c);
						count = 1;
						c = result.charAt(j);
					}else{
						count++;
					}
				}
				temp.append(count).append(c);
				result = temp.toString();

			}
			return result;
		}
	}
}
