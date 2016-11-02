/*
 * 410. Split Array Largest Sum
 * Scarlett Chen 10/19/2016 4:11 PM
 * 两种基本做法：
 *   1. Binary search, 试试每个可能的ans,  max(ele) <= ans <= sums(array)
 *   2. DP, dp[len(nums)][m] 把array分成m份：  min(dp[i][j], max(dp[i_][j-1], sum(j) - sum(i_) (i_ < i)
 */
package leetcode;

public class Split {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        // get sum and maxv
        int maxv = 0;
        for (int ele: nums) {
            sum+=ele;
            maxv = Math.max(maxv, ele);
        }
        long ave = sum / m;
        long l = Math.max(ave, maxv);
        // using binary search to get the number between [minv, sum]
        long h = sum;
        long mid = 0;
        while (l<h) {
             mid = l + (h-l)/2;
            int count = 0;
            sum = 0;
            for (int ele: nums) {
                sum +=ele;
                if (sum > mid) {
                    count++;
                    sum = ele;
                }
            }
            // We didn't add the last one yet
            // it means we need to improve the target number
            if (count >=m) l=mid +1;
            else if (count < m-1) h=mid -1;
            else  {// there is m pieces, but we can actually get a lower number
            System.out.println("h: "+h + " mid: "+ mid);
             h = mid;
            }
        }
        return (int)mid;
        
    }
	
	
	// 用贪心写的，并不可以。当前最优解不等于全局最优解 =。= 虽然反例我举不出来
    public int splitArray1(int[] nums, int m) {
        long sum = 0;
        for (int ele: nums) sum+=ele;
        double ave = sum*1.0/m;
        sum = 0;
        int count = 0;
        long maxv = 0;
        for (int i=0; i<nums.length; i++) {
            if (count == m) {
                sum+=nums[i];
                continue;
            }
            long new_sum = sum + nums[i];
            if (Math.abs(new_sum - ave) < Math.abs(sum -ave)) {
                sum = new_sum;
            }
            else {
                count++;
                maxv = Math.max(maxv, sum);
                sum = nums[i];
            }
        
        }
        return (int)Math.max(sum, maxv);
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Split s = new Split();
		 int ans = s.splitArray(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6}, 20);
		 System.out.println(ans);
	}
	
	
}
