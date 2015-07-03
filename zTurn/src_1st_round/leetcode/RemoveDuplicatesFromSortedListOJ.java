package leetcode;

/* Remove Duplicates from Sorted List 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24354291
 * http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedListOJ {
	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			if (null == head)
				return null;
			ListNode origin = new ListNode(-1);
			origin.next = head;

			ListNode pre = origin;
			ListNode curr = head;

			while (null != curr) {
				while (null != curr.next && curr.next.val == pre.next.val) {
					curr = curr.next;
				}
				pre.next = curr;
				curr = curr.next;
				pre = pre.next;
			}

			return origin.next;
		}
	}
}
