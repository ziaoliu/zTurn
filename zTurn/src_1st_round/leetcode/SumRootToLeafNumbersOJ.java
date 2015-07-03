package leetcode;

import java.util.ArrayList;

/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * http://blog.csdn.net/linhuanmars/article/details/22913699
 */
public class SumRootToLeafNumbersOJ {
	public class Solution {
		public int sumNumbers(TreeNode root) {
			return dfs(root, 0);
		}

		private int dfs(TreeNode root, int sum) {
			if (root == null)
				return 0;

			if (root.left == null && root.right == null)
				return sum * 10 + root.val;

			return dfs(root.left, sum * 10 + root.val)
					+ dfs(root.right, sum * 10 + root.val);
		}
	}

	public class SolutionFirstTry {
		public int sumNumbers(TreeNode root) {
			if (root == null)
				return 0;
			int sum = 0;
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			ArrayList<Integer> one = new ArrayList<>();
			dfs(list, one, root);

			for (ArrayList<Integer> temp : list) {
				StringBuilder sb = new StringBuilder();
				for (int i : temp)
					sb.append(i);
				sum = sum + Integer.parseInt(sb.toString());
			}

			return sum;
		}

		public void dfs(ArrayList<ArrayList<Integer>> list,
				ArrayList<Integer> one, TreeNode root) {
			if (root == null)
				return;

			one.add(root.val);
			TreeNode left = root.left;
			TreeNode right = root.right;
			dfs(list, one, left);
			dfs(list, one, right);

			if (left == null && right == null)
				list.add(new ArrayList<Integer>(one));

			one.remove(one.size() - 1);
		}
	}
}
