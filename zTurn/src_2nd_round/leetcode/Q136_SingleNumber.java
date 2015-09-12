package leetcode;

/*
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 http://fisherlei.blogspot.com/2013/11/leetcode-single-number-solution.html
 */
public class Q136_SingleNumber {
	public static void main(String[] args) {
		System.out.println(10 ^ 10);
	}

	public class Solution {
		public int singleNumber(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int which = nums[0];
			for (int i = 1; i < nums.length; i++) {
				which = which ^ nums[i];
			}
			return which;
		}
	}
}
