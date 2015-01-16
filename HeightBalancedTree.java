/*
 * LeetCode 27 : Height Balanced Tree
 * Author Scarlett
 * date:2014/9/13
 * 
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class HeightBalancedTree {
    static int h1;
	static int h2;
    static boolean ans;
    private static boolean result(int height) {
        if ((h1==0) || (h1==height)) {
            h1 = height;
            return true;
          } 
          else 
            if (Math.abs(height - h1) ==1 ) {
                if (h2 ==0)  h2 = height;
                else if (h2 != height)  {
                    return false;
                }
            } 
            else 
               return false;
        return true;
    }
    private static void dfs(TreeNode root, int height) {
        if (!ans) return;
      if (root.left != null)  {
          dfs(root.left, height+1);
      } 
      else 
    	  ans = ans && result(height);
      if (root.right != null) {
          dfs(root.right,height+1);
      }
      else
    	   ans = ans && result(height);
    }
    public static boolean isBalanced(TreeNode root) {
    	ans = true;
    	h1 = 0;
    	h2 = 0;
        if (root != null ) dfs(root,1);
        return ans;
        
    }
    public static void main(String[] args) {
    	TreeNode x = new TreeNode(1);
    	TreeNode y = new TreeNode(2);
    	x.left = y;
    	y.left = new TreeNode(3);
    	y.right = new TreeNode(3);
    	System.out.println(isBalanced(x));
    }
}