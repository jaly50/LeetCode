/*
 * LeetCode 80 Combination
 * 最经典最直接最简单的深搜： 组合
 * date: 2014/10/16
 * 学了一个新method:list的逆序： collections.reverse(list);
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Combination {
	 public List<List<Integer>> combine(int n, int k) {
	        List<Integer> path = new ArrayList<Integer>();
	        List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        if (k<=n) dfs(n,k,path, ans);
	       
	       return ans; 
	    }
	    private void dfs(int n, int k, List<Integer> path, List<List<Integer>> ans) {
	        if (k==0) {
	        	List<Integer> temp = new ArrayList<Integer>(path);
	        	Collections.reverse(temp);
	            ans.add(temp);
	            return;
	        }
	         for (int i=n; i>0; i--) {
	            path.add(i);
	            dfs(i-1,k-1,path,ans);
	            path.remove((Integer)i);
	        }
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combination c = new   Combination();
		System.out.println(c.combine(4, 2));
	}

}
