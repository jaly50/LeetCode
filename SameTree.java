/**
 * @author Scarlett
 * @date 2014/8/31
 * Requirement: Given two binary trees, write a function to check if they are equal or not.
 *              Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *              
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
     if ((p==null) && (q == null)) 
       	 return true;
     else if ((p !=null) && (q != null)) {
    	 	if (p.val != q.val) return false;
    	 	if ((isSameTree(p.left,q.left)) && (isSameTree(p.right,q.right)))
    	 		return true;
     		}
     return false;
    }
    public static void main(String args[]){
    	TreeNode x = new TreeNode(3);
    	TreeNode y = new TreeNode(3);
    	y.left = new TreeNode(3);
    	x.left = new TreeNode(4);
    	System.out.println(isSameTree(x,y));
    	
    }
 }