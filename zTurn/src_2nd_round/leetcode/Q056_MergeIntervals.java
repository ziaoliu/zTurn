package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Q056_MergeIntervals {
	// correct answer
	public class Solution {
		public List<Interval> merge(List<Interval> intervals) {
			List<Interval> result = new ArrayList<>();
			if (intervals == null || intervals.size() == 0)
				return result;
			Comparator<Interval> comparator = new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					if (o1.start == o2.start)
						return o1.end == o2.end ? 0 : o1.end < o2.end ? -1 : 1;
					else
						return o1.start < o2.start ? -1 : 1;
				}
			};

			Collections.sort(intervals, comparator);
			Interval pre = intervals.get(0);
			for (int i = 1; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				if (curr.start <= pre.end && curr.start >= pre.start) {
					pre.end = Math.max(pre.end, curr.end);
				} else {
					result.add(pre);
					pre = curr;
				}
			}
			result.add(pre);
			return result;
		}
	}

	public static void main(String[] args) {
		Q056_MergeIntervals test = new Q056_MergeIntervals();
		SolutionWrong t = test.new SolutionWrong();
		List<Interval> list = new ArrayList<>();
		Interval one = new Interval();
		one.start = 1;
		one.end = 4;
		Interval two = new Interval();
		two.start = 2;
		two.end = 3;
		list.add(one);
		list.add(two);

		t.merge(list);
	}

	public class SolutionWrong {
		public List<Interval> merge(List<Interval> intervals) {
			List<Interval> result = new ArrayList<>();
			if (intervals == null || intervals.size() == 0)
				return result;
			Comparator<Interval> comparator = new Comparator<Interval>() {

				@Override
				public int compare(Interval o1, Interval o2) {
					if (o1.start == o2.start)
						return o1.end == o2.end ? 0 : o1.end < o2.end ? -1 : 1;
					else
						return o1.start < o2.start ? -1 : 1;
				}
			};

			Collections.sort(intervals, comparator);

			for (int i = 0; i < intervals.size(); i++) {
				Interval interval = intervals.get(i);
				Interval merge = new Interval();
				merge.start = interval.start;
				int end = interval.end;
				for (int j = i + 1; j < intervals.size(); j++) {
					Interval tmp = intervals.get(j);
					if (tmp.start > end)
						break;
					if (tmp.start < end && tmp.end > end)
						end = tmp.end;
				}
				merge.end = end;
				result.add(merge);
			}

			System.out.println(result.size());

			return result;
		}
	}
}
