package leetcode;

/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * http://blog.csdn.net/wzy_1988/article/details/17057929
 */

public class Roman2IntegerOJ {
	public class Solution {
		public int romanToInt(String s) {
			char[] array = s.toCharArray();
			int sum = 0;
			for (int i = 0; i < array.length; i++) {
				if (i + 1 < array.length
						&& helper(array[i + 1]) > helper(array[i])) {
					sum = sum + helper(array[i + 1]) - helper(array[i]);
					i++;
				} else
					sum = sum + helper(array[i]);
			}
			return sum;
		}

		private int helper(char d) {
			int temp = 0;
			switch (d) {
			case 'I':
				temp = 1;
				break;
			case 'V':
				temp = 5;
				break;
			case 'X':
				temp = 10;
				break;
			case 'L':
				temp = 50;
				break;
			case 'C':
				temp = 100;
				break;
			case 'D':
				temp = 500;
				break;
			case 'M':
				temp = 1000;
				break;
			}
			return temp;
		}
	} // end of solution
}
