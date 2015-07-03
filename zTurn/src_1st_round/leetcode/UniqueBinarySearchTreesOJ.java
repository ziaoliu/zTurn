package leetcode;

import java.util.ArrayList;

/* Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 1         3     3      2      1 
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2      1         2                 3
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24761437
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-unique-binary-search-trees-i-ii.html
 */
public class UniqueBinarySearchTreesOJ {
	public static void main(String[] args) {
		UniqueBinarySearchTreesOJ test = new UniqueBinarySearchTreesOJ();
		Solution tt = test.new Solution();
		System.out.println(tt.generateTrees(3));
	}

	public class Solution {
		public ArrayList<TreeNode> generateTrees(int n) {
			return generate(1, n);
		}

		private ArrayList<TreeNode> generate(int left, int right) {
			ArrayList<TreeNode> result = new ArrayList<>();
			if (left > right) {
				result.add(null);
				return result;
			}

			for (int i = left; i <= right; i++) {
				ArrayList<TreeNode> leftTree = generate(left, i - 1);
				ArrayList<TreeNode> rightTree = generate(i + 1, right);
				for (TreeNode leftNode : leftTree) {
					for (TreeNode rightNode : rightTree) {
						TreeNode root = new TreeNode(i);
						root.left = leftNode;
						root.right = rightNode;
						result.add(root);
					}
				}
			}

			return result;
		}
	}
}
