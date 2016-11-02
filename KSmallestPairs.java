/*
 * 373. Find K Pairs with Smallest Sums
 * Scarlett Chen
 * 11/1/2016 1:41 PM 
 * 最naive的思路就是： 列出所有的可能 n*m pairs, keep the first k. n*m*logK
 * 思路2： 对于secondary list,create another int[m] to match the current corresponding pos in the first array
 *      贪心， time: o(k*m), space(o(m)) 13ms
 * 思路3： time( kLogK),Using priority Queue, Build your own Class Pair 8ms
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
	
    class Pair implements Comparable<Pair>{
        int[] pair;
        // idx of first array
        int idx;
        long sum;
        Pair(int idx, int n1, int n2) {
            this.pair = new int[]{n1, n2};
            this.idx = idx;
            this.sum = (long)n1 + (long)n2;
        }
        public int compareTo(Pair that) {
            return Long.compare(this.sum, that.sum);
        }

    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums2.length;
        int n = nums1.length;
        List<int[]> res = new ArrayList<int[]>();
        if (k<=0 || m<=0 || n<=0) return res;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int h_b = Math.min(m-1, k);
        for (int i=0; i<=h_b; i++) pq.offer(new Pair(0, nums1[0], nums2[i]));
        while (k>0 && !pq.isEmpty()) {
            Pair minp = pq.poll();
            res.add(minp.pair);
            k--;
            int new_idx = minp.idx + 1;
            if (new_idx>=n) continue;
            pq.offer(new Pair(new_idx, nums1[new_idx], minp.pair[1]));
        }
        return res;
    }
	
	
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int m = nums2.length;
        int n = nums1.length;
        List<int[]> res = new ArrayList<int[]>();
        if (k<=0) return res;
        // record the current position which matches ele in nums2
        int[] matches = new int[m];
        //how many element do we traverse at most in the secondary array
        int h_b = Math.min(m-1, k);
        for (int a=0; a<k; a++) {
            int[] pair = new int[2];
            int min_sum=Integer.MAX_VALUE;
            int pos = -1;
            for (int b=0; b<h_b; b++) {
            	if (matches[b] >=n)  continue;
                int cur_sum = nums2[b] + nums1[matches[b]];
                if (cur_sum < min_sum) {
                    min_sum = cur_sum;
                    pos= b;
                }
            }
            // if we didn't find the next available
            if (pos == -1) return res;
            pair[0] = nums1[matches[pos]];
            pair[1] = nums2[pos];
            res.add(pair);
            matches[pos]++;
            
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
