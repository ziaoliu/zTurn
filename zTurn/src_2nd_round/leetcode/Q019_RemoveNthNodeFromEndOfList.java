package leetcode;

/*
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.


 */
public class Q019_RemoveNthNodeFromEndOfList {
	public class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if (head == null)
				return head;

			int len = 0;
			ListNode dummy = new ListNode(-1);
			dummy.next = head;

			ListNode runner = null;

			while (dummy.next != null) {
				if (len == n)
					runner = dummy;
				dummy = dummy.next;
				len++;
			}

			if (len < n || runner == null)
				return head;
			
			dummy = new ListNode(-1);
			dummy.next = head;
			
			while(n > 0){
				runner = runner.next;
			}
			
			return null;
		}
	}
}
