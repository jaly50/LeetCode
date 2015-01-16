/*
 * LeetCode No.6 BestTimeToBuyAndSellStock2
 * @author Scarlett
 * @date 2014/9/5 0:06
 */
public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
    	 if (prices.length <=1) return 0;
    	 int total = 0,minday;
         int i =0;
    	   while (i<prices.length) {
    	   minday =i;
    	   while ((i+1<prices.length) && (prices[i] < prices[i+1])) i++;
    	   total +=prices[i]-prices[minday];
    	   i++;
    	   }
    	   
    	return total;
    }
    
}