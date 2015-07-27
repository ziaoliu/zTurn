package leetcode;

import java.util.ArrayList;

/*
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 http://blog.csdn.net/linhuanmars/article/details/19899259
 */
public class Q023_MergeKSortedLists {
	public class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length == 0)
				return null;

			return merge(lists, 0, lists.length - 1);
		}

		private ListNode merge(ListNode[] lists, int i, int j) {
			if (i < j) {
				int m = (i + j) / 2;
				return mergeTwoLists(merge(lists, i, m), merge(lists, m + 1, j));
			}
			return lists[i];
		}

		private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null)
				return null;
			if (l1 == null || l2 == null)
				return l1 == null ? l2 : l1;

			ListNode head = new ListNode(-1);
			ListNode dummy = head;

			while (l1 != null || l2 != null) {
				int one = Integer.MAX_VALUE;
				int two = Integer.MAX_VALUE;
				int less = 0;

				if (l1 != null)
					one = l1.val;
				if (l2 != null)
					two = l2.val;

				if (one < two) {
					less = one;
					l1 = l1.next;
				} else {
					less = two;
					l2 = l2.next;
				}

				dummy.next = new ListNode(less);
				dummy = dummy.next;

			}
			return head.next;
		}
	}
}
