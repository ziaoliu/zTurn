package leetcode;

/*
 Given an array of integers, every element appears three times except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 http://www.cnblogs.com/springfor/p/3870863.html
 http://blog.csdn.net/linhuanmars/article/details/22645599
 */
public class Q137_SingleNumberII {
	public class Solution {
		public int singleNumber(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int[] binary = new int[32];
			int one = 0;
			for (int i = 0; i < 32; i++) {
				for (int j = 0; j < nums.length; j++) {
					binary[i] += (nums[j] >> i) & 1;
				}
			}
			for (int i = 0; i < 32; i++) {
				one += (binary[i] % 3) << i;
			}
			return one;
		}
	}
}
