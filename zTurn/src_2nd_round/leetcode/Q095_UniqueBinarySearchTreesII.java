package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3

 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q095_UniqueBinarySearchTreesII {
	public class Solution {
		public List<TreeNode> generateTrees(int n) {
			return generate(1, n);
		}

		private List<TreeNode> generate(int i, int n) {
			List<TreeNode> result = new ArrayList<TreeNode>();
			if (i > n) {
				result.add(null);
				return result;
			}
			for (int root = i; root <= n; root++) {
				List<TreeNode> leftTree = generate(i, root - 1);
				List<TreeNode> rightTree = generate(root + 1, n);
				for (TreeNode l : leftTree) {
					for (TreeNode r : rightTree) {
						TreeNode rootTree = new TreeNode(root);
						rootTree.left = l;
						rootTree.right = r;
						result.add(rootTree);
					}
				}
			}
			return result;
		}
	}
}
