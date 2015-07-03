package leetcode;

/* Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *	The left subtree of a node contains only nodes with keys less than the node's key.
 * 	The right subtree of a node contains only nodes with keys greater than the node's key.
 * 	Both the left and right subtrees must also be binary search trees.
 * 
 * http://blog.csdn.net/likecool21/article/details/23271621
 * http://fisherlei.blogspot.com/2013/01/leetcode-validate-binary-search-tree.html
 * http://blog.csdn.net/linhuanmars/article/details/23810735
 */
public class ValidateBinarySearchTreeOJ {
	public static int previous = Integer.MIN_VALUE;

	// in order traversal should yield sorted
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (!isValidBST(root.left))
			return false;

		if (root.val <= previous)
			return false;
		previous = root.val;

		if (isValidBST(root.right))
			return false;

		return true;
	}

	public class Solution {
		public boolean isValidBST(TreeNode root) {
			if (root == null) {
				return true;
			}
			return isSubTreeLessThan(root.left, root.val)
					&& isSubTreeGreaterThan(root.right, root.val)
					&& isValidBST(root.left) && isValidBST(root.right);
		}

		public boolean isSubTreeLessThan(TreeNode node, int val) {
			if (node == null) {
				return true;
			}
			return node.val < val && isSubTreeLessThan(node.left, val)
					&& isSubTreeLessThan(node.right, val);
		}

		public boolean isSubTreeGreaterThan(TreeNode node, int val) {
			if (node == null) {
				return true;
			}
			return node.val > val && isSubTreeGreaterThan(node.left, val)
					&& isSubTreeGreaterThan(node.right, val);
		}
	}
}
