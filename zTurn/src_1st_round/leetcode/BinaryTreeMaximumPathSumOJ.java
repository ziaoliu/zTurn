package leetcode;

/*
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * Return 6.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/22969069
 * https://leetcodenotes.wordpress.com/2013/11/04/leetcode-binary-tree-maximum-path-sum-%E6%A0%91%E4%B8%AD%E4%BB%BB%E6%84%8F%E4%B8%A4%E7%82%B9%E9%97%B4%E6%9C%80%E5%A4%A7path-sum/
 * http://blog.csdn.net/fightforyourdream/article/details/16894069
 */
public class BinaryTreeMaximumPathSumOJ {
	public class Solution {
		public int maxPathSum(TreeNode root) {
			if (root == null)
				return 0;

			int[] max = new int[1];
			max[0] = Integer.MIN_VALUE;
			recur(root, max);
			return max[0];
		}

		public int recur(TreeNode root, int[] max) {
			if (root == null)
				return 0;

			int left = recur(root.left, max);
			int right = recur(root.right, max);
			int sum = root.val + (left > 0 ? left : 0)
					+ (right > 0 ? right : 0);
			if (sum > max[0])
				max[0] = sum;
			return Math.max(left, Math.max(right, 0)) + root.val;
		}
	}
}
