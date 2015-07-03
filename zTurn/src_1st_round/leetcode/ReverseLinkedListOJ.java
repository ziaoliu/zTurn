package leetcode;

/* Reverse Linked List
 * Reverse a singly linked list.
 * 
 * http://www.jiuzhang.com/solutions/reverse-linked-list/
 */
public class ReverseLinkedListOJ {
	public class Solution {
		// reverse nodes' direction in place
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

		// insert nodes in front
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
	}
}
