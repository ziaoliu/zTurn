package leetcode;

/* Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/19660209
 */
public class MinimumDepthOfBinaryTreeOJ {
	public class Solution {
		public int minDepth(TreeNode root) {
			if (root == null)
				return 0;

			int left = minDepth(root.left);
			int right = minDepth(root.right);

			if(left==0 && right==0)
				return 1;
			
			int min = Math.min(left, right);
			if(min == 0)
				min = Math.max(left, right);
			return  min + 1;

		}
	}
}
