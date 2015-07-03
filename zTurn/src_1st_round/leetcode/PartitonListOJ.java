package leetcode;

/* Partition List 
 * Given a linked list and a value x, partition it such that all nodes 
 * less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * https://leetcode.com/discuss/24649/is-the-example-wrong-am-i-missing-something
 */
public class PartitonListOJ {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	public class Solution {
		public ListNode partition(ListNode head, int x) {
			if (null == head)
				return null;
			ListNode origin = new ListNode(-1);
			origin.next = head;

			ListNode less = origin;
			ListNode pre = less;
			ListNode curr = head;

			while (null != curr) {
				if (curr.val < x) {
					if (less.next != curr) {
						pre.next = curr.next;
						curr.next = less.next;
						less.next = curr;
					}
					less = less.next;
				}
				pre = curr;
				curr = curr.next;
			}
			return origin.next;
		}// end of method
	}
}
