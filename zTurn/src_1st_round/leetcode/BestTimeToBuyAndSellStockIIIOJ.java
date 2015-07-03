package leetcode;

/* Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
 * http://blog.sina.com.cn/s/blog_eb52001d0102v2hd.html
 * http://www.cnblogs.com/TenosDoIt/p/3436457.html
 */
public class BestTimeToBuyAndSellStockIIIOJ {
	public class Solution {
		public int maxProfit(int[] prices) {
			if (prices == null || prices.length == 0)
				return 0;
			int min = prices[0];
			int max = prices[prices.length - 1];
			int[] left = new int[prices.length];
			int[] right = new int[prices.length];

			for (int i = 1; i < prices.length; i++) {
				min = Math.min(min, prices[i]);
				left[i] = Math.max(left[i - 1], prices[i] - min);
			}
			for (int i = prices.length - 2; i >= 0; i--) {
				max = Math.max(max, prices[i]);
				right[i] = Math.max(right[i + 1], max - prices[i]);
			}
			int sum = 0;
			for (int i = 0; i < prices.length; i++) {
				sum = Math.max(sum, left[i] + right[i]);
			}

			return sum;
		}
	}
}
