public class Solution {
    public int minPatches(int[] nums, int n) {
        //自己完全没思路，discuss里面，好干净的代码。。我怎么想不到呢
        // For each element in the array, multiply 2 is where they can achieve at most
        // Patching Array 2/16/2017
        long miss=1;
        int count = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            }
            else {
                miss += miss;
                count ++;
            }
        }
        return count;
        
    }
}
