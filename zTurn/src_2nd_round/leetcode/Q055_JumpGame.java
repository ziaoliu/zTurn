package leetcode;

/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.

 http://blog.csdn.net/linhuanmars/article/details/21354751
 */
public class Q055_JumpGame {

	public class Solution {
		public boolean canJump(int[] nums) {
			if (nums.length <= 1)
				return true;

			int max = 0;
			for (int i = 0; i < nums.length; i++) {
				if (i > max)
					return false;
				max = Math.max(max, i + nums[i]);
			}

			return max >= nums.length - 1;
		}
	}
}
