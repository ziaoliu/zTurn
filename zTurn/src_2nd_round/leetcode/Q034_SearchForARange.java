package leetcode;

/*
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 http://blog.csdn.net/linhuanmars/article/details/20593391
 */
public class Q034_SearchForARange {
	public static void main(String[] args) {
		Q034_SearchForARange test = new Q034_SearchForARange();
		Solution s = test.new Solution();
		int[] nums = { 2, 2 };
		System.out.println(s.searchRange(nums, 2));
	}

	public class Solution {
		public int[] searchRange(int[] nums, int target) {
			int[] result = { -1, -1 };
			if (nums == null || nums.length == 0)
				return result;

			int i = 0;
			int j = nums.length - 1;
			while (i <= j) {
				int m = (i + j) / 2;
				if (nums[m] < target)
					i = m + 1;
				else
					j = m - 1;
			}

			int m = 0;
			int n = nums.length - 1;
			while (m <= n) {
				int c = (m + n) / 2;
				if (nums[c] > target)
					n = c - 1;
				else
					m = c + 1;
			}

			if (i <= n) {
				result[0] = i;
				result[1] = n;
			}
			return result;
		}
	}

	public class Solution3Loops {
		public int[] searchRange(int[] nums, int target) {
			int[] result = { -1, -1 };
			if (nums == null || nums.length == 0)
				return result;

			int i = 0;
			int j = nums.length - 1;
			int m = 0;
			while (i <= j) {
				m = (i + j) / 2;
				if (nums[m] == target)
					break;
				if (nums[m] > target)
					j = m - 1;
				else
					i = m + 1;
			}

			if (nums[m] != target)
				return result;

			i = 0;
			int l = m;
			while (i <= l) {
				int c = (i + l) / 2;
				if (nums[c] == target)
					l = c - 1;
				else
					i = c + 1;
			}

			result[0] = i;

			int r = m;
			j = nums.length - 1;
			while (r <= j) {
				int c = (j + l) / 2;
				if (nums[c] == target)
					r = c + 1;
				else
					j = c - 1;
			}

			result[1] = j;

			return result;
		}
	}
}
