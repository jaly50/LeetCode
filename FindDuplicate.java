/*
 * 9/27/2016 11:45 am -11:55am
 * Scarlett Chen
 * Cannot modify the array
 */
package leetcode;

public class FindDuplicate {
	// binary search, o(nlog(n))
	 public int findDuplicate1(int[] nums) {
	        if (nums == null || nums.length <=1) return 0;
	        int left = 0, right = nums.length -1;
	        while (left < right) {
	            int mid = left + (right -left)/2;
	            int count =0;
	             for (int i=0; i<nums.length; i++) {
	                 if (nums[i] <= mid) count++;
	             }
	             if (count > mid) right=mid;
	             else left = mid+1;
	        }
	        return right;
	    }

}
