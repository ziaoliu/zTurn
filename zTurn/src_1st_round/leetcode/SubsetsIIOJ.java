package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Subsets II
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 * 
 * http://blog.csdn.net/u011095253/article/details/9158397
 * http://fisherlei.blogspot.com/2013/01/leetcode-subsets-ii.html
 * http://www.meetqun.com/thread-1014-1-1.html
 * http://www.meetqun.com/thread-1014-1-1.html
 */
public class SubsetsIIOJ {
	public class Solution {
		//dfs
		public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (null == nums || nums.length <= 0)
				return result;

			ArrayList<Integer> list = new ArrayList<Integer>();

			if (nums.length == 1) {
				result.add(new ArrayList<Integer>(list));
				list.add(nums[0]);
				result.add(list);
				return result;
			}

			Arrays.sort(nums);
			result.add(list);
			dfs(result, nums, list, 0);

			return result;
		}

		public void dfs(ArrayList<ArrayList<Integer>> result, int[] nums,
				ArrayList<Integer> list, int i) {
			if (list.size() > nums.length)
				return;

			for (int index = i; index < nums.length; index++) {
				list.add(nums[index]);
				result.add(new ArrayList<Integer>(list));
				dfs(result, nums, list, index + 1);
				list.remove(list.size() - 1);
				// only difference from Subset I: remove duplicates
				while (index < nums.length - 1 && nums[index] == nums[index + 1])
					index++;
			}
		}
	}
}

