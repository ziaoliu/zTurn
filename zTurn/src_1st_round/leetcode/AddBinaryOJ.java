package leetcode;

/* Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * http://fisherlei.blogspot.com/2013/01/leetcode-add-binary.html
 */

public class AddBinaryOJ {
	public static void main(String[] args) {
		AddBinaryOJ test = new AddBinaryOJ();
		Solution testcase = test.new Solution();
		System.out.println(testcase.addBinary("11", "1"));

	}

	public class Solution {
		public String addBinary(String a, String b) {
			if (null == a && null == b)
				return a;
			if (null == a || a.length() == 0)
				return b;
			if (null == b || b.length() == 0)
				return a;

			int aIndex = a.length() - 1;
			int bIndex = b.length() - 1;

			int carry = 0;
			StringBuilder res = new StringBuilder();
			while (aIndex >= 0 || bIndex >= 0) {
				int aTemp = 0;
				if (aIndex > -1)
					aTemp = a.charAt(aIndex) - '0';
				int bTemp = 0;
				if (bIndex > -1)
					bTemp = b.charAt(bIndex) - '0';
				int temp = aTemp + bTemp + carry;
				carry = temp / 2;
				temp = temp % 2;
				res.insert(0, temp);
				aIndex--;
				bIndex--;
			}
			if (carry == 1)
				res.insert(0, carry);
			return res.toString();
		}// end of method
	}
}
