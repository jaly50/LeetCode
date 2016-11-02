/*
  leetcode No.5
*@author Scarlett
*@date 2014/9/4
 Buyday should before sellday.
*/
public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length <1) return profit;
        int min = prices[0];
        for (int i=0; i<prices.length-1;i++) {
            if ((prices[i]<min) || (i == 0)) {
            for (int j=i+1; j<prices.length; j++) {
                if ((prices[j]-prices[i])>profit) {
                    profit = prices[j]-prices[i];
                    min = prices[i];
                }
            }
            }
        }
        return profit;
        
    }
    public static void main(String agrs[]) {
    	
    }
}
