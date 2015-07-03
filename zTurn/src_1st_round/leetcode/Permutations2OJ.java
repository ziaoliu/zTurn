package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
public class Permutations2OJ {
	public class Solution {
		public List<List<Integer>> permuteUnique(int[] num) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();

			if (null == num || num.length < 1)
				return result;

			Arrays.sort(num);
			
			dfs(0, num, result);

			return result;
		}

		public void dfs(int position, int[] num, List<List<Integer>> result) {

			if (position > num.length - 1) {
				List<Integer> list = list(num);
				if (!result.contains(list)) {
					result.add(list);
					return;
				}
			}
			int pre = Integer.MIN_VALUE;
			for (int i = position; i < num.length; i++) {
				if(num[i] == pre)
					continue;
				
				pre = num[i];
				
				swap(num, position, i);
				dfs(position + 1, num, result);
				swap(num, position, i);
			}

		}

		private void swap(int[] num, int i, int j) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}

		private List<Integer> list(int[] num) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i : num) {
				list.add(i);
			}
			return list;
		}
	}//end Solution
}
