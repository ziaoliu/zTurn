package leetcode;

/*
 Implement int sqrt(int x).

 Compute and return the square root of x.
 
 http://blog.csdn.net/linhuanmars/article/details/20089131
 */
public class Q069_SqrtX {
	public static void main(String[] args) {
		Q069_SqrtX test = new Q069_SqrtX();
		Solution t = test.new Solution();
		for (int i = 0; i < 10; i++) {
			System.out.println(t.mySqrt(i));
		}
	}

	public class Solution {
		public int mySqrt(int x) {
			if (x < 0)
				return -1;
			if (x == 0)
				return 0;
			int i = 1;
			int j = x / 2 + 1;
			while (i <= j) {
				int m = (i + j) / 2;
				if (x / m >= m && x / (m + 1) <= (m + 1))
					return m;
				if (x / m > m)
					i = m + 1;
				else
					j = m - 1;
			}
			return 0;
		}
	}
}
