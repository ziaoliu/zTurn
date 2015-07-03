package leetcode;

/*

 ZigZag Conversion

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

public class ZigZagConversionOJ {
	public class Solution {
		public String convert(String s, int nRows) {
			if (null == s)
				return null;
			if (s.length() <= 0)
				return "";

			if (nRows <= 1)
				return s;

			char[][] array = new char[nRows][s.length()];
			boolean switchButton = false;
			int row = 0;

			// [i/nRows][row]
			int col = 0;
			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				array[row][col] = temp;
				if (row > 0 && switchButton) {
					row--;
					col++;
				}
				if (row < nRows - 1 && !switchButton) {
					row++;
				}
				if (row == nRows - 1)
					switchButton = true;
				if (row == 0)
					switchButton = false;
			}

			StringBuilder sb = new StringBuilder(s.length());

			for (int i = 0; i < nRows; i++) {
				for (int j = 0; j < s.length(); j++) {
					// System.out.print(array[i][j] + " ");
					if (array[i][j] != 0)
						sb.append(array[i][j]);
				}
				// System.out.println();
			}

			return sb.toString();
		}

		public String convert2(String s, int nRows) {
			if (null == s)
				return null;
			if (s.length() < 1)
				return "";
			if (nRows < 1)
				return s;
			if (s.length() == 1 || nRows == 1)
				return s;

			int size = 2 * nRows - 2;

			StringBuilder sb = new StringBuilder(s.length());
			for (int i = 0; i < nRows; i++) {
				for (int j = i; j < s.length(); j = j + size) {
					sb.append(s.charAt(j));
					if (i != 0 && i != nRows - 1) {
						int temp = j + size - 2 * i;
						if (temp < s.length())
							sb.append(s.charAt(temp));
					}
				}

			}
			return sb.toString();
		}
	} // end of solution
}
