package leetcode;

/* Recover Binary Search Tree
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * 
 * http://www.cnblogs.com/yuzhangcmu/p/4208319.html
 * http://www.cnblogs.com/TenosDoIt/p/3445682.html
 * O(1) space => http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 */
public class RecoverBinarySearchTreeOJ {
	public class Solution {

		TreeNode pre = null;
		TreeNode first = null;
		TreeNode second = null;

		public void recoverTree(TreeNode root) {
			if (root == null)
				return;

			inorder(root);

			if (first != null) {
				if (second == null)
					second = pre;
				int temp = first.val;
				first.val = second.val;
				second.val = temp;
			}
		}

		public void inorder(TreeNode root) {
			if (root == null)
				return;

			inorder(root.left);

			if (pre != null) {
				if (first == null && pre.val > root.val)
					first = pre;
				if (first != null && root.val > first.val) {
					second = pre;
					return;

				}
			}
			pre = root;

			inorder(root.right);
		}
	}
}
