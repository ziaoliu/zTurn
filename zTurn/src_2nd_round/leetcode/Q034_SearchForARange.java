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
	public class Solution {
		public int[] searchRange(int[] nums, int target) {
			int[] result = {-1, -1};
			if(nums == null || nums.length == 0)
				return result;
			
			int i = 0;
			int j = nums.length - 1;
			int m = 0;
			while(i <= j){
				m = (i + j)/2;
				if(nums[m] == target)
					break;
				if(nums[m] > target)
					j = m - 1;
				else
					i = m + 1;
			}
			if(nums[m] != target)
				return result;
			
			
			return result;
		}
	}
}
