import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 31  Symmetric Tree 
 * author:Jiali Chen
 * date:2014/9/16
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class SymmetricTree {
	static ArrayList tree;
	static boolean answer;
	
	 public static boolean isSymmetric(TreeNode root) {
	        if (root == null) return true;
	        // the recursion method
	        //return check(root.left,root.right);
	 
	        // The iterative method
	        TreeNode x,y;
	        ArrayList<TreeNode> l = new ArrayList<TreeNode>(); 
	        ArrayList<TreeNode> r = new ArrayList<TreeNode>(); 
	        l.add(root.left);
	        r.add(root.right);
	        while ((!l.isEmpty()) && (!r.isEmpty())) {
	        	x = l.remove(0);
	        	y = r.remove(0); 
	        	if ((x ==null) && (y == null)) continue;
	        	if ((x==null) || (y == null)) return false;
	        	if (x.val != y.val) return false;
	        	
	        	l.add(x.left);
	        	l.add(x.right);
	        	r.add(y.right);
	        	r.add(y.left);
	        }
	        if ((!l.isEmpty()) || (!r.isEmpty())) return false; 
	        return true;
	        
	    }
// Easy recursion *****
	private static boolean check(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if ((left ==null) && (right == null)) return true;
		 if ((left == null) || (right == null)) return false;
		 if (left.val != right.val) return false;
		 return (check(left.left, right.right) && check(left.right, right.left));
	}

	private static void rightSide(TreeNode root) {
		if (root == null) return; 
		if (!answer) return;
		 if (root.right != null) rightSide(root.right);

		 if (!equal((TreeNode)tree.get(0),root)) {
			 answer = false;
		 }
		 else tree.remove(0);
		 if (root.left != null) rightSide(root.left);
	}



	private static boolean equal(TreeNode temp, TreeNode root) {
		// TODO Auto-generated method stub
		if (temp.val != root.val) return false;
		if (((temp.left ==null)^(root.left == null))) return false; 
		if (((temp.right ==null)^(root.right == null))) return false; 
		return (temp.left.val == root.left.val) && (temp.right.val == root.right.val);
	}

	private static void leftSide(TreeNode root) {
		 if (root.left != null) leftSide(root.left);
		 tree.add(root);
		 if (root.right != null) leftSide(root.right);
	}
	 public static void main(String[] args) {
		    System.out.println(grayCode(2));
	    	TreeNode x = new TreeNode(1);
	    	TreeNode y = new TreeNode(2);
	    	x.left = y;
	    	//y.left = new TreeNode(3);
	    	TreeNode z = new TreeNode(3);
	    	x.right = z;
	    	//System.out.println(y==z);
	    	ArrayList<TreeNode> t = new ArrayList<TreeNode>(); 
	    	t.add(null);
	    	System.out.println(t.get(0));
	    	System.out.println(isSymmetric(x));
	    }
	private static char[] grayCode(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
