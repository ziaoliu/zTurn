package leetcode;

/* Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * 
 * http://articles.leetcode.com/2010/11/best-time-to-buy-and-sell-stock.html
 * http://blog.csdn.net/linhuanmars/article/details/23162793
 */
public class BestTimeToBuyAndSellStockOJ {
	public class Solution {
		public int maxProfit(int[] prices) {
			int minIndex = 0;
			int buy = 0;
			int sell = 0;
			int diff = 0;
			int maxProfit = 0;
			for (int i = 0; i < prices.length; i++) {
				if (prices[i] < prices[minIndex])
					minIndex = i;
				diff = prices[i] - prices[minIndex];
				if (diff > maxProfit) {
					maxProfit = diff;
					buy = minIndex;
					sell = i;
				}
			}
			return maxProfit;
		}
	}
}
