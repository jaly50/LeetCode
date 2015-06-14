//Find Minimum in Rotated Sorted Array II
//Scarlett Chen
// 6/14/2015 Sun 4:00 pm
public class Solution {
    public int findMin(int[] nums) {
        int lo=0, hi = nums.length-1;
        while (lo < hi) {
            int mid = lo +(hi - lo)/2;
            if (nums[mid] > nums[hi]) {
                lo = mid +1;
            }
            else if (nums[mid] < nums[hi]) {
                hi = mid;
            }
            // When many duplicated, the complexity would become on
            else hi--;
        }
       return nums[lo]; 
    }
}
