package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 return its level order traversal as:
 *[
 *  [15,7],
 *  [9,20],
 *  [3]
 *]
 *
 *http://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-java/
 */
public class Q107_BinaryTreeLevelOrderTraversal {
	public class Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			List<Integer> values = new ArrayList<Integer>();
			if (root == null)
				return result;
			list.add(root);

			while (list.size() > 0) {
				TreeNode node = list.remove();
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
				values.add(node.val);
				if (list.size() == 0) {
					result.add(0, values);
					list = new LinkedList<TreeNode>(next);
					next = new LinkedList<TreeNode>();
					values = new ArrayList<Integer>();
				}
			}

			return result;
		}
	}
}
