import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Permutations {
	 static List<List<Integer>> result;
	public static List<List<Integer>> permute(int[] num) {
		 result = new ArrayList<List<Integer>>();
	        List<Integer> path = new ArrayList<Integer>();
	        boolean[] isUsed = new boolean[num.length];
	        Arrays.fill(isUsed, false);
	        dfs(num.length,isUsed,path,num);
	     return result;
	}
	//number: How many numbers need to be put in
	// path: the current permutation
	// used: which numbers have been used
	private static void dfs(int number, boolean[] isUsed, List<Integer> path, int[] num) {
		// TODO Auto-generated method stub
		if (number == 0) {
			//新的constuctor!!!!新知识get!!!
			//注意，如果直接add path,那么其实add的是path这个reference,不是其内容，所以如果path变了的话，result内容也会跟着变
			result.add(new ArrayList<Integer>(path));
			
			return;
		}
		for (int i =0 ; i< num.length; i++) {
          if (!isUsed[i]){
        	  isUsed[i] = true;
        	  path.add(num[i]);
        	  dfs(number-1, isUsed, path, num );
        	  isUsed[i] = false;
        	  path.remove((Integer)num[i]);
          }
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		System.out.println(permute(new int[]{1,2,3}));
     }

}
