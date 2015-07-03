package leetcode;

/* Same Tree
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/22839819
 */

public class SameTreeOJ {
	public class Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
			if (p == null && q == null)
				return true;
			if (p == null || q == null)
				return false;

			if (q.val != p.val)
				return false;

			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
}
