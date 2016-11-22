//Scarlett Chen, Tue 10:12 AM, 11/22/2016
public class Solution {
    //直接贪心就可以啦
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        boolean smaller = true;
        for (int i=0; i<n-1; i++) {
           if ((smaller && nums[i] > nums[i+1]) || (!smaller && nums[i]<nums[i+1])) swap(nums, i, i+1);
           smaller = !smaller;
        }
        
    }
}
