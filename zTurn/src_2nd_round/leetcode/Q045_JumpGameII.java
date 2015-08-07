package leetcode;

/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
 http://blog.csdn.net/linhuanmars/article/details/21356187
 */
public class Q045_JumpGameII {
	public class Solution {
		public int jump(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int last = 0;
			int max = 0;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				if (i > last) {
					count++;
					last = max;
				}
				max = Math.max(max, i + nums[i]);
			}
			return max >= nums.length - 1 ? count : 0;
		}
	}
}
