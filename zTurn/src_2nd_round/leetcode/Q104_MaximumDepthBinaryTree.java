package leetcode;

import java.util.LinkedList;

/*
 Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 http://blog.csdn.net/linhuanmars/article/details/19659525
 */
public class Q104_MaximumDepthBinaryTree {
	public class SolutionRecur {
		public int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
	}

	public class Solution {
		public int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			int max = 0;
			int tmp = 0;
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			list.add(root);
			while (list.size() > 0) {
				TreeNode node = list.remove();
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
				if (list.size() == 0) {
					tmp++;
					if (tmp > max)
						max = tmp;
					list = new LinkedList<TreeNode>(next);
					next = new LinkedList<TreeNode>();
				}
			}
			return max;
		}
	}
}
