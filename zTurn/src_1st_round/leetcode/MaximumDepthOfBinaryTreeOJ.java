package leetcode;

import java.util.ArrayList;

/* Maximum Depth of Binary Tree 
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/19659525
 */
public class MaximumDepthOfBinaryTreeOJ {
	public class SolutionRecursive {

		public int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}// end of method

	}

	public class SolutionIterative {

		public int maxDepth(TreeNode root) {
			if (root == null)
				return 0;
			int level = 1;
			int preCount = 1;
			int currCount = 0;
			ArrayList<TreeNode> list = new ArrayList<>();
			list.add(root);
			while (!list.isEmpty()) {
				TreeNode node = list.remove(0);
				preCount--;

				if (node.left != null) {
					list.add(node.left);
					currCount++;
				}
				if (node.right != null) {
					list.add(node.right);
					currCount++;
				}
				if (preCount == 0) {
					preCount = currCount;
					currCount = 0;
					level++;
				}

			}

			return level;
		}// end of method

	}
}
