package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,

 *              5
 *             / \
 *            4   8
 *           /   / \
 *          11  13  4
 *         /  \    / \
 *        7    2  5   1

 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

 http://blog.csdn.net/linhuanmars/article/details/23655413
 */
public class Q113_PathSumII {
	public class Solution {
		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			List<List<Integer>> result = new ArrayList<>();
			if (root == null)
				return result;
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			find(result, list, root, sum - root.val);
			return result;
		}

		private void find(List<List<Integer>> result, List<Integer> list,
				TreeNode root, int sum) {
			if (root == null)
				return;
			if (root.left == null && root.right == null && sum == 0) {
				result.add(new ArrayList<>(list));
				return;
			}
			if (root.left != null) {
				list.add(root.left.val);
				find(result, list, root.left, sum - root.left.val);
				list.remove(list.size() - 1);
			}
			if (root.right != null) {
				list.add(root.right.val);
				find(result, list, root.right, sum - root.right.val);
				list.remove(list.size() - 1);
			}
		}
	}

	public class SolutionMineLessFast {
		public List<List<Integer>> pathSum(TreeNode root, int sum) {
			List<List<Integer>> result = new ArrayList<>();
			if (root == null)
				return result;
			List<Integer> list = new ArrayList<>();
			find(result, list, root, sum);
			return result;
		}

		private void find(List<List<Integer>> result, List<Integer> list,
				TreeNode root, int sum) {
			if (root == null)
				return;
			if (root.left == null && root.right == null && sum == root.val) {
				list.add(root.val);
				result.add(new ArrayList<>(list));
				list.remove(list.size() - 1);
				return;
			}
			if (root.left != null) {
				list.add(root.val);
				find(result, list, root.left, sum - root.val);
				list.remove(list.size() - 1);
			}
			if (root.right != null) {
				list.add(root.val);
				find(result, list, root.right, sum - root.val);
				list.remove(list.size() - 1);
			}
		}
	}
}
