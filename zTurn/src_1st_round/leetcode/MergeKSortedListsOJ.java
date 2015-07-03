package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.Merge2SortedListsOJ.Solution.ListNode;

/* Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 *http://www.lifeincode.net/programming/leetcode-merge-k-sorted-lists-java/   <--
 *http://www.cnblogs.com/TenosDoIt/p/3673188.html
 */

public class MergeKSortedListsOJ {
	public static void main(String[] args) {
		MergeKSortedListsOJ solution = new MergeKSortedListsOJ();
		Solution testCase = solution.new Solution();
		System.out.println(testCase.mergeKLists(null));
	}

	public class Solution {
		public class ListNode {
			int val;
			ListNode next;

			ListNode(int x) {
				val = x;
				next = null;
			}
		}

		public ListNode mergeKLists(ArrayList<ListNode> lists) {
			if (null == lists || lists.size() <= 0)
				return null;

			if (lists.size() == 1)
				return lists.get(0);

			return merge(0, lists.size() - 1, lists);

		}

		private ListNode merge(int i, int j, ArrayList<ListNode> lists) {
			if (i < j)
				return merge2lists(merge(i, (i + j) / 2, lists),
						merge((i + j) / 2 + 1, j, lists));

			return lists.get(i);

		}

		private ListNode merge2lists(ListNode l1, ListNode l2) {
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
	}
}
