package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/* Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7 
 *    
 * return its zigzag level order traversal as:
 * 
 *  [
 *  [3],
 *  [20,9],
 *  [15,7]
 *  ]
 *  
 *  http://blog.csdn.net/linhuanmars/article/details/24509105
 */
public class BinaryTreeZigzagLevelOrderTraversalOJ {
	public class Solution {
		public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (root == null)
				return result;
			ArrayList<TreeNode> list = new ArrayList<>();
			ArrayList<Integer> level = new ArrayList<>();
			int preCount = 1;
			int currCount = 0;
			boolean onOff = false;
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
					if (onOff)
						Collections.reverse(level);
					onOff = !onOff;
					result.add(level);
					level = new ArrayList<>();
				}

			}

			return result;
		}
	}
}
