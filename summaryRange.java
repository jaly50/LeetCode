/*
 7/2/2015 Thu 2:12 PM
 Summary Range
 @ author : Scarlett Chen
*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        boolean dire = false;
        int n = nums.length;
        if (n<1) return res;
        String path = ""+nums[0];
        for (int i=1; i<n; i++) {
            if (nums[i] == nums[i-1]+1) {
                if (! dire) {
                    dire = true;
                    path +="->";
                }
                if (i == n-1) path +=nums[i];
            
            }
            else {
               if (i>1 && dire) path +=nums[i-1];
               res.add(path);
               path = ""+nums[i];
               dire = false;
            }
            
        }
        res.add(path);
        return res;
    }
}
