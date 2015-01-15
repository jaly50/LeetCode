/**
 * @author Scarlett
 * @date 2014/8/31
 * Requirement:Given a binary tree, find its maximum depth.
 * 				The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * depth of root = 1;
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        int len = 1;
        if (root == null) return 0;
    	if (root.left != null) 
    		len = maxDepth(root.left) + 1;
    	if (root.right !=null) 
    		len = max(len,maxDepth(root.right)+1);
    	return len;
    }
    private static int max(int len, int i) {
		return len>i?len:i;
	}
	public  static void main(String args[]) {
    	TreeNode tree = new TreeNode(5);
    	TreeNode left = new TreeNode(3);
    	tree.left = left;
    	tree.right = new TreeNode(1);
    	left.left = new TreeNode(2);
    	System.out.println(maxDepth(tree));
    }
}