package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Subsets
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 * 
 * http://blog.csdn.net/linhuanmars/article/details/24286377
 * http://www.cnblogs.com/springfor/p/3879830.html
 */
public class SubsetsOJ {
	public class Solution {
		//DFS
		public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (null == nums || nums.length <= 0)
				return result;

			ArrayList<Integer> list = new ArrayList<Integer>();
			
			if(nums.length==1){
				result.add(new ArrayList<Integer>(list));
				list.add(nums[0]);
				result.add(list);
				return result;
			}

			Arrays.sort(nums); 
			dfs(result, nums, list, 0);

			return result;
		}

		public void dfs(ArrayList<ArrayList<Integer>> result, int[] nums,
				ArrayList<Integer> list, int i) {
			if (list.size() > nums.length)
				return;

			if (!result.contains(list)) {
				Collections.sort(list);
				result.add(new ArrayList<Integer>(list));
			}

			for (int index = i; index < nums.length; index++) {
				list.add(nums[index]);
				dfs(result, nums, list, index + 1);
				list.remove(list.size() - 1);
			}
		}
	}
}
