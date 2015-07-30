/**
 * Scarlett Chen 7/19/2015 Sun 6:17 PM - 7/30/2015 Thu 1:28 pm
 * 1. 题目要求每次取k个值的最大值。最笨的办法就是 每个window都扫描一遍，complexity: nums.length*k
 * 2. 把k个值放到heap里（heapsort+ array to store<position in array, position in heap>）,complexity: nums.length*logK 
 * 3. 用队列，que，始终保持队头元素最大（递减序列）。（入队大元素，则不断把前面比它小的删掉）。 complexity: nums.length; space: n
 * 
 * */
 
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> que = new LinkedList<Integer>();
        int len = nums.length;
        if (len<k || len==0) return new int[0];
        int[] window = new int[len-(k-1)];
        for (int i=0; i<len; i++) {
            if (!que.isEmpty() && (que.peekFirst() <= i-k)) {
                que.pollFirst();
            }
            //Delete value in the middle of the que, how could we know whether the head of the que is out of range?
            //---> Store position rather than ele in the que.
            while (!que.isEmpty() && nums[que.peekLast()]<nums[i]) {
                que.pollLast();
            }
            que.offerLast(i);
            if (i>=k-1) window[i-(k-1)]=nums[que.peekFirst()];
        }
        return window;
    }
}
