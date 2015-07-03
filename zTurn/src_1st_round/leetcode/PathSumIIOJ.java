package leetcode;

import java.util.ArrayList;

/* Path Sum
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return
 * [
 *   [5,4,11,2],
 *   [5,8,4,5]
 * ]
 * 
 * http://blog.csdn.net/linhuanmars/article/details/23655413 * 
 */
public class PathSumIIOJ {
	public class Solution {
		public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (root == null)
				return result;
			ArrayList<Integer> list = new ArrayList<Integer>();
			sum(result, list, root, sum);
			return result;
		}

		public void sum(ArrayList<ArrayList<Integer>> result,
				ArrayList<Integer> list, TreeNode root, int sum) {
			if (root == null)
				return;
			ArrayList<Integer> temp = new ArrayList<Integer>(list);
			sum = sum - root.val;
			temp.add(root.val);
			if (root.left == null && root.right == null && sum == 0) {
				result.add(temp);
				return;
			}
			sum(result, temp, root.left, sum);
			sum(result, temp, root.right, sum);
		}
	}

	public class SolutionLinHuanMars {
		public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (root == null)
				return result;
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			sum(result, list, root, sum - root.val);
			return result;
		}

		public void sum(ArrayList<ArrayList<Integer>> result,
				ArrayList<Integer> list, TreeNode root, int sum) {
			if (root == null)
				return;
			// sum = sum - root.val;
			if (root.left == null && root.right == null && sum == 0) {
				result.add(new ArrayList<Integer>(list));
				return;
			}
			if (root.left != null) {
				list.add(root.left.val);
				sum(result, list, root.left, sum - root.left.val);
				list.remove(list.size() - 1);
			}
			if (root.right != null) {
				list.add(root.right.val);
				sum(result, list, root.right, sum - root.right.val);
				list.remove(list.size() - 1);
			}
		}
	}
}
