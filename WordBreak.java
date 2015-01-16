
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordBreak {
	static ArrayList<String> result;
	/*
	 * Leetcode 59 Word Break2
	 * Date :2014/10/07
	 * 难度系数 4颗星
	 * 参考了别人的答案
	 * 
	 */
	public static List<String> wordBreak(String s, Set<String> dict) {
		//用整型来缩小空间储存量
		List<List<Integer>> mark = new ArrayList<List<Integer>>(s.length());
		for (int i =0; i< s.length(); i++) {
			mark.add(i, new ArrayList<Integer>());
		}
		
		String str;
		for (int i=s.length(); i>0; i--) {
			if ((i<s.length()) && (mark.get(i).isEmpty())) continue;
			for (int j= i-1; j>=0; j--) {
				str = s.substring(j, i);
				
				if (dict.contains(str)) {
					mark.get(j).add(i);
				}
				//System.out.println(str+ " " + " " +j +" "+mark.get(j));
			}
		}
		result = new ArrayList<String>();
		collect(mark,0,s,"");
		return result;
	}
	private static void collect(List<List<Integer>> mark, int index, String s,
			String path) {
		
		String word;
		if (index == s.length() ) {
			path = path.trim();
			//System.out.println(path+" "+ index);
			result.add(path);
			return;
		}
		List<Integer> temp = mark.get(index);
		//System.out.println(index +" " +temp);
		for (int i=0; i<temp.size(); i++) {
			word = s.substring(index, temp.get(i));
			//System.out.println(word+" "+ i+ " to  "+ temp.get(i));
			collect(mark,temp.get(i),s,path+word+" ");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab";
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		System.out.println(wordBreak(s,set));
	}

	
	
	// dp method to solve, Time limted exceed
	public static List<String> wordBreak2(String s, Set<String> dict) {
		int len = s.length();
		if (len < 1) return null;
        boolean[] f = new boolean[len+1];
        Arrays.fill(f, false);
       // List<String> ans = new ArrayList<String>();
        f[0] = true; 
        String str;
         List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
         ArrayList<String> sublist, sublistJ = new ArrayList<String>();
        list.add(sublistJ);
        for (int i=1; i<=len; i++) {
        	list.add(new ArrayList<String>());
        	for (int j = 0; j< i; j ++) {
        		str = s.substring(j, i);
        		f[i] = f[j] && (dict.contains(str));
        		if (f[i]) {
        			sublist = list.get(i);
        			sublistJ = list.get(j);
        			for (int k=0; k<sublistJ.size(); k++) {
        				sublist.add(sublistJ.get(k)+" "+str);
        			}
        		}
        	}
        }
        sublist = list.get(len);
        for (int i =0; i<sublist.size(); i++) sublist.set(i, sublist.get(i).trim());
        return list.get(len);
        
        
    }	
	
	/*
	 * LeetCode 58 Word Break 
	 * date: 2014/10/06
	 * 参考了别人的思路！（但其实自己应该要会做才是！！！>.<
	 * 用动态规则做~想想 f[n]和 f[0-n-1]之间的关系！！
	 * 
	 */
	public static boolean wordBreak1(String s, Set<String> dict) {
		int len = s.length();
		if (len < 1) return false;
		if (dict.contains(s)) 
			return true;
        boolean[] f = new boolean[len+1];
        Arrays.fill(f, false);
        f[0] = true; 
        String str;
        for (int i=1; i<=len; i++) {
        	for (int j = 0; j< i; j ++) {
        		str = s.substring(j, i);
        		f[i] = f[j] && (dict.contains(str));
        		if (f[i]) break;
        	}
        	
        }
        return f[len];
    }
	
}
