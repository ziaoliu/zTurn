package leetcode;

/*
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?

 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }

 */
public class Q141_LinkedListCycle {
	public class Solution {
		public boolean hasCycle(ListNode head) {
			if (head == null)
				return false;
			ListNode slow = head;
			ListNode fast = head;
			while (fast != null) {
				slow = slow.next;
				if (fast.next != null)
					fast = fast.next.next;
				else
					return false;
				if (slow == fast)
					return true;
			}
			return false;
		}
	}
}
