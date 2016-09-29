package leetcode;

public class Q_002_AddTwoNumbers {
	public class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode result = new ListNode(-1);
			if (l1 == null && l2 == null)
				return null;
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l2;
			ListNode temp = result;
			int carryover = 0;
			while (l1 != null || l2 != null) {
				int a = 0;
				int b = 0;
				if (l1 != null) {
					a = l1.val;
					l1 = l1.next;
				}
				if (l2 != null) {
					b = l2.val;
					l2 = l2.next;
				}
				int sum = a + b + carryover;
				if (sum >= 10) {
					carryover = 1;
					sum = sum - 10;
				} else
					carryover = 0;
				temp.next = new ListNode(sum);
				temp = temp.next;
			}
			if (carryover == 1)
				temp.next = new ListNode(1);
			return result.next;
		}
	}
}
