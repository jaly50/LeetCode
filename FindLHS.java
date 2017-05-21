//594. Longest Harmonious Subsequence
/*
// leetcode-weekly-contest-33
//Scarlett 5/20/2017 My solution using sort, a better way would be using hashmap.
We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.
*/

public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n<1) return 0;
        int count =0, max=0, min = 0, next=0;
        for (int i=0; i<=n; i++) {
            if (i==n || (i>0 && nums[i] != nums[i-1])) {
                if (nums[i-1] == nums[min]+1) max = Math.max(max, i-min);
                 min = next;
                 next = i;
            }
        }
        return max;
    }
}
