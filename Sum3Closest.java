/*
 * LeetCode 67   3Sum Closest 
 * date: 2014/10/09
 * There is better solution:
 *   for (int i =0; i<num.length; i++ ){
 *     j= i+1;
 *     k= num.length -1;
 *     sum = num[i]+num[j] +num[k];
 *     if (sum > target) k--;
 *     else j++;
 *  可以用n^2的时间复杂度完成此题   
 *   
 */
import java.util.Arrays;


public class Sum3Closest {
	
    //自己写的o n^2 
    // 6/3/2015 Wed 7:50 pm
    
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if (n<3) return 0;
        Arrays.sort(nums);
        int ans = nums[0]+ nums[1]+ nums[2];
        int cur=0;
        for (int i =0; i< nums.length-2; i++) {
             int lo = i+1, hi = nums.length-1;
                while (lo < hi) {
                    cur = nums[i] + nums[lo] +nums[hi];
                    if (cur ==target) {
                        return target;
                    }
                    if (Math.abs(cur - target) < Math.abs(ans - target)) {
                        ans = cur;
                    }
                    if (cur < target) {
                        lo++;
                    }
                    else hi--;
                }
            
        }
        return ans;
        
    }

	
	
	/*
	 * My own solution: brace search
	 *  N^3  too slow
	 */
	 public static int threeSumClosest(int[] num, int target) {
		   Arrays.sort(num);
		      int  cur = num[0]+num[1]+num[2], best=cur;
		   for (int i=0; i< num.length-2; i++) {
			   if ((i>0) && (num[i]==num[i-1])) continue;
			   for (int j=i+1; j<num.length-1; j++) {
				   if ((j>i+1) && (num[j]==num[j-1])) continue;
				   for (int k=j+1; k<num.length; k++) {
					   if ((k>j+1) && (num[k]==num[k-1])) continue;   
					   cur = num[i]+num[j]+num[k];
					   if( Math.abs(cur - target) < Math.abs(best - target)) {
						   best = cur;
						    if (best == target) return best;
					   }
				   }
			   }
		   }
		   return best;  
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{0,0,0};
		 System.out.println(threeSumClosest(num,1));
		 System.out.println(threeSumClosest(new int[]{-2,0,1,1,2},1));

		 System.out.println(threeSumClosest(new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10},-52));
	}

}
