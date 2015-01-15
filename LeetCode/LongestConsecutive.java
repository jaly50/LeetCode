/*
 * Leetcode 103 Longest Consecutive Sequence 
 * 10/29/2014
 * 找最长递增子数组。
 * Mark.不是自己的思路。
 * Time:3N
 */
import java.util.HashSet;
import java.util.Set;


public class LongestConsecutive {
	public static int longestConsecutive(int[] num) {
		int max=0;
	    Set<Integer> set = new HashSet<Integer>();
	    for (int i:num) {
	        set.add(i);
	    }
	    int x,count;
	   for (int i=0; i<num.length; i++) {
		   x = num[i];
		   count = 0;
		   while (set.contains(x)) {
			   set.remove(x++);
			   count++;
		   }
		   x=num[i];
		   while (set.contains(--x)) {
			   set.remove(x);
			   count++;
		   }
		   max = Math.max(max, count);
	        
	    }
	     return max;   
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] num = new int[]{1,0,-1};
     System.out.println(longestConsecutive(num));
	}

}
