/*
 * LeetCode 76:  Combination Sum
 * 不看题去死！！！
 * 人家说了全部都是正数！！！你为什么还在为负数的可能性捉急！！！？？！！
 * 知识点： dfs+ 路径记录
 * 并不难。。
 * date: 2014/10/14
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        List<Integer> path;
	        Arrays.sort(candidates);
	        for (int i=0; i< candidates.length; i++) {
	        	if ((i>0) && (candidates[i] ==candidates[i-1])) continue; 
	        	path = new ArrayList<Integer>();
	        	 search(i,candidates,target,path,ans);
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
			if (Math.abs(target -candidates[index]) <= Math.abs(target)) {
            target = target - candidates[index];
            path.add(candidates[index]);
            for (int i=index; i<candidates.length; i++) {
            	 search(i,candidates,target,path,ans);	
            }
            path.remove((Integer)candidates[index]);
			}
        }
		
	//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 CombinationSum s = new  CombinationSum();
		 int[] c= new int[] {2,3,6,7};
		 System.out.println(s.combinationSum(c,16));
	}

}
