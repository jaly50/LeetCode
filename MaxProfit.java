/*
 * Scarlett Chen
 * 309. Best Time to Buy and Sell Stock with Cooldown 
 * 10/12/2016
 * 
 */
package leetcode;

public class MaxProfit {
	// 一维的做法。可以降到space -= o(1)
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        if (len < 2) return 0;
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i=1; i< len; i++) {
            buy[i] = Math.max(buy[i-1], -prices[i]);
            if (i>=2) buy[i] = Math.max(buy[i], sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i] );
        } 
        return sell[len-1];
    }
    // downgrade to space o(1)
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int cur_buy=0, yes_buy=-prices[0];
        int cur_sell=0, yes_sell=0, before_sell=0;
        for (int i=1; i< len; i++) {
            cur_buy = Math.max(yes_buy, before_sell-prices[i]);
            cur_sell = Math.max(yes_sell, yes_buy+prices[i] );
            yes_buy = cur_buy;
            before_sell = yes_sell;
            yes_sell = cur_sell;
        } 
        return cur_sell;
    }
	public static void main(String[] args) {

	}

}
