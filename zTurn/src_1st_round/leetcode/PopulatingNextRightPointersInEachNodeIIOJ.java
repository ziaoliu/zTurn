package leetcode;

import java.util.ArrayList;

/* Populating Next Right Pointers in Each Node
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * 		You may only use constant extra space.
 * 		You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4   5 6  7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * 		You may only use constant extra space.
 * 
 */
public class PopulatingNextRightPointersInEachNodeIIOJ {
	public class Solution {
		public void connect(TreeLinkNode root) {
			if (root == null)
				return;
			ArrayList<TreeLinkNode> list = new ArrayList<>();
			list.add(root);
			int preCount = 1;
			int currCount = 0;

			while (list.size() > 0) {
				TreeLinkNode node = list.remove(0);
				preCount--;

				if (node.left != null) {
					currCount++;
					list.add(node.left);
				}
				if (node.right != null) {
					currCount++;
					list.add(node.right);
				}
				if (list.size() > 0)
					node.next = list.get(0);

				if (preCount == 0) {
					preCount = currCount;
					currCount = 0;
					node.next = null;
				}

			}
		}// end of method
	}
}
