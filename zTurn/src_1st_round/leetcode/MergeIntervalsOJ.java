package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Merge Intervals

 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 Definition for an interval.
 
 http://blog.csdn.net/linhuanmars/article/details/21857617
 http://www.programcreek.com/2012/12/leetcode-merge-intervals/
 

 */
class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervalsOJ {

	public static void main(String[] args) {
		Interval a = new Interval(0, 4);
		Interval b = new Interval(1, 4);
		List<Interval> list = new ArrayList<Interval>();
		list.add(a);
		list.add(b);
		MergeIntervalsOJ test = new MergeIntervalsOJ();
		Solution testCase = test.new Solution();
		System.out.println(testCase.merge(list));
	}

	public class Solution {
		public List<Interval> merge(List<Interval> intervals) {
			if (null == intervals || intervals.size() <= 1)
				return intervals;

			List<Interval> result = new ArrayList<Interval>();
			Comparator<Interval> comparator = new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					if (o1.start == o2.start)
						return o1.end - o2.end;
					return o1.start - o2.start;
				}

			};

			Collections.sort(intervals, comparator);

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
		}// end of method
	}
}
