package leetcode;

/*
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * http://fisherlei.blogspot.com/2013/03/leetcode-same-tree-solution.html
 * http://blog.csdn.net/linhuanmars/article/details/22839819
 */
public class Q100_SameTree {
	public class Solution {
		public boolean isSameTree(TreeNode p, TreeNode q) {
			if (p == null && q == null)
				return true;
			if (p == null || q == null)
				return false;
			if (p.val != q.val)
				return false;
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}
}
