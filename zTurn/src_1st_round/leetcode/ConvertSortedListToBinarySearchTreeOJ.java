package leetcode;

import java.util.ArrayList;

/* Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * https://en.wikipedia.org/wiki/Binary_search_tree
 * http://blog.csdn.net/linhuanmars/article/details/23904937
 * http://articles.leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html
 */
public class ConvertSortedListToBinarySearchTreeOJ {
	public class Solution {
		public TreeNode sortedListToBST(ListNode head) {
			if (head == null)
				return null;
			ArrayList<ListNode> list = new ArrayList<ListNode>();
			list.add(head);
			ListNode curr = head;
			int count = 0;
			while (curr != null) {
				curr = curr.next;
				count++;
			}
			return inorder(list, 0, count - 1);
		}

		public TreeNode inorder(ArrayList<ListNode> list, int i, int j) {
			if (i > j)
				return null;
			int m = (i + j) / 2;
			TreeNode left = inorder(list, i, m - 1);
			TreeNode root = new TreeNode(list.get(0).val);
			root.left = left;
			list.set(0, list.get(0).next);
			root.right = inorder(list, m + 1, j);
			return root;
		}
	}
}
