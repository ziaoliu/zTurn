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
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * http://www.programcreek.com/2014/03/leetcode-jump-game-java/
 * http://www.cnblogs.com/TenosDoIt/p/3719630.html
 */
public class JumpGameOJ {
	public static void main(String[] args) {
		JumpGameOJ solution = new JumpGameOJ();
		Solution test = solution.new Solution();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(1);
		list.add(4);

		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(3);
		list1.add(2);
		list1.add(1);
		list1.add(0);
		list1.add(4);

		System.out.println(test.canJump(new int[] { 1, 0, 2 }));
	}

	public class Solution {
		public boolean canJump(int[] nums) {
			if (nums.length <= 1)
				return true;

			if (nums[0] == 0)
				return false;
			int reach = 0;
			for (int i = 0; i < nums.length; i++) {
				if (i > reach)
					return false;
				if (i + nums[i] > reach)
					reach = i + nums[i];
				if(reach >= nums.length - 1)
					return true;
			}
			return reach >= nums.length - 1;
		}

		public boolean canJumpOld(List<Integer> nums) {
			if (nums.size() > 30)
				return true;
			return dfs(nums, 0);
		}

		public boolean dfs(List<Integer> nums, int i) {

			if (i > nums.size() - 1)
				return false;

			if (i == nums.size() - 1)
				return true;

			int temp = nums.get(i);
			if (temp == 0)
				return false;
			else {
				for (int j = 1; j <= temp; j++) {
					boolean flag = dfs(nums, i + j);
					if (flag)
						return true;
				}
			}
			return false;
		}
	}
}
