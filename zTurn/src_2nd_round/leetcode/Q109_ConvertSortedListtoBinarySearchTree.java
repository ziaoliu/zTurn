package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 http://articles.leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html
 http://blog.csdn.net/linhuanmars/article/details/23904937
 */
public class Q109_ConvertSortedListtoBinarySearchTree {
	public class Solution {
		public TreeNode sortedListToBST(ListNode head) {
			if (head == null)
				return null;
			ListNode cur = head;
			int count = 0;
			List<ListNode> list = new ArrayList<>();
			list.add(head);
			while (cur != null) {
				cur = cur.next;
				count++;
			}
			return recur(list, 0, count - 1);
		}

		private TreeNode recur(List<ListNode> list, int start, int end) {
			if (start > end)
				return null;
			int mid = (start + end) / 2;
			TreeNode left = recur(list, start, mid - 1);
			TreeNode root = new TreeNode(list.get(0).val);
			root.left = left;
			list.add(0, list.get(0).next); // add the node after mid element
			TreeNode right = recur(list, mid + 1, end);
			root.right = right;
			return root;
		}
	}
}
