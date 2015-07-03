package leetcode;

public class ZigZagConversion {
	public static void main(String[] args) {
		ZigZagConversion ss = new ZigZagConversion();
		Solution s = ss.new Solution();
		System.out.println(s.convert("ABCDE", 4));
	}

	public class Solution {
		public String convert(String s, int nRows) {

			if (null == s || nRows < 1)
				return null;

			if (nRows == 1)
				return s;
			if (s.length() < 2)
				return s;

			StringBuilder sb = new StringBuilder();
			int interval = (nRows - 1) * 2;

			int counter = 0;

			for (int i = 0; i <= nRows - 1; i++) {
				counter = counter + i;
				if (counter > s.length() - 1)
					break;
				sb.append(s.charAt(counter));
				while (counter < s.length()) {
					counter = counter + interval;
					if (i != 0 && i != nRows - 1) {
						if (counter - 2 * i < s.length())
							sb.append(s.charAt(counter - 2 * i));
					}
					if (counter < s.length())
						sb.append(s.charAt(counter));

				}
				counter = 0;
			}
			return sb.toString();
		}
	}
}
