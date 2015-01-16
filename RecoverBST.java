/*
 * LeetCode 149  Recover Binary Search Tree 
 * @author: Scarlett Chen
 * @date: 12/24/2014 Wed 12:43 AM
 * 这道题告诉我们 要巧用全局变量！
 * 以及理解一下~两个互相交换的node,在dfs中，第一个一定是和它下一个对比才被发现错的！第二个和它上一个对比发现错的！---利用这个规律就很好写了！
 */
public class RecoverBST {
	    TreeNode prev;
	    TreeNode first;
	    TreeNode second;
	    public void recoverTree(TreeNode root) {
	       first = null;
	       second = null;
	        prev = new TreeNode(Integer.MIN_VALUE);
	        if (root==null) return;
	        dfs(root);
	        if (first!=null && second!=null) 
	        	swap(first,second);
	    }
	    private void dfs(TreeNode root) {
	        if (root.left!=null)  dfs(root.left);
	        if (prev.val > root.val) {
	            if (first == null) 
	            	first = prev;
	            second = root;
	        }

	        prev = root;
	       if (root.right!=null) dfs(root.right);
	    }
	    public void swap(TreeNode first, TreeNode second) {
	       int temp = first.val;
	       first.val = second.val;
	       second.val = temp;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       TreeNode head = new TreeNode(0);
       TreeNode b = new TreeNode(1);
       head.left = b;
       RecoverBST rb = new RecoverBST();
       rb.recoverTree(head);
	}

}
