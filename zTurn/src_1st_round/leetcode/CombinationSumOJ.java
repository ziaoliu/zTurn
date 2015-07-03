package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//http://blog.csdn.net/linhuanmars/article/details/20828631
//http://my.oschina.net/jdflyfly/blog/284240
public class CombinationSumOJ {
	public class Solution {
		public List<List<Integer>> combinationSum(int[] candidates, int target) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();

			if (null == candidates || candidates.length < 1)
				return result;

			Arrays.sort(candidates);

			List<Integer> list = new ArrayList<Integer>();
			recur(0, 0, candidates, list, result, target);

			return result;
		}

		public void recur(int current, int sum, int[] array,
				List<Integer> list, List<List<Integer>> result, int target) {

			if (current > array.length)
				return;

			if (array[current] > target)
				return;

			if (sum > target) {
				return;
			} else if (sum < target) {
				for (int i = current; i < array.length; i++) {
					list.add(array[i]);
					recur(i, array[i] + sum, array, list, result, target);
					list.remove(list.size() - 1);
				}
			} else { // array[next] + sum == target
				//list.add(array[current]);
				List<Integer> temp = new ArrayList<Integer>(list);
				Collections.sort(temp);
				if (!result.contains(temp))
					result.add(temp);
				return;
			}

		}
	}
}
