package leetcode;

/* Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * http://fisherlei.blogspot.com/2013/01/leetcode-rotate-list.html
 */

public class RotateListOJ {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	public class Solution {
		public ListNode rotateRight(ListNode head, int k) {
			int n = 1;

			if(head == null || k == 0)
				return head;
			
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode dup = orig.next;

			// total elements
			while (dup.next != null) {
				dup = dup.next;
				n++;
			}

			if (n == 1 || n == k)
				return head;

			dup.next = orig.next;

			int more = n - k % n;

			for (int i = 0; i < more; i++) {
				dup = dup.next;
			}

			orig.next = dup.next;
			dup.next = null;

			return orig.next;
		}
	}
}
