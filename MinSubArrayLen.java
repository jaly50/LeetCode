public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //right is excluded
         int left =0, right =0;
         if (s==0 || nums==null ||nums.length==0) return 0;
         
         int total =0, minLen = 0;
         for (int i=0; i<nums.length; i++) {
             total+= nums[i];
             right++;
             while (total >=s) {
               if (minLen!=0) minLen = Math.min(minLen, right-left); 
               else minLen = right-left;
                total -=nums[left++];
             }
             
         }
         return minLen;
         
         
        
    }
}
