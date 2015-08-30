package leetcode;

/* Reverse a singly linked list.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q206_ReverseLinkedList {
	public class Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode pre = head;
			head = head.next;
			while (head != null) {
				pre.next = head.next;
				head.next = orig.next;
				orig.next = head;

				head = pre.next;
			}
			return orig.next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;

		ListNode origin = new ListNode(-1);
		origin.next = head;

		ListNode dummy = origin;
		ListNode pre = head;
		head = head.next;

		while (head != null) {
			pre.next = head.next;
			head.next = dummy.next;
			dummy.next = head;

			head = pre.next;
		}

		return origin.next;
	}

	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
}
