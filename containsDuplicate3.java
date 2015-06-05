//Scarlett Chen
// 6/4/2015 Thu 8:12 pm
// Contains Duplicate III 
public class Solution {
   // using bucket sort, time complexity o(n)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //the diff must be >=0
        // two distinct indices, so k must be at least 1
        if (k<1 || t<0) return false;
        // Because ele could be negative number....We begin from negative number, so the max could be 2^32-1
        // bucket and number
        Map<Long, Long> map = new HashMap<Long,Long>();
        for (int i=0; i<nums.length; i++) {
            // convert to long to prevent overflow
           long reNumber = (long)nums[i] - Integer.MIN_VALUE;
           // To prevent t might be 0
           // t +1. ..might overflow, so it should be long as well
            long bucket = reNumber /((long)t+1);
            if (map.containsKey(bucket) || (map.containsKey(bucket-1) && reNumber -map.get(bucket-1) <=t) ||
              (map.containsKey(bucket+1) && map.get(bucket+1) - reNumber <=t))
                return true;
            if (map.entrySet().size() >=k) {
                //convert int to long to prevent overflow before we cast to long
                long abucket = ((long)nums[i-k] -Integer.MIN_VALUE) /((long)t+1);
                map.remove(abucket);
            }
            map.put(bucket, reNumber);
        }
       return false; 
    }
}
