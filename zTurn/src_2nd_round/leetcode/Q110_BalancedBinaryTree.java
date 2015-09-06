package leetcode;

import java.util.LinkedList;

/*
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree 
 in which the depth of the two subtrees of every node never differ by more than 1.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 http://blog.csdn.net/linhuanmars/article/details/23731355
 */
public class Q110_BalancedBinaryTree {
	public class Solution {
		public boolean isBalanced(TreeNode root) {
			return depth(root) >= 0;
		}

		private int depth(TreeNode root) {
			if (root == null)
				return 0;
			int left = depth(root.left);
			int right = depth(root.right);

			if (left < 0 || right < 0)
				return -1;

			if (Math.abs(left - right) > 1)
				return -1;

			return Math.max(left, right) + 1;
		}
	}

	public class SolutionStupid {
		public boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
			return subTree(root);
		}

		private boolean subTree(TreeNode root) {
			if (root == null)
				return true;
			int leftDepth = depth(root.left);
			int rightDepth = depth(root.right);
			int diff = Math.abs(leftDepth - rightDepth);
			if (diff > 1)
				return false;
			return subTree(root.left) && subTree(root.right);
		}

		private int depth(TreeNode root) {
			if (root == null)
				return 0;
			int depth = 0;
			LinkedList<TreeNode> list = new LinkedList<>();
			LinkedList<TreeNode> next = new LinkedList<>();
			list.add(root);
			while (list.size() > 0) {
				TreeNode node = list.remove();
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
				if (list.size() == 0) {
					list = next;
					next = new LinkedList<>();
					depth++;
				}
			}
			return depth;
		}
	}
}
