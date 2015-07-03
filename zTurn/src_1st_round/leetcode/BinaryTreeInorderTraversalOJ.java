package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/* Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 
 * http://blog.csdn.net/linhuanmars/article/details/20187257
 */
public class BinaryTreeInorderTraversalOJ {
	public class SolutionIterative {
		public ArrayList<Integer> inorderTraversal(TreeNode root) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			ArrayList<Integer> result = new ArrayList<Integer>();
			if (root == null)
				return result;

			while (root != null || stack.size() > 0) {
				if(root != null){
					stack.push(root);
					root = root.left;
				}else{
					root = stack.pop();
					result.add(root.val);
					root = root.right;
				}
			}

			return result;
		}
	}

	public class SolutionRecursive {
		public ArrayList<Integer> inorderTraversal(TreeNode root) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			if (root == null)
				return result;

			inorder(root, result);

			return result;
		}

		public void inorder(TreeNode root, ArrayList<Integer> result) {
			if (root == null)
				return;

			if (root.left != null)
				inorder(root.left, result);

			result.add(root.val);

			if (root.right != null)
				inorder(root.right, result);
		}
	}
}
