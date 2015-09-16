package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3
 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Q145_BinaryTreePostorderTraversal {
	public class Solution {
		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			if (root == null)
				return result;
			Set<TreeNode> visited = new HashSet<>();
			LinkedList<TreeNode> stack = new LinkedList<>();
			stack.add(root);
			while (stack.size() > 0) {
				TreeNode node = stack.peek();
				if (visited.contains(node) || node.left == null
						&& node.right == null) {
					stack.pop();
					result.add(node.val);
					continue;
				}
				if (node.left != null || node.right != null) {
					visited.add(node);
				}
				if (node.right != null)
					stack.push(node.right);
				if (node.left != null)
					stack.push(node.left);
			}
			return result;
		}
	}
}
