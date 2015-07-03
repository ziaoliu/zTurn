package leetcode;

import java.util.HashSet;

/*
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 
 http://www.cnblogs.com/springfor/p/3869981.html
 http://blog.csdn.net/linhuanmars/article/details/22964467
 */
public class LongestConsecutiveSequenceOJ {
	public class Solution {
		public int longestConsecutive(int[] nums) {
			if (nums == null || nums.length == 0)
				return 0;
			int max = 0;
			int count = 0;
			HashSet<Integer> set = new HashSet<>();
			for (int i : nums)
				set.add(i);

			for (int i = 0; i < nums.length; i++) {
				int element = nums[i];
				set.remove(element);
				count = 1;

				int low = element - 1;
				while (set.contains(low)) {
					set.remove(low);
					count++;
					low--;
				}

				int high = element + 1;
				while (set.contains(high)) {
					set.remove(high);
					count++;
					high++;
				}

				max = Math.max(max, count);
			}
			return max;
		}
	}
}
