package leetcode;

/*
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 */
public class Q024_SwapNodesInPairs {
	public class Solution {
		public ListNode swapPairs(ListNode head) {
			if (head == null)
				return head;

			ListNode original = new ListNode(-1);
			original.next = head;

			ListNode pre = original;
			ListNode curr = head;
			ListNode next = head.next;

			while (curr != null && next != null) {
				ListNode p = next.next;

				// swap
				pre.next = next;
				next.next = curr;
				curr.next = p;

				// move forward
				pre = curr;
				curr = p;
				if (p == null) // when list length is even
					break;
				next = p.next;
			}

			return original.next;
		}
	}
}
