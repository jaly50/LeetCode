/*
 * Scarlett chen
 * Mon 10:11 PM 10/31/2016
 * Note: 1 ≤ k ≤ n ≤ 10^9.
 */
package LeetCode;

import java.util.Currency;

public class FindKthNumber {
	//先用最naive的方法解，模拟
    public int findKthNumber(int n, int k) {
    	int count = 1, cur=1;
    	while (count < k) {
    	// 1 > 10
    	if (cur * 10 <= n) {
    		cur = cur * 10;
    	}
    	else
    	 if (cur + 1 <= n)
    	{
    		cur = cur + 1;
    		// 29 -> 3 -> 30
    		while (cur % 10 ==0) cur= cur/10;
    	}
    	 else {
    		 // if n = 101, 101-> 11
    		 cur = cur/10 + 1;
    	 }
		
    	count++;
    	System.out.println("count "+count+ " cur: "+ cur+" ");
    	
    	}
    	return cur;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindKthNumber fn = new FindKthNumber();
		fn.findKthNumber(10000, 500);

	}

}
