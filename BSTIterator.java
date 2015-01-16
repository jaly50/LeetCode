import java.util.Stack;
/*
 * LeetCode Binary Search Tree Iterator 
 * @author : Scarlett Chen
 * @date: 1/14/2015
 * Using stack
 */

public class BSTIterator {
	Stack<TreeNode> stack; 
    public BSTIterator(TreeNode root) {
    	stack = new Stack<TreeNode>();
    	while (root!=null) {
    		stack.push(root);
    		root =root.left;
    	}
    	
    	
    }
    /** @return whether we have a next smallest number */
    //O(1)
    public boolean hasNext() {
    	return !stack.isEmpty();
    }
    /** @return the next smallest number */
    //O(h)
    public int next() {
    	TreeNode root = stack.pop();
    	TreeNode cur = root;
    	if (cur.right!=null) {
    		stack.push(cur.right);
    		cur =cur.right;
    		while (cur.left!=null) {
    			cur = cur.left;
    			stack.push(cur);
    		}
    			 
    	}
      return root.val;  
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		BSTIterator i = new BSTIterator(root);
		 while (i.hasNext()) System.out.println(i.next());
	}

}
