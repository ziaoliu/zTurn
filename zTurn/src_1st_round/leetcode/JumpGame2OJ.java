package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Jump Game
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
 * http://www.cnblogs.com/TenosDoIt/p/3719630.html
 * http://blog.csdn.net/havenoidea/article/details/11853301
 */
public class JumpGame2OJ {

	public class Solution {
		public int jump(int[] nums) {
			int curr = 0;
			int last = 0;
			int step = 0;

			for (int i = 0; i < nums.length; i++) {

				if (i > last) {
					last = curr;
					step++;
				}

				curr = Math.max(curr, i + nums[i]);
			}

			return step;
		}

	}
}
