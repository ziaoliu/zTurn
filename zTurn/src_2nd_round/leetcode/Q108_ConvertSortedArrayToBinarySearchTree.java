package leetcode;

/*
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q108_ConvertSortedArrayToBinarySearchTree {
	public class Solution {
		public TreeNode sortedArrayToBST(int[] nums) {
			if (nums == null)
				return null;
			return subTree(nums, 0, nums.length - 1);
		}

		private TreeNode subTree(int[] nums, int l, int r) {
			if (l > r)
				return null;
			int x = (l + r) / 2;
			TreeNode root = new TreeNode(nums[x]);
			root.left = subTree(nums, l, x - 1);
			root.right = subTree(nums, x + 1, r);
			return root;
		}
	}
}
