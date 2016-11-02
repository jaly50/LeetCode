// greedy 
//  get the poosible max index in this count; and update the nextMax begin from i in the range of countx
// Scarlett Chen
// 5:26 pm sun 6/7/2015
public class Solution {
    public int jump(int[] nums) {
        int max =0 , nextmax=0;
        int count=0;
        for (int i =0; i<=max && i< nums.length-1; i++) {
            nextmax = Math.max(nextmax, i+nums[i]);
            if (i==max) {
                max = nextmax;
                count++;
            }
        }
        if (max>=nums.length-1) {
            return count;
        }
        else return  -1;
        
    }
}
