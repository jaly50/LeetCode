/*
 * LeetCode  4Sum 
 * Date: 2014/10/09
 * 和3sum差不多…
 * 自己写的..
 * 还想出了防止重复算的优化方法(*￣︶￣)y
 * Time: o(n^3)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sum4 {
	public static List<List<Integer>>  fourSum(int[] num, int target) {
		 List<List<Integer>> list = new   ArrayList<List<Integer>>(); 
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		 //o(n)
		 for (int i=0; i<num.length; i++) {
			 if (map.containsKey(num[i]))
				 map.put(num[i], map.get(num[i])+1);
			 else map.put(num[i], 1);
		 }
		 //o(nlogn)
		 Arrays.sort(num);
		 
		 int two=0;
		 List<Integer> ans = new ArrayList<Integer>(4);
		 //O(n^3)
		 for (int i=0; i<num.length-3; i++) {
			 if ((i>0) && (num[i] == num[i-1])) continue;
			 for (int j=i+1; j<num.length-2; j++) {
				 if ((j>i+1) && (num[j] == num[j-1])) continue;
				 for (int k=j+1; k<num.length-1; k++ ) {
					 // prevent duplicate
					 if ((k>j+1) && (num[k] == num[k-1])) continue;
				      two = target-(num[i] + num[j]+ num[k]) ;
				 if (two <num[k]) continue;
				if (map.containsKey(two)) {
					//防止多算！ prevent one number be caculated more than one time
					if ((two == num[k]) && (num[k+1] != two)) continue;
					ans.add(num[i]); ans.add(num[j]); ans.add(num[k]); ans.add(two);
					list.add(ans);
					ans = new ArrayList<Integer>(4);
				}
			 }
			 }
		 }
		 return list;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{-1,0,1,2,-1,-4};
		 System.out.println(fourSum(num,0));
		 System.out.println(fourSum(new int[]{0,0,0,0,0}, 0));
		 System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
	}

}
