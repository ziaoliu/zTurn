package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

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
 *  [9,20],
 *  [15,7]
 *]
 *
 *http://www.programcreek.com/2014/04/leetcode-binary-tree-level-order-traversal-java/
 */
public class Q102_BinaryTreeLevelOrderTraversal {
	public class SolutionOn {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null)
				return result;
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(root);
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			List<Integer> level = new ArrayList<Integer>();
			while (list.size() > 0) {
				TreeNode node = list.remove();
				if (node.left != null)
					next.add(node.left);
				if (node.right != null)
					next.add(node.right);
				level.add(node.val);
				if (list.size() == 0) {
					result.add(new ArrayList<Integer>(level));
					list = next;
					next = new LinkedList<TreeNode>();
					level = new ArrayList<Integer>();
				}
			}
			return result;
		}
	}

	public class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null)
				return result;
			List<TreeNode> list = new ArrayList<TreeNode>();
			list.add(root);
			while (list.size() > 0) {
				List<TreeNode> level = new ArrayList<TreeNode>(list);
				list = new ArrayList<TreeNode>();
				List<Integer> levelList = new ArrayList<Integer>();
				for (TreeNode node : level) {
					levelList.add(node.val);
					if (node.left != null)
						list.add(node.left);
					if (node.right != null)
						list.add(node.right);
				}
				if (levelList.size() > 0)
					result.add(levelList);

			}
			return result;
		}
	}
}
