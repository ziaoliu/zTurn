package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FourSum {
	public class Solution {
		public List<List<Integer>> fourSum(int[] num, int target) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();

			if (null == num || num.length < 4)
				return result;

			Arrays.sort(num);

			for (int i = 0; i < num.length - 3; i++) {
				for (int j = i + 1; j < num.length - 2; j++) {
					int a = num[i];
					int b = num[j];
					int cIndex = j + 1;
					int dIndex = num.length - 1;

					while (cIndex < dIndex) {
						int sum = a + b + num[cIndex] + num[dIndex];
						if (sum > target)
							dIndex--;
						else if (sum < target) {
							cIndex++;
						} else {
							List<Integer> temp = new ArrayList<Integer>();
							temp.add(a);
							temp.add(b);
							temp.add(num[cIndex]);
							temp.add(num[dIndex]);
							Collections.sort(temp);
							if (!result.contains(temp)) {
								result.add(temp);
							}
							dIndex--;
							cIndex++;
						}
					}
				}

			}

			return result;
		}
	}
}
