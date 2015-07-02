/*
 method: 1. sort, and get count : time (nlogn) space(o1)    7/2/2015 Thu 7:09 pm
*/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res= new ArrayList<Integer>();
        if (n<1) return res;
        Arrays.sort(nums);
        int ele =0, count=1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==ele && i>0) {
                if (count > n/3) continue;
                count++;
               
            }
            else {
                ele = nums[i];
                count=1;
            }
             if (count >n/3)  res.add(ele);
        }
        return res;
        
    }
}
