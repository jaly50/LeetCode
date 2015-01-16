
public class BestTimeToBuyAndSellStock3 {
	  public static int maxProfit(int[] prices) {
		  int total = 0;
		  if (prices.length <=1) return 0;
		  int [] fp,lp; // firstPofit and lastprofit; they are respectively represent the direction
		  fp = new int[prices.length];
		  lp = new int[prices.length];
		  int min = prices[0]; 
		  fp[0]=0; 
		  for (int i=1; i<prices.length; i++) {
			 if (prices[i]< min)
				 min = prices[i];
			  fp[i]= max(prices[i]-min,fp[i-1]);
			 }
		  
		  int max= prices[prices.length-1]; 
		  lp[prices.length-1]=0;
		  for (int i=prices.length-2; i>=0; i--) {
			 if (prices[i]>max)
				 max = prices[i];
			  lp[i]= max(max-prices[i],lp[i+1]);
			  total = max(total,fp[i]+lp[i]);
			 }
		  return total;
		  }
	   
	  private static int max(int a, int b) {
	        return a>b?a:b;
	    }
	  public static void main(String agrs[]) {
	    	System.out.println(maxProfit(new int[] {1,3,2,7,6,13}));
	    }
		 
	  }

