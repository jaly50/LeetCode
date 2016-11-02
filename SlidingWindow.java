/*
 * Scarlett Chen
 * 239. Sliding Window Maximum
 * Nov 1st, 2016 , Tue 8:54 PM
 * 最naive的方法： 每次有k个size 取最大值 ： n*k
 * 2. 维护一个递减序列的q, [5, 4, 3, 2, 1] ,如果后面出现大的，前面比它小的全部出列：要deque，因为前面后面都会出， 时间复杂度： o(n), 空间复杂度：k
 */
package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<Integer>();
        int n = nums.length;
        if (n<1 || k<1) return new int[0];
        int[] ans = new int[n-k+1];
    
         for (int i=0; i<n; i++) {

             //为了保持递减序列
             while (!dq.isEmpty() && dq.peekLast() < nums[i]) {
                 dq.pollLast();
             }
            // System.out.println(dq);
             if (dq.isEmpty() || nums[i] <= dq.peekLast()) {
                 dq.offer(nums[i]);
             }
             if (i >=k && nums[i-k] == dq.peek()) {
                 dq.poll();
             } 
             //System.out.println(dq);
             if (i-k+1 >=0)
                ans[i-k+1] = dq.peek();
         }
         return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindow sw = new SlidingWindow();
		sw.maxSlidingWindow(new int[]{5,1,3}, 2);

	}

}
