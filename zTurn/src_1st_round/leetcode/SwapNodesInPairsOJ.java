package leetcode;

/* Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * 
 * http://www.cnblogs.com/springfor/p/3862030.html
 */

public class SwapNodesInPairsOJ {
	public class Solution {
		public class ListNode {
			int val;
			ListNode next;

			ListNode(int x) {
				val = x;
				next = null;
			}
		}

		public ListNode swapPairs(ListNode head) {
			if (null == head)
				return null;

			ListNode original = null;
			ListNode temp = head.next;
			ListNode preNode = null;

			if (null == temp)
				return head;

			while (null != head && null != temp) {
				if (null == original)
					original = temp;
				head.next = temp.next;
				temp.next = head;

				if (null != preNode)
					preNode.next = temp;
				preNode = head;

				head = head.next;

				if (null != head)
					temp = head.next;
				else
					break;
			}

			return original;
		}
	}
}
