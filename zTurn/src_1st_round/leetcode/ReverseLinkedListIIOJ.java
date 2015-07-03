package leetcode;

/* Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ¡Ü m ¡Ü n ¡Ü length of list.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24613781
 * http://blog.sina.com.cn/s/blog_eb52001d0102v241.html
 */
public class ReverseLinkedListIIOJ {
	public class Solution {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			if (m >= n || head == null)
				return null;

			ListNode origin = new ListNode(-1);
			origin.next = head;

			int i = 1;
			ListNode pre = origin;
			while (pre != null && i < m) {
				i++;
				pre = pre.next;
			}

			ListNode mNode = pre.next;
			ListNode cNode = mNode.next;

			while (cNode != null && i < n) {
				i++;
				ListNode temp = cNode.next;
				cNode.next = pre.next; // pre.next always points to the first
										// node in the reverse list
				mNode.next = temp;
				pre.next = cNode;

				cNode = temp;
			}

			return origin.next;
		}
	}
}
