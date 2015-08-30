package leetcode;

/*
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ¡Ü m ¡Ü n ¡Ü length of list.
 */
public class Q092_ReverseLinkedListII {
	public class Solution {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode pre = orig;
			ListNode start = pre;
			for (int i = 1; head != null; i++) {
				if (i == m)
					start = pre;
				if (i > m && i <= n) {
					pre.next = head.next;
					head.next = start.next;
					start.next = head;

					if (i == n)
						break;
					head = pre.next;

				} else {
					pre = pre.next;
					head = head.next;
				}
			}
			return orig.next;
		}
	}

	public class SolutionWrong {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode list = null;
			ListNode listEnd = null;
			int i = 1;
			while (head != null) {
				if (i <= n && i >= m) {
					if (i == m) {
						list = new ListNode(-1);
						list.next = head;
						listEnd = head;
					} else {
						ListNode tmp = head.next;
						head.next = list.next;
						list.next = head;
						head = tmp;
					}
				} else
					head = head.next;
				if (i == n)
					break;

				i++;
			}
			orig.next = list.next;
			listEnd.next = head;
			return orig.next;
		}
	}
}
