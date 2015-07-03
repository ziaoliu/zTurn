package leetcode;

/* Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *         1
 *        / \
 *       2   5
 *      / \   \
 *     3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal. 
 * 
 * http://blog.csdn.net/linhuanmars/article/details/23717703
 */
public class FlattenBinaryTreeToLinkedListOJ {
	public class Solution {
		TreeNode pre = null;

		public void flatten(TreeNode root) {
			if (root == null)
				return;
			flattenSubTree(root);
		}

		public void flattenSubTree(TreeNode root) {
			if (root == null)
				return;

			TreeNode left = root.left;
			TreeNode right = root.right;
			if (pre != null) {
				pre.left = null;
				pre.right = root;
			}
			pre = root;
			flattenSubTree(left);
			flattenSubTree(right);
		}
	}

	public class SolutionFailed {
		public void flatten(TreeNode root) {
			if (root == null)
				return;

			flattenSubTree(root);

		}

		public TreeNode flattenSubTree(TreeNode root) {
			if (root.left == null && root.right == null)
				return root;

			TreeNode leftSubRoot = root.left;
			TreeNode leftSubEnd = null;
			if (root.left != null)
				leftSubEnd = flattenSubTree(leftSubRoot);

			TreeNode rightSubRoot = root.right;
			TreeNode rightSubEnd = null;
			if (root.right != null)
				rightSubEnd = flattenSubTree(rightSubRoot);

			if (leftSubEnd != null) {
				root.right = leftSubRoot;
				root.left = null;
				if (rightSubRoot != null)
					leftSubEnd.right = rightSubRoot;
			}
			return rightSubEnd == null ? rightSubRoot : rightSubEnd;
		}
	}
}
