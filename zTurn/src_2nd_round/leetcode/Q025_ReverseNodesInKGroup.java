package leetcode;

/*
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 http://blog.csdn.net/linhuanmars/article/details/19957455
 http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html

 */
public class Q025_ReverseNodesInKGroup {
	public static void main(String[] args) {
		Q025_ReverseNodesInKGroup test = new Q025_ReverseNodesInKGroup();
		Solution t = test.new Solution();

		ListNode one = new ListNode(1);
		one.next = new ListNode(2);
		// one.next.next = new ListNode(3);
		t.reverseKGroup(one, 2);
	}

	public class Solution {
		public ListNode reverseKGroup(ListNode head, int k) {
			if (head == null || k < 2)
				return head;

			ListNode original = new ListNode(-1);
			original.next = head;

			ListNode pre = original;
			ListNode start = head;
			ListNode end = head;

			while (start != null) {
				int i = 0;
				ListNode temp = start;
				// check group length
				for (; i < k - 1 && temp != null; i++)
					temp = temp.next;

				if (temp == null || i != k - 1)
					break;

				// reverse by inserting nodes in the beginning
				ListNode newStart = temp.next;

				end = start;
				temp = start.next;
				start.next = null;
				for (i = 1; i <= k - 1; i++) {
					ListNode dup = temp.next;
					temp.next = start;
					pre.next = temp;
					start = pre.next;
					temp = dup;
				}
				end.next = newStart;

				pre = end;
				if (pre == null)
					break;
				start = pre.next;
			}

			return original.next;
		}
	}
}
