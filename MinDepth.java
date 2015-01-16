import java.util.LinkedList;
import java.util.Queue;

// Two queue, one for depth, another for treenode
public class MinDepth {
	 public int minDepth(TreeNode root) {
	        Queue<TreeNode> que = new LinkedList<TreeNode>();
	        Queue<Integer> bue = new LinkedList<Integer>();
	        if (root==null) return 0;
	        int depth = 1;
	        que.add(root);
	        bue.add(1);
	        while (!que.isEmpty()) {
	        	root = que.poll();
	        	depth = bue.poll();
	            if (root.left==null && root.right == null) return depth;
	            if (root.left !=null) {
	            	que.add(root.left);
	            	bue.add(depth+1);
	            }
	            if (root.right !=null) {
	            	que.add(root.right);
	            	bue.add(depth+1);
	            }
	        }
	       return depth; 
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int depth = 7, la= 0;
        for (int i=1; i<depth; i*=2) {depth -=i; la+=1;}
	       System.out.println(la+1);
        
	}

}
