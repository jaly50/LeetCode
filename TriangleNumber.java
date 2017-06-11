//https://leetcode.com/contest/leetcode-weekly-contest-36/problems/valid-triangle-number/
/**
Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].
**/

public class Solution {
    // binary search
    public int get_smaller(int[] nums, int l, int h, int ele) {
        // To get the biggest number which num < ele
        if (ele > nums[h]) return h;
        if (ele <= nums[l]) return l-1;
        while (l<h) {
            int mid = l+(h-l+1)/2;
            if (ele > nums[mid]) {
                l = mid;
            }
            else h =mid-1;
        }
        return l;
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums); // nlogn
        int n = nums.length;
        int sum = 0;
        for (int i=0; i<nums.length - 2; i++) {
            for (int j=i+1; j<nums.length-1; j++) {
                int third = nums[i] + nums[j];
                int idx = get_smaller(nums, j+1, n-1, third);
                if (idx > j) {
                    sum+= idx-j;
                    //System.out.println(i+" "+j+" "+idx);
                }
            }
        }
        return sum;
        
    }
}
