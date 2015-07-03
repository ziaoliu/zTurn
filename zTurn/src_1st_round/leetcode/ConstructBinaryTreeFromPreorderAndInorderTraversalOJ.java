package leetcode;

/* Construct Binary Tree from Preorder and Inorder Traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * https://en.wikipedia.org/wiki/Tree_traversal
 * http://blog.csdn.net/linhuanmars/article/details/24389549
 * http://fisherlei.blogspot.com/2013/01/leetcode-construct-binary-tree-from.html
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversalOJ {
	public class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (preorder == null || inorder == null || preorder.length == 0
					|| inorder.length == 0)
				return null;
			return recur(preorder, 0, preorder.length - 1, inorder, 0,
					inorder.length - 1);
		}

		public TreeNode recur(int[] preorder, int i, int j, int[] inorder,
				int m, int n) {
			if (i > j || m > n)
				return null;

			int rootIndex = 0;

			TreeNode root = new TreeNode(preorder[i]);
			for (int index = 0; index < preorder.length; index++) {
				if (root.val == inorder[index]) {
					rootIndex = index;
					break;
				}
			}
			root.left = recur(preorder, i + 1, rootIndex - m + i, inorder, m,
					rootIndex - 1);
			root.right = recur(preorder, rootIndex - m + i + 1, j, inorder,
					rootIndex + 1, n);

			return root;
		}
	}

	public class SolutionOriginal {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (preorder == null || inorder == null || preorder.length == 0
					|| inorder.length == 0)
				return null;
			TreeNode root = new TreeNode(preorder[0]);
			int rootIndex = -1;
			int leftSubTreeStartPre = 0;
			int leftSubTreeEndPre = 0;
			int leftSubTreeStartIn = 0;
			int leftSubTreeEndIn = 0;
			int rightSubTreeStartPre = 0;
			int rightSubTreeEndPre = 0;
			int rightSubTreeStartIn = 0;
			int rightSubTreeEndIn = 0;

			for (int i = 0; i < preorder.length; i++) {
				if (inorder[i] == preorder[0]) {
					rootIndex = i;
					break;
				}
			}
			int length = rootIndex;

			leftSubTreeStartPre = 0;
			leftSubTreeEndPre = rootIndex - 1;
			leftSubTreeStartIn = 1;
			leftSubTreeEndIn = rootIndex;

			rightSubTreeStartPre = rootIndex + 1;
			rightSubTreeEndPre = preorder.length - 1;
			rightSubTreeStartIn = length + 1;
			rightSubTreeEndIn = preorder.length - 1;

			root.left = getRoot(inorder, leftSubTreeStartPre,
					leftSubTreeEndPre, preorder, leftSubTreeStartIn,
					leftSubTreeEndIn);
			root.right = getRoot(inorder, rightSubTreeStartPre,
					rightSubTreeEndPre, preorder, rightSubTreeStartIn,
					rightSubTreeEndIn);
			return root;
		}

		public TreeNode getRoot(int[] inorder, int i, int j, int[] preorder,
				int m, int n) {
			if (m > preorder.length - 1)
				return null;
			if (m > n || i > j)
				return null;
			TreeNode root = new TreeNode(preorder[m]);
			if (m == n)
				return root;

			int rootIndex = -1;
			int leftSubTreeStartPre = 0;
			int leftSubTreeEndPre = 0;
			int leftSubTreeStartIn = 0;
			int leftSubTreeEndIn = 0;
			int rightSubTreeStartPre = 0;
			int rightSubTreeEndPre = 0;
			int rightSubTreeStartIn = 0;
			int rightSubTreeEndIn = 0;

			for (int index = 0; index < preorder.length; index++) {
				if (inorder[index] == preorder[m]) {
					rootIndex = index;
					break;
				}
			}

			int length = rootIndex - i;

			leftSubTreeStartPre = i;
			leftSubTreeEndPre = rootIndex - 1;
			leftSubTreeStartIn = m + 1;
			leftSubTreeEndIn = m + length;

			rightSubTreeStartPre = rootIndex + 1;
			rightSubTreeEndPre = j;
			rightSubTreeStartIn = leftSubTreeEndIn + 1;
			rightSubTreeEndIn = n;

			root.left = getRoot(inorder, leftSubTreeStartPre,
					leftSubTreeEndPre, preorder, leftSubTreeStartIn,
					leftSubTreeEndIn);
			root.right = getRoot(inorder, rightSubTreeStartPre,
					rightSubTreeEndPre, preorder, rightSubTreeStartIn,
					rightSubTreeEndIn);
			return root;
		}

	}
}
