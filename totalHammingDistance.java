public class Solution {
    public int totalHammingDistance(int[] nums) {
        //0和1亦或才会为1，所以只要找每位digit上不同的个数就好了 time complexity: o(n), space: o(1)
        int count = 0;
        for (int i=0; i<32; i++) {
            int bit = 0;
            for (int j=0; j< nums.length; j++) {
                bit += (nums[j] >> i) & 1;
            }
            count += bit*(nums.length - bit);
        }
        return count;
        
    }
}
