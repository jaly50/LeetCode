/*
 * Leetcode 41 Two Sum 
 * Date:2014/9/27
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 1. 最基本的思路是t= n^2 space= o(1), 对array中的任意两个进行配对
 *  2. t= o(nlogn), space = o(n) sort the array, then narrow down from sides to middle
 * 3. hashmap to store everyelement in the list, check wther target - h.get(a[i]) is exsit in h. T=o(n), S=o(n)
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	 public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[]{0,0};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i=0; i< numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				return new int[]{map.get(target - numbers[i]),i+1};
			}
			map.put(numbers[i], i+1);
		}
		return result;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
	}
	
	// 9/4/2016 Sunday
	// t = o(n), S = o(n), HashMap stores (target-ele, indice(ele))
	// We can also store [ele, indice(ele)], then ask if map.containsKey(target-ele) then return( map.get(target-ele), i)
    public int[] twoSum(int[] nums, int target) {
        Map map = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) )
            	return new int[]{(int) map.get(nums[i]), i};
            else map.put(target-nums[i], i);
        }
        return new int[]{0,0};
       }

}
