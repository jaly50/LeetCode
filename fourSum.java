/*
o n^3 without extra space
 Scarlett Chen
 6/3/2015
 4Sum Wed 8:01PM



*/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        if (n<4) return res;
        Arrays.sort(nums);
        int cur=0;
        for (int i =0; i< nums.length-3; i++) {
            if (i==0 || nums[i] != nums[i-1]) {
                for (int j = i+1;  j< nums.length-2; j++) {
                    if (j == i+1 || nums[j] != nums[j-1]) {
                        int lo = j+1, hi = nums.length-1;
                            while (lo < hi) {
                                cur = nums[i] + nums[j] + nums[lo] +nums[hi];
                                if (cur ==target) {
                                    res.add(Arrays.asList(nums[i] , nums[j] , nums[lo] , nums[hi]));
                                    while (lo < n-1 && nums[lo]==nums[lo+1]) lo++;
                                    while (hi >0 && nums[hi]== nums[hi-1]) hi--;
                                    lo++; hi--;
                                }
                                else if (cur < target) {
                                    lo++;
                                }
                                else hi--;
                            }
                    }
                }
                }
        }
        return res;
        
    }
}
