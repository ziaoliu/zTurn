package leetcode;

/*
 Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
 reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.

 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

 http://fisherlei.blogspot.com/2013/11/leetcode-reorder-list-solution.html
 http://codeganker.blogspot.com/2014/03/reorder-list-leetcode.html
 */
public class Q143_ReorderList {
	public class Solution {
		// 1. find the middle point to get the second half
		// 2. reverse second half
		// 3. merge two parts
		public void reorderList(ListNode head) {
			if (head == null || head.next == null)
				return;
			// step 1: find second half
			ListNode slow = head;
			ListNode fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				if (fast.next != null)
					fast = fast.next.next;
				else
					fast = null;
			}
			if (slow == null)
				return;
			// step 2: reverse second half
			ListNode pre = null;
			ListNode cur = slow.next;// starting point of the second list
			slow.next = null;
			while (cur != null) {
				ListNode next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			// step 3: merge two lists
			/**
			 * ListNode pre = head; while (head != slow) { pre.next = head;
			 * head.next = mid.next; head = head.next; mid = mid.next; } if (mid
			 * != null) pre.next = mid;
			 */
			ListNode p1 = head;
			ListNode p2 = pre;
			while (p2 != null) {
				ListNode tmp1 = p1.next;
				ListNode tmp2 = p2.next;
				p1.next = p2;
				p2.next = tmp1;
				p1 = tmp1;
				p2 = tmp2;
			}
		}
	}
}
