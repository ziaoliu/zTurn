package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3
 return [1,3,2].

 Note: Recursive solution is trivial, could you do it iteratively?

 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q094_BinaryTreeInorderTraversal {

	public class SolutionIterate {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> list = new ArrayList<Integer>();
			if (root == null)
				return list;

			LinkedList<TreeNode> stack = new LinkedList<>();
			while (root != null || stack.size() > 0) {
				if (root != null) {
					stack.push(root);
					root = root.left;
				} else {
					root = stack.pop();
					list.add(root.val);
					root = root.right;
				}
			}

			return list;
		}
	}

	public class SolutionRecurr {
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> list = new ArrayList<Integer>();
			if (root == null)
				return list;

			inorder(list, root);

			return list;
		}

		private void inorder(List<Integer> list, TreeNode root) {
			if (root == null)
				return;
			if (root.left != null) {
				inorder(list, root.left);
			}

			list.add(root.val);

			if (root.right != null) {
				inorder(list, root.right);
			}
		}
	}
}
