package leetcode;

/*
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 *         1
 *        / \
 *       2   5
 *      / \   \
 *     3   4   6

 The flattened tree should look like:

 *   1
 *    \
 *     2
 *      \
 *       3
 *        \
 *         4
 *          \
 *           5
 *            \
 *             6

 http://www.cnblogs.com/springfor/p/3864355.html
 http://codeganker.blogspot.com/2014/04/flatten-binary-tree-to-linked-list.html
 */
public class Q114_FlattenBinaryTreeToLinkedList {
	public class Solution {
		TreeNode pre = null;

		public void flatten(TreeNode root) {
			if (root != null) {
				// print root
				TreeNode tmpRight = root.right;
				if (pre != null) {
					pre.left = null;
					pre.right = root;
				}
				pre = root;
				flatten(root.left);
				flatten(tmpRight);
			}
		}
	}
}
