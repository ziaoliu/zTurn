package leetcode;

/*
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.

 http://fisherlei.blogspot.com/2013/01/leetcode-rotate-list.html
 http://blog.csdn.net/linhuanmars/article/details/21903027
 */
public class Q061_RotateList {
	public class SolutionDiff {
		public ListNode rotateRight(ListNode head, int k) {
			if (head == null || k == 0)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode tmp = head;

			int count = 1;

			while (tmp.next != null) {
				tmp = tmp.next;
				count++;
			}
			if (k == count || k % count == 0)
				return head;

			int more = count - k % count;
			tmp.next = head;

			while (more > 0) {
				more--;
				tmp = tmp.next;
			}
			orig.next = tmp.next;
			tmp.next = null;
			return orig.next;
		}
	}

	public class Solution {
		public ListNode rotateRight(ListNode head, int k) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;

			ListNode tmp = orig.next;
			int count = 0;
			while (tmp != null) {
				tmp = tmp.next;
				count++;
			}
			if (k == count || k % count == 0)
				return head;
			else
				k = k % count;

			ListNode slow = orig.next;
			ListNode fast = orig.next;
			for (int i = 0; i < k && fast != null; i++) {
				fast = fast.next;
			}
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = orig.next;
			orig.next = slow.next;
			slow.next = null;
			return orig.next;
		}
	}
}
