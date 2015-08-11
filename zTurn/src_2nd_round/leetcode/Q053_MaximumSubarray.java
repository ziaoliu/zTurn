package leetcode;

/*
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 http://www.cnblogs.com/springfor/p/3877058.html
 http://blog.csdn.net/xshengh/article/details/12708291
 */
public class Q053_MaximumSubarray {
	// Divide and Conquer
	public class Solution {
		public int maxSubArray(int[] nums) {
			return max(nums, 0, nums.length - 1);
		}

		private int max(int[] nums, int low, int high) {
			if (low == high)
				return nums[low];
			if (low == high - 1)
				return Math.max(nums[low] + nums[high],
						Math.max(nums[low], nums[high]));

			int mid = (low + high) / 2;
			int lmax = max(nums, low, mid - 1);
			int rmax = max(nums, mid + 1, high);

			int mmax = nums[mid];
			int tmp = mmax;
			for (int i = mid - 1; i >= low; i--) {
				tmp = tmp + nums[i];
				if (tmp > mmax)
					mmax = tmp;
			}
			tmp = mmax;
			for (int i = mid + 1; i <= high; i++) {
				tmp = tmp + nums[i];
				if (tmp > mmax)
					mmax = tmp;
			}
			return Math.max(mmax, Math.max(lmax, rmax));
		}
	}

	public class SolutionOn {
		public int maxSubArray(int[] nums) {
			if (nums == null || nums.length == 0)
				return Integer.MIN_VALUE;

			int max = Integer.MIN_VALUE;
			int sum = 0;

			for (int i = 0; i < nums.length; i++) {
				sum = sum + nums[i];
				max = Math.max(max, sum);
				if (sum < 0) {
					sum = 0;
				}
			}
			return max;
		}
	}
}
