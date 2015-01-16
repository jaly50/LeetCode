/*
 * LeetCode 65  3Sum 
 * Date: 2014/10/8
 * Time: o(n^2)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Sum3 {
	//要写出bugfree的代码有点难
	//这里容易犯的包括 造成duplicate, 以及某个数重复利用了
	//
	 public static List<List<Integer>> threeSum(int[] num) {
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
		 List<Integer> ans = new ArrayList<Integer>(3);
		 //O(n^2)
		 for (int i=0; i<num.length-2; i++) {
			 if ((i>0) && (num[i] == num[i-1])) continue;
			 for (int j=i+1; j<num.length-1; j++) {
				 if ((j>i+1) && (num[j] == num[j-1])) continue;
				 two = -(num[i] + num[j]) ;
				 if (two <num[j]) continue;
				if (map.containsKey(two)) {
					if ((two == num[j]) && (num[j+1] != two)) continue;
					//if ((two == num[i]) && (map.get(two)==1)) continue;
					//if ((two == num[j]) && (map.get(two)==1)) continue;
					//if ((two ==num[j]) &&  (two == num[i]) && (map.get(two) <3)) continue;
					ans.add(num[i]); ans.add(num[j]); ans.add(two);
					list.add(ans);
					ans = new ArrayList<Integer>(3);
				}
			 }
		 }
		 return list;
	    }
	public static void main(String[] args) {
		// 每个测试数据都是我曾有过的bug
		int[] num = new int[]{-1,0,1,2,-1,-4};
		 System.out.println(threeSum(num));
		 //预防duplicate,不仅要从i开始，从j(也就是第二数字）也要设置
		 System.out.println(threeSum(new int[]{0,0,0,0}));
		 //第三个数由map中提出，可能在第一二个数中已经用过，所以必须保证那个数至个有两个才行
		 System.out.println(threeSum(new int[]{1,2,-2,-1}));
		 //0是特殊情况：第三个数在map中..如果三个数都一样的话，必须保证该数至少有3个。仅适用于0
		 System.out.println(threeSum(new int[]{-1,0,1,0}));
		 //数字list必须保持升序，所以要确定第三个数比第二个数字大
		 System.out.println(threeSum(new int[]{-2,0,1,1,2}));
	}

}
