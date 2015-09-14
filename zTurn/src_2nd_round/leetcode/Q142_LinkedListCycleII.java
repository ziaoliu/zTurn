package leetcode;

/*
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?

 http://fisherlei.blogspot.com/2013/11/leetcode-linked-list-cycle-ii-solution.html
 http://blog.csdn.net/linhuanmars/article/details/21260943
 */
public class Q142_LinkedListCycleII {
	public class Solution {
		public ListNode detectCycle(ListNode head) {
			if (head == null)
				return head;
			// start from the head of the list
			ListNode slow = head;
			ListNode fast = head;
			while (fast != null && slow != null) {
				slow = slow.next;
				if (fast.next != null)
					fast = fast.next.next;
				else
					fast = null;
				if (slow == fast)
					break;
			}
			if (fast == null)
				return fast;
			while (head != slow) {
				head = head.next;
				slow = slow.next;
			}
			return head;
		}
	}
}
