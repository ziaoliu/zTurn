package leetcode;

public class AddTwoNumberOJ {
	public class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

			if (null == l1 || null == l2) {
				return (null == l1) ? l2 : l1;
			}

			ListNode head = null;
			ListNode temp = null;
			int remainder = 0;
			while (null != l1 || null != l2) {

				int v1 = 0;
				int v2 = 0;

				if (null != l1)
					v1 = l1.val;

				if (null != l2)
					v2 = l2.val;

				int sum = v1 + v2 + remainder;
				if (sum >= 10) {
					remainder = 1;
					sum = sum - 10;
				} else
					remainder = 0;
				if (null == head) {
					head = new ListNode(sum);
					temp = head;
				} else {
					ListNode sumNode = new ListNode(sum);
					temp.next = sumNode;
					temp = temp.next;
				}
				if (null != l1)
					l1 = l1.next;
				if (null != l2)
					l2 = l2.next;
			}

			if (remainder == 1)
				temp.next = new ListNode(1);

			return head;
		}
	}// end Solution
}
