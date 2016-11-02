/*
Scarlett Chen
Rotate Array  
Sun 4:32 pm 6/7/2015
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k<0) k = len +k;
        if (k==0) return;
        reverse(nums, 0, len-k);
        reverse(nums, len-k, len);
        reverse(nums,0, len);
        
    }
    public void reverse(int[] nums, int start, int end) {
        int mid = start + (end - start)/2;
        for (int i=start, j=end-1; i<j; i++, j--) {
            nums[i] ^=nums[j];
            nums[j] ^= nums[i];
            nums[i] ^=nums[j];
        }
    }
}
