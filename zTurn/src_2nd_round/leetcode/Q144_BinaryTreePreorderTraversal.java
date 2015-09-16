package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3


 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?

 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }


 */
public class Q144_BinaryTreePreorderTraversal {
	// pre order traversal
	// breadth first traversal
	public class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			if (root == null)
				return result;
			LinkedList<TreeNode> stack = new LinkedList<>();
			stack.push(root);
			while (stack.size() > 0) {
				TreeNode node = stack.pop();
				result.add(node.val);
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
			return result;
		}
	}
}
