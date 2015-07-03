package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Insert Interval
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].


 */
public class InsertIntervalOJ {
	public class Solution {
		public List<Interval> insert(List<Interval> intervals,
				Interval newInterval) {
			if (null == newInterval)
				return intervals;

			intervals.add(newInterval);
			Comparator<Interval> comparactor = new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					if (o1.start == o2.start)
						return o1.end - o2.end;
					return o1.start - o2.start;
				}
			};

			Collections.sort(intervals, comparactor);
			if (null == intervals || intervals.size() <= 1)
				return intervals;

			List<Interval> result = new ArrayList<Interval>();
			int i = 1;
			Interval pre = intervals.get(0);
			while (i < intervals.size()) {
				Interval curr = intervals.get(i);
				if (curr.start <= pre.end && curr.start >= pre.start) {
					pre.end = Math.max(pre.end, curr.end);
				} else {
					result.add(pre);
					pre = curr;
				}
				i++;
			}
			result.add(pre);

			return result;
		}//end of method
	}
}
