public class Solution {
    public int search(int[] nums, int target) {
        // try to find the smallest one and the rotate point
        int lo=0, n = nums.length;
        int hi = n-1;
        int mid=0;
        //The smallest value is lo and hi, not mid; when mid==lo, if nums[mid] > nums[hi], lo = mid+1. the smallest is lo, not mid
        while (lo < hi) {
            mid = lo + (hi -lo) /2;
            if (nums[mid] > nums[hi])
             lo = mid +1;
             else hi = mid;
        }
        int min = lo;
        lo = 0; hi=n-1;
        while (lo <=hi) {
            mid = lo + (hi - lo)/2;
            int realmid = (mid + min) % n;
            if (nums[realmid] > target) {
                hi = mid -1;
            }
            else if (nums[realmid] == target)  return realmid;
            else lo = mid+1;
        }
        return -1;
    }
}
