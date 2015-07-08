package leetcode;

/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 
 http://www.cnblogs.com/springfor/p/3889414.html
 */
public class Q006_ZigZagConversion {
	public static void main(String[] args) {
		Q006_ZigZagConversion test = new Q006_ZigZagConversion();
		Solution tt = test.new Solution();
		System.out.println(tt.convert("ABCD", 3));
	}

	public class Solution {
		public String convert(String s, int numRows) {
			if (s == null || s.length() == 0)
				return s;
			if (numRows <= 1)
				return s;
			if (s.length() <= numRows)
				return s;

			int unit = 2 * numRows - 2;
			StringBuilder sb = new StringBuilder();

			// first row
			for (int i = 0; i < s.length();) {
				sb.append(s.charAt(i));
				i = i + unit;
			}

			for (int i = 1; i < numRows - 1 && numRows > 2; i++) {
				// each row in between
				for (int j = i; j < s.length(); j = j + unit) {
					sb.append(s.charAt(j));
					int pre = j + unit - (2 * (i + 1) - 2);
					if (pre < s.length())
						sb.append(s.charAt(pre));
				}
			}

			// last row
			for (int i = numRows - 1; i < s.length();) {
				sb.append(s.charAt(i));
				i = i + unit;
			}

			return sb.toString();
		}
	}
}
