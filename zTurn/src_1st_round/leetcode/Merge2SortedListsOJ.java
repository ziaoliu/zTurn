package leetcode;

import leetcode.RemoveNthNodeFromEndofList.ListNode;

/*
 Merge two sorted linked lists and return it as a new list. 
 The new list should be made by splicing together the nodes of the first two lists. 
 
 http://www.lifeincode.net/programming/leetcode-merge-k-sorted-lists-java/
 */

public class Merge2SortedListsOJ {

	public class Solution {
		public class ListNode {
			int val;
			ListNode next;

			ListNode(int x) {
				val = x;
				next = null;
			}
		}

		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (null == l1 && null == l2)
				return null;
			if (null == l1 || null == l2)
				return null == l1 ? l2 : l1;

			ListNode head = null;

			ListNode temp = head;

			while (null != l1 || null != l2) {

				int list1 = Integer.MAX_VALUE;
				if (null != l1)
					list1 = l1.val;
				int list2 = Integer.MAX_VALUE;
				if (null != l2)
					list2 = l2.val;

				if (null == temp) {
					temp = list2 < list1 ? l2 : l1;
					head = temp;
					if (list2 < list1)
						l2 = l2.next;
					else
						l1 = l1.next;
					continue;
				}
				
				if (list2 < list1) {
					temp.next = l2;
					l2 = l2.next;
				} else {
					temp.next = l1;
					l1 = l1.next;
				}
				temp = temp.next;

			}

			return head;

		}
	} // end of solution
}
