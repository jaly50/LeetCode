/*
 * Leetcode 118 Sum Root to Leaf Numbers
 * Easy algorithm
 * be careful: Add to the first or add to the tail? What if the root is null?
 */
public class SumNumbers {
	int sum;
	public int sumNumbers(TreeNode root) {
		sum = 0;
		StringBuffer path= new StringBuffer();
		if (root!=null) dfs(root,path);
		return sum;
	}
	private void dfs(TreeNode root, StringBuffer path) {
		// TODO Auto-generated method stub
		path.append(root.val);
		//when it is a leaf
		if (root.left==null && root.right==null) {
			sum = sum + Integer.parseInt(path.toString());
		}
		if (root.left!=null) dfs(root.left,path);
		if (root.right!=null) dfs(root.right,path);
		path.deleteCharAt(path.length()-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
	}

}
