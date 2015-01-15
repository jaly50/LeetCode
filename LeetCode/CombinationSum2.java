/*
 * LeetCode 77:  Combination Sum II
 * DATE:2014/10/14
 * 一如继往地好过。。和上一题只有一点点不同
 * 思路：dfs+路径记录 
 * 注意：思路清楚了以后，程序要注意精简和优化。
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum2 {
	 public List<List<Integer>> combinationSum2(int[] num, int target) {
		 List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        List<Integer> path;
	        Arrays.sort(num);
	        for (int i=0; i< num.length; i++) {
	        	if ((i>0) && (num[i] ==num[i-1])) continue; 
	        	path = new ArrayList<Integer>();
	        	if (target >=num[i]) search(i,num,target,path,ans);
	            }
	        return ans;
	    }
	 private void search(int index, int[] candidates, int target,
				List<Integer> path, List<List<Integer>> ans) {
			// To judge whether to add this index and continue search
			// Arrive the target
			if (target - candidates[index] == 0) {
				path.add(candidates[index]);
				ans.add(new ArrayList<Integer>(path));
				path.remove((Integer)candidates[index]);
				return;
			}
	            target = target - candidates[index];
	            path.add(candidates[index]);
	            for (int i=index+1; i<candidates.length && target >=candidates[i]; i++) {
	            	if ((i>index+1) && (candidates[i] ==candidates[i-1])) continue; 
	            	 search(i,candidates,target,path,ans);	
	            }
	            path.remove((Integer)candidates[index]);
	        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum2 s = new  CombinationSum2();
		 int[] c= new int[] {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		 System.out.println(s.combinationSum2(c,27));

	}

}
