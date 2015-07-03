package leetcode;

import java.util.ArrayList;
import java.util.List;

/* Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
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
 *  [15,7],
 *  [9,20],
 *  [3]
 *  ]
 * 
 * http://blog.csdn.net/linhuanmars/article/details/23414711
 */
public class BinaryTreeLevelOrderTraversalIIOJ {
	public class Solution {
		public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
			ArrayList<ArrayList<Integer>> results = new ArrayList<>();
			if (root == null)
				return results;
			ArrayList<TreeNode> list = new ArrayList<>();
			ArrayList<Integer> level = new ArrayList<>();
			list.add(root);
			int preCount = 1;
			int currCount = 0;
			while (list.size() != 0) {
				TreeNode temp = list.get(0);
				level.add(temp.val);
				preCount--;
				if (temp.left != null) {
					list.add(temp.left);
					currCount++;
				}
				if (temp.right != null) {
					list.add(temp.right);
					currCount++;
				}
				if (preCount == 0) {
					preCount = currCount;
					currCount = 0;
					results.add(0, level);
					level = new ArrayList<>();
				}
			}
			return results;
		}
	}
}
