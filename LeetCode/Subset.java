/*
 * LeetCode 89 Subsets 
 * 又是典型的dfs...+记录路径。。蛮简单的
 * Given a set of distinct integers, S, return all possible subsets.
 * date:2014/10/20
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subset {
	 public List<List<Integer>> subsets(int[] S) {
	        List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        List<Integer> list = new ArrayList<Integer>();
	        ans.add(list);
	        if (S.length==0) return ans;
	        Arrays.sort(S);
	        for (int i=1; i<=S.length; i++) {
	        	// To get a list which size is i
	            list = new ArrayList<Integer>();
	            dfs(0,i,list,ans,S);
	        }
	        return ans;
	        
	    }
	    private void dfs(int index, int num, List<Integer> list, List<List<Integer>> ans, int[] s) {
	        if (num==0) {
	            ans.add(new ArrayList<Integer>(list));
	            return;
	        }
	        for (int i=index; i<s.length; i++) {
	        	//if ((i>index) && (s[i] ==s[i-1])) break;
	            list.add(s[i]);
	            dfs(i+1,num-1,list,ans,s);
	            list.remove((Integer)(s[i])); 
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subset s= new Subset();
		System.out.println(s.subsets(new int[]{}));
		System.out.println(s.subsets(new int[]{1}));
		System.out.println(s.subsets(new int[]{1,2}));
		System.out.println(s.subsets(new int[]{2,1,1}));

	}

}
