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

public class RemoveNthNodeFromEndofListOJ {

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
			if (null == head)
				return null;

			ListNode original = head;
			ListNode p = head;

			while (n > 0 && p != null) {

				p = p.next;
				n--;

			}

			if (n > 0)
				return original;
			else if(n == 0 && p == null)
				return original.next;

			while (p != null && p.next != null) {
				head = head.next;
				p = p.next;

			}

			if (head.next != null)
				head.next = head.next.next;

			return original;

		}
	} // end of solution
}
