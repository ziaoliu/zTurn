package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 return its level order traversal as:
 *[
 *  [3],
 *  [20,9],
 *  [15,7]
 *]
 *
 *
 */
public class Q103_BinaryTreeZigZagLevelOrderTraversal {
	public class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null)
				return result;
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(root);
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			ArrayList<Integer> level = new ArrayList<Integer>();
			boolean reverse = false; // reverse level
			while (list.size() > 0) {
				TreeNode node = list.remove();
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
				if (!reverse)
					level.add(node.val);
				else
					level.add(0, node.val);
				if (list.size() == 0) {
					result.add(level);
					list = new LinkedList<TreeNode>(next);
					next = new LinkedList<TreeNode>();
					level = new ArrayList<Integer>();
					reverse = !reverse;
				}
			}
			return result;
		}
	}
}
