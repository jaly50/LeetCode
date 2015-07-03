/*
 method: 1. sort, and get count : time (nlogn) space(o1)    7/2/2015 Thu 7:09 pm
         2. map:ele & count : time(o(n))  space(o(n))
         3. voting: time(o(n)) space(o(1))
         
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
    
    
    // Moore voting algorithm   time(o(n)) space(o(1))
        public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res= new ArrayList<Integer>();
        if (n<1) return res;
        int x=0, y=0, cx=0,cy=0;
        for (int i=0; i<nums.length; i++) {
           if (x==nums[i]) {
               cx+=1;
           }
           else if (y==nums[i]) {
               cy+=1;
           }
           else
           if (cx==0) {
               x=nums[i];
               cx =1;
           }
           else if (cy==0) {
               y = nums[i];
               cy=1;
           }
           else {
               cx--;
               cy--;
           }
        }
        cx =0; cy=0;
        for (int i:nums) {
            if (i==x) cx++;
            else if (i==y) cy++;
        }
        if (cx > nums.length/3) res.add(x);
        if (cy>nums.length/3) res.add(y);
        return res;
        
    }
}
