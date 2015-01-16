import java.util.Stack;

/*
 * 写了好久，好多细节需要注意！
 * 基本思路是：dfs,每次找到包括当前点的最长单向路径，和以当前点为中心的最长路径=max
 * date:11/4/2014
 * LeetCode 106
 * YOU NEED TO DO IT AGAIN!!!
 */
public class MaxPathSum {
	int max;
    public int maxPathSum(TreeNode root) {
    	max = Integer.MIN_VALUE;
		 if (root==null) return 0;
        dfs(root);
        return max;
    }
	private int dfs(TreeNode root) {
		if (root.left==null && root.right==null) {
			max = Math.max(root.val, max);
			return root.val;
		}
		int left=Integer.MIN_VALUE, right=Integer.MIN_VALUE;
		int ans = root.val;
		if (root.left !=null) left = dfs(root.left);
		if (root.right !=null) right = dfs(root.right);
       ans = Math.max(Math.max(left, right)+root.val,ans);
       int temp= ans;
       if (root.left !=null && root.right!=null) temp = Math.max(ans, left+right+root.val);
        max = Math.max(temp, max);
 
	    return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TreeNode a = new TreeNode(5);
		 TreeNode b = new TreeNode(4);
		 TreeNode c = new TreeNode(8);
		 a.left = b;
		 a.right =c;
        b.left = new TreeNode(11);
        c.left = new TreeNode(13);
        c.right = new TreeNode(4);
        MaxPathSum ms = new MaxPathSum();
        System.out.println(ms.maxPathSum(a));
	}

}
