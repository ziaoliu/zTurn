package leetcode;

/*
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.

 http://www.cnblogs.com/springfor/p/3862219.html
 http://blog.csdn.net/linhuanmars/article/details/19778441
 http://fisherlei.blogspot.com/2012/12/leetcode-remove-nth-node-from-end-of.html

 */
public class Q019_RemoveNthNodeFromEndOfList {

	public class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if (head == null)
				return head;

			ListNode original = head;
			ListNode fastRunner = head;
			ListNode slowRunner = head;

			for (int i = 0; i < n; i++)
				fastRunner = fastRunner.next;

			if (fastRunner == null)
				return head.next;

			while (fastRunner.next != null) {
				fastRunner = fastRunner.next;
				slowRunner = slowRunner.next;
			}

			slowRunner.next = slowRunner.next.next;

			return original;
		}
	}
}
