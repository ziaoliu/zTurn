package leetcode;

/* Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * https://en.wikipedia.org/wiki/Tree_traversal
 * http://blog.csdn.net/linhuanmars/article/details/24390157
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversalOJ {
	public class Solution {
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			if (inorder == null || postorder == null || inorder.length == 0
					|| postorder.length == 0)
				return null;
			return recur(inorder, 0, inorder.length - 1, postorder, 0,
					inorder.length - 1);
		}

		public TreeNode recur(int[] inorder, int i, int j, int[] postorder,
				int m, int n) {
			if (j < 0 || n < 0)
				return null;
			if (i > j || m > n)
				return null;

			TreeNode root = new TreeNode(postorder[n]);
			int rootIndex = 0;
			for (int index = 0; index < postorder.length; index++) {
				if (root.val == inorder[index]) {
					rootIndex = index;
					break;
				}
			}

			root.left = recur(inorder, i, rootIndex - 1, postorder, m, m
					+ rootIndex - i - 1);
			root.right = recur(inorder, rootIndex + 1, j, postorder, m
					+ rootIndex - i, n - 1);
//			root.right = recur(inorder, rootIndex + 1, j, postorder, n
//					- (j - rootIndex), n - 1);
			return root;
		}
	}
}
