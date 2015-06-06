import java.util.Stack;

/*
 * Scarlett Chen
 * 6/5/2015 Fri 8:08 PM
 * Count Complete Tree Nodes
 * Time complexity o(logN * logN)
 */
public class Count {
	 public int countNodes(TreeNode root) {
		 if (root==null) return 0;
		    // root is 1
		    TreeNode left =root;
		    int leftValue = 1;
		    while (left!=null) {
		        left = left.left;
		        leftValue *=2;
		    }
		    // Get last level: leftMost and rightMost value
		    int rightValue = leftValue -1;
		    leftValue = leftValue/2;
		    //binary search
		    while (leftValue <= rightValue) {
		        int mid = leftValue + (rightValue - leftValue)/2;
		        if (exist(root,mid)) {
		            leftValue = mid+1;
		            if (!exist(root, leftValue))
		               return mid;
		        }
		        else {
		            rightValue = mid-1;
		        }
		    }
		    // It doesn't matter what to return, since it's been return in the "mid" above
		    return leftValue;
		    }
		    
		    public boolean exist(TreeNode root, int value) {
		        Stack<Integer> stack = new Stack<Integer>();
		        while (value!=1) {
		            stack.push(value%2);
		            value /=2;
		        }
		        TreeNode p = root;
		        while (!stack.isEmpty() && p!=null) {
		            int x = stack.pop();
		            if (x %2==1) {
		                p = p.right;
		            }
		            else p = p.left;
		        }
		        return p!=null;
		    }
		    class TreeNode {
		    	      int val;
		    	      TreeNode left;
		    	      TreeNode right;
		    	      TreeNode(int x) { val = x; }
		    	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
