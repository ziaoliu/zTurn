package leetcode;

/*
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24389429
 */
public class Q082_RemoveDuplicatesFromSortedListII {

	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode pre = orig;
			ListNode curr = head;
			while (curr != null) {
				while (curr.next != null && curr.val == curr.next.val)
					curr = curr.next;
				if (pre.next == curr)// no duplicates found
					pre = pre.next;
				else {
					pre.next = curr.next;
					// pre = pre.next;
				}
				curr = curr.next;
			}
			return orig.next;
		}
	}

	public class SolutionMyAC {
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;

			ListNode pre = orig;
			ListNode curr = head;
			while (curr != null && curr.next != null) {
				if (curr.val != curr.next.val) {
					pre = pre.next;
					curr = curr.next;
				} else {
					while (curr.val == curr.next.val) {
						curr = curr.next;
						if (curr == null || curr.next == null)
							break;
					}
					pre.next = curr.next == null ? null : curr.next;
					if (curr != null)
						curr = curr.next;
				}
			}

			return orig.next;
		}
	}
}
