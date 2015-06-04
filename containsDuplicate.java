/*
Scarlett chen
6/4/2015 Thu 2:18 pm
Contains Duplicate
 o(n) time, o(n) space
*/


public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int ele: nums) {
            if (set.contains(ele)) {
                return true;
            }
            else {
                set.add(ele);
            }
        }
        return false;
        
    }
}
