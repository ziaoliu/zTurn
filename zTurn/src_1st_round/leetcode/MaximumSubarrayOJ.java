package leetcode;

/* Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * http://blog.csdn.net/v_JULY_v/article/details/6444021
 * 
 * http://joycelearning.blogspot.com/2013/10/leetcode-maximum-subarray.html
 * http://blog.csdn.net/xshengh/article/details/12708291
 * http://fisherlei.blogspot.com/2012/12/leetcode-maximum-subarray.html
 */
public class MaximumSubarrayOJ {
	public class Solution {
		// Divide and Conquer
		public int maxSubArray(int[] nums) {
			int max = Integer.MIN_VALUE;
			return max(nums, 0, nums.length - 1, max);
		}

		private int max(int[] nums, int i, int j, int max) {
			if(i > j) return Integer.MIN_VALUE;
			
			int mid = (i + j)/2;
			
			// if subarray is in left or right
			int lmax = max(nums, i, mid - 1, max);
			int rmax = max(nums, mid + 1, j, max);
			max = Math.max(max, Math.max(lmax, rmax));
			
			// if subarray is across left and right
			int sum = 0;
			int ltemp = 0;//int sum = 0, midLeftMax = 0;
			for(int a = mid - 1; a >= i ; a--){
				sum = sum + nums[a];
				if(sum > ltemp)
					ltemp = sum;
			}
			sum = 0;
			int rtemp = 0;
			for(int a = mid + 1; a <= j; a++){
				sum = sum + nums[a];
				if(sum > rtemp)
					rtemp = sum;
			}
			max = Math.max(max, ltemp + rtemp + nums[mid]);
			return max;
		}

		public int maxSubArrayOn(int[] nums) {
			if (nums.length <= 0)
				return 0;
			if (nums.length == 1)
				return nums[0];

			int max = Integer.MIN_VALUE;
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum = sum + nums[i];
				if (sum > max)
					max = sum;
				if (sum < 0) {
					sum = 0;
				}
			}
			return max;
		}// end of method
	}
}
