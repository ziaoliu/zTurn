package leetcode;

/*

 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
 Given n will always be valid.
 Try to do this in one pass. 
 
 http://blog.csdn.net/u010500263/article/details/18429061

 */

public class RemoveNthNodeFromEndofList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; next = null; } }
	 */
	public class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if (head == null)
				return null;
			if (n == 0)
				return head;

			ListNode runner = head;

			if (head.next == null)
				return null;

			int temp = 0;
			while (temp < n && runner != null) {
				runner = runner.next;
				temp++;
			}

			if (runner == null) { // ==> fast pointer is null, this mean the
									// head element needs to be removed
				head = head.next;
				return head;
			}

			ListNode runner2 = head;

			while (runner.next != null) {
				runner = runner.next;
				runner2 = runner2.next;
			}

			if (runner2.next == null || runner2.next.next == null)
				runner2.next = null;
			else
				runner2.next = runner2.next.next;

			return head;
		}
	}
}
