/*
 * LeetCode 136 Validate Binary Search Tree
 * Author: Scarlett
 * 这道题很容易陷入一个小陷阱，就是只测试是否root.left <root<root.right,但其实BST的要求是必须root.left的最右儿子也要小于root的值。
 * 所以一开始写了fail的版本。
 * 
 *  后来想着用DFS来做，每次记录前一个访问过的结点的值，必须小于当前结点。就可以满足BST的条件了。
 *  但是前一个访问过的点的值pre，在每个访问点上 从call左子树到call右子树之间是会变化的。
 *  因此又想了很久要怎么储存，进入了一些误区，还考虑过了应该是primitive or reference...要不要static...
 */


public class IsValidBST {
	Long pre;
	final double  pi = 3.14;
	public boolean isValidBST(TreeNode root) {
		if (root ==null) return true;
		double pi = 3.15;
		System.out.println(pi);
		boolean ans = true;
		pre = new Long((long)(Integer.MIN_VALUE) -1);
		return isValidNode(root, ans);

	}
	private boolean isValidNode(TreeNode root, boolean ans) {
		if (!ans) return ans;
		//System.out.println("At first, root= "+root.val+" pre= "+pre);
		if (root.left!=null) ans &= isValidNode(root.left,ans);
		if (pre < root.val) {
			pre =new Long(root.val);
		}
		else return false;
		//System.out.println("root= "+root.val+" pre= "+pre);
		if (root.right!=null) ans &= isValidNode(root.right,ans);
		//System.out.println("root= "+root.val+" pre= "+pre);
		return ans;
	}

	public boolean isValidBST_fail(TreeNode root) {
	        if (root == null) return true;
	        boolean ans = true;
	        if (root.left !=null) {
	            ans &= isValidBST(root.left);
	            ans &= root.val > root.left.val;
	        }
	        if (root.right !=null) {
	            ans &= isValidBST(root.right);
	            ans &= root.val < root.right.val;
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsValidBST is = new IsValidBST();
        TreeNode root = new TreeNode(3);
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        root.left = a;
        root.right = c;
        a.right = b;
        System.out.println(is.isValidBST(root));
	}

}
