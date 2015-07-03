package leetcode;

/* Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * https://en.wikipedia.org/wiki/Binary_search_tree
 * 
 */
public class ConvertSortedArrayToBinarySearchTreeOJ {
	public class Solution {
		public TreeNode sortedArrayToBST(int[] nums) {
			if (nums == null || nums.length == 0)
				return null;
			return recur(nums, 0, nums.length - 1);
		}

		public TreeNode recur(int[] nums, int start, int end) {
			if (start > end)
				return null;
			int mid = (start + end) / 2;
			TreeNode root = new TreeNode(nums[mid]);

			root.left = recur(nums, start, mid - 1);
			root.right = recur(nums, mid + 1, end);

			return root;
		}
	}
}
