package leetcode;

import java.util.HashMap;

/*
 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 http://blog.csdn.net/linhuanmars/article/details/24389549
 http://fisherlei.blogspot.com/2013/01/leetcode-construct-binary-tree-from.html
 http://www.cnblogs.com/springfor/p/3884034.html
 */
public class Q105_ConstructBinaryTreefromPreorderAndInorderTraversal {
	public class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			if (preorder == null || inorder == null)
				return null;
			HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
			for (int i = 0; i < inorder.length; i++)
				inorderMap.put(inorder[i], i);
			return recur(preorder, 0, preorder.length - 1, inorder, 0,
					inorder.length - 1, inorderMap);
		}

		private TreeNode recur(int[] preorder, int preL, int preR,
				int[] inorder, int inL, int inR,
				HashMap<Integer, Integer> inorderMap) {
			if (preL > preR || inL > inR)
				return null;
			TreeNode root = new TreeNode(preorder[preL]);
			int index = inorderMap.get(root.val);
			root.left = recur(preorder, preL + 1, index - inL + preL, inorder,
					inL, index - 1, inorderMap);
			root.right = recur(preorder, index - inL + preL + 1, preR, inorder,
					index + 1, inR, inorderMap);
			return root;
		}
	}
}
