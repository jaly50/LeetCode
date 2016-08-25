/*
 * Leetcode 41 Two Sum 
 * Date:2014/9/27
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 1. 最基本的思路是t= n^2 space= o(1), 对array中的任意两个进行配对
 *  2. t= o(nlogn), space = o(n) sort the array, then narrow down from sides to middle
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

}
