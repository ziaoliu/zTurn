package leetcode;

/*
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric:

 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 */
public class Q101_SymmetricTree {
	public class Solution {
		public boolean isSymmetric(TreeNode root) {
			if (root == null)
				return true;
			return dfs(root.left, root.right);
		}

		private boolean dfs(TreeNode left, TreeNode right) {
			if (left == null && right == null)
				return true;
			if (left == null || right == null)
				return false;
			if (left.val != right.val)
				return false;
			return dfs(left.left, right.right) && dfs(left.right, right.left);
		}
	}
}
