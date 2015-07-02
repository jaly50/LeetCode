import java.util.HashMap;
import java.util.Map;
/*
Methods:
   1. sort and take the median: o(1) space, o(nlogn) time
   2. map to keep each counts of ele: o(n) space, o(n) time
   3. majority voting algorithm: o(1) space, o(n) time

*/

public class MajorityElement {
	//majority voting algorithm: o(1) space, o(n) time
     public int majorityElement(int[] nums) {
        int n = nums.length;
        // assume the array is non-empty
        int ele = nums[0];
        int count = 1;
        for (int i=1; i<n; i++) {
            if (count==0) {
                ele = nums[i];
                
            }
            if (nums[i]==ele) count++;
            else count--;
        }
        return ele;
        
    }
    public int majorityElement(int[] num) {
        int n = num.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int ele:num) {
            if (map.containsKey(ele)) map.put(ele,map.get(ele)+1);
            else map.put(ele,1);
            if (map.get(ele) > n/2) return ele;
        }

       return num[0];        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
