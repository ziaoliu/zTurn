package leetcode;

/*
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

 http://blog.csdn.net/linhuanmars/article/details/20192227
 */
public class Q067_AddBinary {
	public class Solution {
		public String addBinary(String a, String b) {
			int l1 = a.length() - 1;
			int l2 = b.length() - 1;
			StringBuilder sb = new StringBuilder();
			int carryOver = 0;
			while (l1 >= 0 || l2 >= 0) {
				int a1 = 0;
				int b1 = 0;
				if (l1 >= 0)
					a1 = a.charAt(l1--) - '0';
				if (l2 >= 0)
					b1 = b.charAt(l2--) - '0';
				int sum = carryOver + a1 + b1;
				sb.insert(0, sum % 2);
				carryOver = sum / 2;
			}
			if (carryOver == 1)
				sb.insert(0, 1);
			return sb.toString();
		}
	}

	public class SolutionStupid {
		public String addBinary(String a, String b) {
			int l1 = a.length() - 1;
			int l2 = b.length() - 1;
			StringBuilder sb = new StringBuilder();
			char carryOver = '0';
			while (l1 >= 0 || l2 >= 0) {
				char a1 = '0';
				char b1 = '0';
				if (l1 >= 0)
					a1 = a.charAt(l1--);
				if (l2 >= 0)
					b1 = b.charAt(l2--);

				if (carryOver == '0') {
					if (a1 == '0' && b1 == '0') {
						sb.insert(0, '0');
						carryOver = '0';
					} else if (a1 == '1' && b1 == '1') {
						sb.insert(0, '0');
						carryOver = '1';
					} else {
						sb.insert(0, '1');
						carryOver = '0';
					}
				} else {
					if (a1 == '0' && b1 == '0') {
						sb.insert(0, '1');
						carryOver = '0';
					} else if (a1 == '1' && b1 == '1') {
						sb.insert(0, '1');
						carryOver = '1';
					} else {
						sb.insert(0, '0');
						carryOver = '1';
					}
				}
			}// end while
			if (carryOver == '1')
				sb.insert(0, '1');
			return sb.toString();
		}
	}
}
