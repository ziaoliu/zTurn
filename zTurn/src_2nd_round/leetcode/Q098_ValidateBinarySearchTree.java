package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 http://www.cnblogs.com/yuzhangcmu/p/4177047.html
 http://fisherlei.blogspot.com/2013/01/leetcode-validate-binary-search-tree.html
 */
public class Q098_ValidateBinarySearchTree {
	public class Solution {
		public boolean isValidBST(TreeNode root) {
			if (root == null)
				return true;
			TreeNode pre = null;
			LinkedList<TreeNode> stack = new LinkedList<>();
			while (root != null || stack.size() > 0) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					if (pre != null && root.val <= pre.val)
						return false;
					pre = root;
					root = root.right;
				}
			}
			return true;
		}
	}

	public class SolutionComplicated {
		public boolean isValidBST(TreeNode root) {
			if (root == null)
				return true;
			return isValid(root);
		}

		private boolean isValid(TreeNode root) {
			if (root == null)
				return true;

			boolean left = isValid(root.left)
					&& leftValueCheck(root.val, root.left);
			boolean right = isValid(root.right)
					&& rightValueCheck(root.val, root.right);

			if (root.left != null && root.left.val >= root.val || !left)
				return false;
			if (root.right != null && root.right.val <= root.val || !right)
				return false;

			return true;
		}

		private boolean leftValueCheck(int val, TreeNode left) {
			if (left == null)
				return true;
			if (left.val >= val)
				return false;
			return leftValueCheck(val, left.left)
					&& leftValueCheck(val, left.right);
		}

		private boolean rightValueCheck(int val, TreeNode right) {
			if (right == null)
				return true;
			if (right.val <= val)
				return false;
			return rightValueCheck(val, right.left)
					&& rightValueCheck(val, right.right);
		}
	}
}
