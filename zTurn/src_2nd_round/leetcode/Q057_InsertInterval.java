package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class Q057_InsertInterval {
	public class Solution {
		public List<Interval> insert(List<Interval> intervals,
				Interval newInterval) {
			List<Interval> result = new ArrayList<Interval>();

			if (intervals == null || intervals.size() == 0) {
				result.add(newInterval);
				return result;
			}
			intervals.add(newInterval);
			Comparator<Interval> comparator = new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					if (o1.start == o2.start) {
						if (o1.end == o2.end)
							return 0;
						else
							return o1.end < o2.end ? -1 : 1;
					}
					return o1.start < o2.start ? -1 : 1;
				}
			};

			Collections.sort(intervals, comparator);

			Interval pre = intervals.get(0);
			for (int i = 1; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				if (pre.start <= curr.start && curr.start <= pre.end)
					pre.end = Math.max(curr.end, pre.end);
				else {
					result.add(pre);
					pre = curr;
				}
			}
			result.add(pre);
			return result;
		}
	}
}
