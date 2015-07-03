package leetcode;

import java.util.ArrayList;

/* Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7 
 *    
 * return its level order traversal as:
 *  
 *  [
 *  [3],
 *  [9,20],
 *  [15,7]
 *  ]
 * 
 * http://blog.csdn.net/linhuanmars/article/details/23404111
 */
public class BinaryTreeLevelOrderTraversalOJ {
	public class SolutionBest {
		public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (root == null)
				return result;
			ArrayList<TreeNode> list = new ArrayList<>();
			ArrayList<Integer> level = new ArrayList<>();
			int preCount = 1;
			int currCount = 0;
			list.add(root);
			while (list.size() > 0) {
				TreeNode node = list.remove(0);
				preCount--;
				level.add(node.val);

				if (node.left != null) {
					list.add(node.left);
					currCount++;
				}

				if (node.right != null) {
					list.add(node.right);
					currCount++;
				}

				if (preCount == 0) {
					preCount = currCount;
					currCount = 0;
					result.add(level);
					level = new ArrayList<>();
				}

			}

			return result;
		}// end of method
	}

	public class Solution {
		public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (root == null)
				return result;
			ArrayList<TreeNode> list = new ArrayList<>();
			list.add(root);
			while (list.size() > 0) {
				ArrayList<TreeNode> temp = (ArrayList<TreeNode>) list.clone();
				list = new ArrayList<>();
				ArrayList<Integer> level = new ArrayList<>();
				for (int i = 0; i < temp.size(); i++) {
					TreeNode node = (TreeNode) temp.get(i);
					if (node != null)
						level.add(node.val);
					if (node.left != null)
						list.add(node.left);
					if (node.right != null)
						list.add(node.right);
				}
				if (level.size() > 0)
					result.add(level);
				else
					break;
			}

			return result;
		}// end of method
	}
}
