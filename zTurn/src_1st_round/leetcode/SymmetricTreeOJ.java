package leetcode;

import java.util.ArrayList;

/* Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1 
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/23072829
 */
public class SymmetricTreeOJ {
	public class SolutionRecur {// recursive
		public boolean isSymmetric(TreeNode root) {
			if (root == null)
				return true;

			return recur(root.left, root.right);
		}

		public boolean recur(TreeNode left, TreeNode right) {
			if (left == null && right == null)
				return true;
			if (left == null || right == null)
				return false;
			if (left.val != right.val)
				return false;

			return recur(left.left, right.right)
					&& recur(left.right, right.left);
		}
	}

	public class SolutionIter {// iteratively
		public boolean isSymmetric(TreeNode root) {
			if (root == null)
				return true;
			if (root.left == null && root.right == null)
				return true;
			if (root.left == null || root.right == null)
				return false;
			if (root.left.val != root.right.val)
				return false;

			ArrayList<TreeNode> p = new ArrayList<>();
			ArrayList<TreeNode> q = new ArrayList<>();

			p.add(root.left);
			q.add(root.right);

			while (!p.isEmpty() && !q.isEmpty()) {
				TreeNode left = p.remove(0);
				TreeNode right = q.remove(0);

				if (left.val != right.val)
					return false;
				if (left.left != null && right.right == null
						|| left.left == null && right.right != null)
					return false;
				if (left.right != null && right.left == null
						|| left.right == null && right.left != null)
					return false;

				if (left.left != null && right.right != null) {
					p.add(left.left);
					q.add(right.right);
				}
				if (left.right != null && right.left != null) {
					p.add(left.right);
					q.add(right.left);
				}

			}

			return true;
		}// end of method
	}
}
