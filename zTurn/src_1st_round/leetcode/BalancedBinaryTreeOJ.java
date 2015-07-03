package leetcode;

/* Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/23731355
 */
public class BalancedBinaryTreeOJ {
	public class Solution {
		public boolean isBalanced(TreeNode root) {
			if (root == null)
				return true;
			return subtreeDepth(root) >= 0;
		}

		public int subtreeDepth(TreeNode root) {
			if (root == null)
				return 0;

			int left = subtreeDepth(root.left);
			int right = subtreeDepth(root.right);

			if (left < 0 || right < 0)
				return -1;
			if (Math.abs(left - right) >= 2)
				return -1;

			return Math.max(left, right) + 1;
		}
	}
}
