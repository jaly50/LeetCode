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
	//Ҫд��bugfree�Ĵ����е���
	//�������׷��İ��� ���duplicate, �Լ�ĳ�����ظ�������
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
		// ÿ���������ݶ��������й���bug
		int[] num = new int[]{-1,0,1,2,-1,-4};
		 System.out.println(threeSum(num));
		 //Ԥ��duplicate,����Ҫ��i��ʼ����j(Ҳ���ǵڶ����֣�ҲҪ����
		 System.out.println(threeSum(new int[]{0,0,0,0}));
		 //����������map������������ڵ�һ���������Ѿ��ù������Ա��뱣֤�Ǹ�����������������
		 System.out.println(threeSum(new int[]{1,2,-2,-1}));
		 //0���������������������map��..�����������һ���Ļ������뱣֤����������3������������0
		 System.out.println(threeSum(new int[]{-1,0,1,0}));
		 //����list���뱣����������Ҫȷ�����������ȵڶ������ִ�
		 System.out.println(threeSum(new int[]{-2,0,1,1,2}));
	}

}
