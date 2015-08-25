package leetcode;

/*
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Q083_RemoveDuplicatesFromSortedList {
	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode pre = head;
			head = head.next;
			while (head != null) {
				if (pre.val == head.val) {
					head = head.next;
					pre.next = head;
				} else {
					pre = pre.next;
					head = head.next;
				}
			}
			return orig.next;
		}
	}
}
