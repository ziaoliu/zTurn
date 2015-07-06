package leetcode;

/*
 You are given two linked lists representing two non-negative numbers. 
 The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class Q002_AddTwoNumbers {
	public class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode dummy = new ListNode(-1);
			ListNode node = dummy;
			if (l1 == null && l2 == null)
				return dummy.next;
			int carryOver = 0;
			while (l1 != null || l2 != null) {
				int a = 0;
				if (l1 != null)
					a = l1.val;
				int b = 0;
				if (l2 != null)
					b = l2.val;
				int sum = a + b + carryOver;
				if (sum >= 10) {
					sum = sum - 10;
					carryOver = 1;
				} else
					carryOver = 0;
				dummy.next = new ListNode(sum);
				dummy = dummy.next;
				if (l1 != null)
					l1 = l1.next;
				if (l2 != null)
					l2 = l2.next;
			}
			if (carryOver == 1)
				dummy.next = new ListNode(1);

			return node.next;
		}
	}
}
