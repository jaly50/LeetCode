/*
* LeetCode Weekly Contest 31
* Scarlett Chen, Sat 7:43, Ranking 145
* 575. Distribute Candies
* Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.

Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too. 
The sister has three different kinds of candies. 
*/
public class Solution {
    public int distributeCandies(int[] candies) {
        int all = candies.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), all/2);
        
    }
}
