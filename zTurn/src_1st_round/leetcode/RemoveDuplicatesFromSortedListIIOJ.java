package leetcode;

import leetcode.ListNode;

/* Remove Duplicates From Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24389429
 * 
 */
public class RemoveDuplicatesFromSortedListIIOJ {
	/**
	 ** Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			if (null == head)
				return null;
			ListNode origin = new ListNode(-1);

			origin.next = head;

			ListNode pre = origin;
			ListNode curr = head;

			while (null != curr) {
				while (null != curr.next && curr.next.val == pre.next.val) {
					curr = curr.next;
				}
				if (pre.next == curr) // means no duplicates found
					pre = pre.next;
				else
					pre.next = curr.next;
				curr = curr.next;
			}

			return origin.next;
		}// end of method
	}
}
