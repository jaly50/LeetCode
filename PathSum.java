import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 101 Path Sum & 102 Path Sum II
 * easy problem.不编码水平真的会下降>.<
 * recursive and depth-first-search
 * date:10/29/2014
 * Be careful fo how to remove index in ArrayList
 * 
 */
public class PathSum {
	List<List<Integer>> ans;
    List<Integer> path;
    //Path Sum II 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	ans = new ArrayList<List<Integer>>();
    	path = new ArrayList<Integer>();
    	dfs(root,sum);
    	return ans;
    	
    }
    public void dfs(TreeNode root, int sum) {
    	if (root==null) return;
    	sum -=root.val;
    	int index = path.size();
    	path.add(root.val);
    	if (root.left==null && root.right==null) {
    		if (sum==0) {
    			ans.add(new ArrayList<Integer>(path));
    		}
    		
    	}
    	else {
    		dfs(root.left,sum);
    		dfs(root.right,sum);
    	}
    	//Be careful which index you removed
    	// remove by index sometimes would be more accurate
    	path.remove(index);
    	
    	
    }
	 public boolean hasPathSum(TreeNode root, int sum) {
	        if (root==null) return false;
	        sum -=root.val;
	        // when it is a leaf
	        if (root.left ==null  && root.right== null)
	        	if (sum==0) return true;
	        	else return false;
	        else
	        return hasPathSum(root.left,sum) || hasPathSum(root.right, sum);
	        
	    }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathSum ps = new PathSum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(ps.pathSum(root, 3));
		

	}

}
