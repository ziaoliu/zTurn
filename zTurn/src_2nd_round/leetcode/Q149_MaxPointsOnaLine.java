package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Q149_MaxPointsOnaLine {
	/**
	 * Definition for a point. class Point { int x; int y; Point() { x = 0; y =
	 * 0; } Point(int a, int b) { x = a; y = b; } }
	 */
	public static void main(String[] args) {
		Solution2 so = new Q149_MaxPointsOnaLine().new Solution2();
		Point[] points = { new Point(3, 10), new Point(0, 2), new Point(0, 2), new Point(3, 10) };
		System.out.println(so.maxPoints(points));
	}

	// old way
	public class Solution2 {
		public int maxPoints(Point[] points) {
			if (points == null)
				return 0;
			if (points.length == 1)
				return 1;

			Map<Line, Set<Point>> map = new HashMap<Line, Set<Point>>();
			for (int i = 0; i < points.length; i++) {
				Point p1 = points[i];
				for (int j = i + 1; j < points.length; j++) {
					Point p2 = points[j];
					double k;
					if (p2.x - p1.x != 0)
						k = (p2.y - p1.y) / (p2.x - p1.x);
					else
						k = 0;
					double a = p2.y - k * p2.x;
					Line line = new Line(k, a);
					Set<Point> set = new HashSet<Point>();
					if (map.containsKey(line)) {
						// System.out.println("map contains the key");
						set = map.get(line);
					}
					set.add(p1);
					set.add(p2);
					map.put(line, set);
				}
			}
			int max = 0;
			Iterator<Set<Point>> iter = map.values().iterator();
			while (iter.hasNext()) {
				Set set = iter.next();
				int count = set.size();
				if (count > max)
					max = count;
			}

			return max;
		}
	}

	class Line {
		double k;
		double a;

		Line(double k, double a) {
			this.k = k;
			this.a = a;
			// System.out.println("Line created : k: " + k + " a: " + a + "
			// hash: "+ hashCode());
		}

		@Override
		public boolean equals(Object line) {
			Line l = (Line) line;
			if (this.k == l.k && this.a == l.a)
				return true;
			else
				return false;
		}

		@Override
		public int hashCode() {
			int hashcode = 23;
			hashcode = (hashcode * 37) + (int) k;
			hashcode = (hashcode * 37) + (int) a;
			return hashcode;
		}
	}
/*
 * http://blog.csdn.net/linhuanmars/article/details/21060933
 */
	public class Solution {
		public int maxPoints(Point[] points) {
			if (points == null || points.length == 0)
				return 0;

			int max = 0;

			for (int i = 0; i < points.length; i++) {
				Map<Double, Integer> map = new HashMap<>();
				Point p1 = points[i];
				int samePoint = 0;
				int localMax = 1;
				double k = 0.0;
				for (int j = i + 1; j < points.length; j++) {
					Point p2 = points[j];
					if (p1.x == p2.x && p1.y == p2.y) {
						samePoint++;
						continue;
					}
					
					if (p1.x == p2.x)
						k = (double) Integer.MAX_VALUE;
					else if (p1.y == p2.y)
						k = 0.0;
					else
						k = (double)(p2.y - p1.y) / (double)(p2.x - p1.x);
					
					if (map.containsKey(k)) {
						map.put(k, map.get(k) + 1);
					} else
						map.put(k, 2);
				}
				for (Integer local : map.values())
					localMax = Math.max(local, localMax);
				max = Math.max(localMax + samePoint, max);
			}

			return max;
		}
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
