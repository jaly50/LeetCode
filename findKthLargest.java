/*
  Scarlett Chen
  6/3/2015 Wed 11:02 PM
  Find Kth Largest
  PriorityQueue 
  nlogk

*/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int ele: nums) {
        // add every one
            pq.offer(ele);
            if (pq.size()>k) {
            // the head pop out, the smallest one
                pq.poll();
            }
        }
        // smallest one
        return (int)pq.peek();
        
        
    }
}
