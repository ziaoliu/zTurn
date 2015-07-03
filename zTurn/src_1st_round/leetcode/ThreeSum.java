package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//http://www.programcreek.com/2012/12/leetcode-3sum/
public class ThreeSum {
	public class Solution {
		public List<List<Integer>> threeSum1(int[] num) {
			List<List<Integer>> triplets = new ArrayList<List<Integer>>();
			List<Integer> triplet = new ArrayList<Integer>();
			if (num == null || num.length < 3)
				return triplets;
			Arrays.sort(num);

			for (int i = 0; i < num.length - 2; i++) {
				int j = num.length - 1;
				int k = i + 1;
				if (i == 0 || num[i] > num[i - 1])
					while (k < j) {
						triplet = new ArrayList<Integer>();
						if (num[j] + num[k] + num[i] == 0) {
							triplet.add(num[i]);
							triplet.add(num[k]);
							triplet.add(num[j]);
							if (!triplets.contains(triplet))
								triplets.add(triplet);
							j--;
							k++;
						} else if (num[j] + num[k] > 0 - num[i]) {
							j--;
						} else
							k++;
					}

			}

			return triplets;
		}

		public List<List<Integer>> threeSum(int[] num) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();

			for (int i = 0; i < num.length - 2; i++) {
				int a = num[i];
				HashMap<Integer, Integer> map = new HashMap<>();
				for (int j = i + 1; j < num.length; j++) {
					int total = 0 - a;
					if (!map.containsKey(num[j]))
						map.put(total - num[j], num[j]);
					else {
						int b = map.get(num[j]);
						int c = num[j];

						List<Integer> triplet = new ArrayList<Integer>();
						triplet.add(a);
						triplet.add(b);
						triplet.add(c);

						Collections.sort(triplet);

						if (!result.contains(triplet))
							result.add(triplet);
					}
				}

			}

			return result;
		}

	}
}
