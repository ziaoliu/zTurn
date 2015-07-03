package leetcode;

/* Reverse Nodes in k-Group
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * http://codeganker.blogspot.com/2014/02/reverse-nodes-in-k-group-leetcode.html
 * http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html
 */

//class ListNode {
//	int val;
//	ListNode next;
//	
//	ListNode(int x) {
//		val = x;
//		next = null;
//	}
//}
public class ReverseNodesInKGroupOJ {
	public static void main(String[] args) {
		ReverseNodesInKGroupOJ solution = new ReverseNodesInKGroupOJ();
		Solution test = solution.new Solution();

		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);

		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		ListNode tt = test.reverseKGroup(head, 2);
		while (tt != null) {
			System.out.print(tt.val + " -> ");
			tt = tt.next;
		}
	}

	public class Solution {

		public ListNode reverseKGroup(ListNode head, int k) {
			if (null == head)
				return null;
			if (null == head.next)
				return head;
			if (k <= 1)
				return head;

			int counter = 1;
			ListNode original = new ListNode(0);
			ListNode count = head;

			while (count.next != null) {
				counter++;
				count = count.next;
			}
			
			if(k > counter)
				return head;

			ListNode pre = null;

			int iterations = counter / k;
			ListNode end = null;
			ListNode preEnd = null;
			for (int i = 0; i < iterations; i++) {
				preEnd = end;
				end = head;
				for (int j = 0; j < k; j++) {
					ListNode temp = head.next;
					head.next = pre;
					pre = head;
					head = temp;
				}
				if (original.next == null)
					original.next = pre;
				else
					preEnd.next = pre;
			}
			if (end != null)
				end.next = head;
			else
				end = head;

			return original.next;
		}
	}
}
