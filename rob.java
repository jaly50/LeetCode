/*
5/22/2015
Scarlett chen
LeetCode 213 House Robber II 
两次house Robber,一次盗0号房不盗最后一号，一次盗1号房可盗最后一号。
这个方法可以再精简为o(1) space的，不过这个o(n)space的方法比较看得明白。
*/
public class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if (n<1) return 0;
         if (n==1) return nums[0];
         if (n==2) return Math.max(nums[0], nums[1]);
        int[] f = new int[n];
        Arrays.fill(f,0);
        //rob num[0]
        // we can not rob the last one
        for (int i=0; i<nums.length-1; i++) {
            f[i]+=nums[i];
            if (i>=2) {
                f[i] = Math.max(f[i], f[i-2]+nums[i]);
            }
            if (i>=3) {
                f[i] = Math.max(f[i], f[i-3]+nums[i]);
            }
        }
        int max=0;
        max =Math.max(f[n-2], f[n-3]);
        // don't rob num[0]
        Arrays.fill(f,0);

        for (int i=1; i<nums.length; i++) {
             f[i]+=nums[i];
            if (i>=2) {
                f[i] = Math.max(f[i], f[i-2]+nums[i]);
            }
            if (i>=3) {
                f[i] = Math.max(f[i], f[i-3]+nums[i]);
            }
        }
        max =Math.max(f[n-1], max);
        return Math.max(max, f[n-2]);
        
    }
}
