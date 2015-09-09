package leetcode;

import java.util.LinkedList;

/*
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 *    1
 *   / \
 *  2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }



 */
public class Q129_SumRootToLeafNumbers {
	public class Solution {
		int sum = 0;

		public int sumNumbers(TreeNode root) {
			if (root == null)
				return sum;
			dfs(root, root.val);

			return sum;
		}

		private void dfs(TreeNode root, int sum) {
			if (root == null)
				return;
			if (root.left == null && root.right == null)
				this.sum += sum;
			if (root.left != null)
				dfs(root.left, sum * 10 + root.left.val);
			if (root.right != null)
				dfs(root.right, sum * 10 + root.right.val);
		}

		public int sumNumbersBFSNotWorking(TreeNode root) {
			if (root == null)
				return 0;
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			int curCount = 1;
			int nextCount = 0;
			int sum = root.val;
			while (queue.size() > 0) {
				TreeNode node = queue.remove(0);
				curCount--;
				// sum = sum + node.val;
				int tmp = sum;
				if (node.left != null) {
					sum = node.val + tmp * 10;
					queue.add(node.left);
					nextCount++;
				}
				if (node.right != null) {
					sum = node.val + tmp * 10;
					queue.add(node.right);
					nextCount++;
				}
				if (node.left == null && node.right == null)
					sum = sum + node.val;
				if (curCount == 0) {
					if (curCount == 0)
						sum = sum * 10;
					curCount = nextCount;
					nextCount = 0;
				}
			}
			return sum;
		}
	}
}
