package leetcode;

/*
 Merge two sorted linked lists and return it as a new list. 
 The new list should be made by splicing together the nodes of the first two lists.
 */
public class Q021_MergeTwoSortedLists {
	public class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null)
				return l1;
			if (null == l1 || null == l2)
				return null == l1 ? l2 : l1;

			ListNode dummy = new ListNode(-1);
			ListNode head = dummy;

			while (l1 != null || l2 != null) {
				int one = Integer.MAX_VALUE;
				int two = Integer.MAX_VALUE;

				if (l1 != null)
					one = l1.val;
				if (l2 != null)
					two = l2.val;

				int temp = 0;
				if (one > two) {
					temp = two;
					l2 = l2.next;
				} else {
					temp = one;
					l1 = l1.next;
				}

				dummy.next = new ListNode(temp);
				dummy = dummy.next;
			}

			return head.next;
		}
	}
}
