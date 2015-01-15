/*
 * author: Scarlett
 * Date:11/22/2014 Sat 1:26 AM
 * Thought: Simple deep search first, and backtracking.
 * LeetCode: 121 Permutations II 
 * Note:
 *    1. Be careful about some previous number's initial value, it should be a number which never occurs.
 *    2. Be careful about ArrayList.add, ArrayList.remove.  An element or Index? 
 *         If an element, does it represent a specific index?! WATCH OUT!!!!
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Permutations2 {
    int n;
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        this.n= num.length;
        ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if (n<1) {
            ans.add(path);
            return ans;
        }
        boolean[] visited = new boolean[n]; 
        Arrays.fill(visited,false);
        dfs(0,visited,num,path);
      // (List<Integer> temp:ans) {
     //	   System.out.println(temp);
      // }
       return ans;
        
    }
    private void dfs(int pos, boolean[] visited, int[] num,List<Integer> path) {
        if (pos == n) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        int pre = Integer.MIN_VALUE;
        for (int i=0; i<num.length; i++) 
          if (!visited[i]) {
            if (num[i]==pre) continue;
            visited[i] = true;
            path.add(num[i]);
               dfs(pos+1,visited,num,path);
               visited[i] = false;
               path.remove(pos);
               pre = num[i];
              
        } 
    }
    public static void main(String args[])  {
    	Permutations2 p = new Permutations2();
    	int[] num = new int[]{-1,2,-1,2,1,-1,2,1};
    	p.permuteUnique(num);
    }
}
