/*
 * 2014/9/13
 * Scarlett
 * LeetCode 28 Convert Sorted Array to Binary Search Tree 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class SortedArrayToBST {
	 public static TreeNode sortedArrayToBST(int[] num) {
		 TreeNode root = new TreeNode(0);
		 if (num.length < 1) return null;
		 else
			 insertBST(root,num,0,num.length-1);
		 return root;
	    }

	private static void insertBST(TreeNode root,int[] num, int low, int high) {
		// TODO Auto-generated method stub
		int mid;
		mid = low + (high - low)/2;
		root.val =num[mid];
		if (mid > low) {
			root.left =new TreeNode(0);
			insertBST(root.left,num,low, mid-1);
		}
			
		if (mid < high) {
			root.right =new TreeNode(0);
			insertBST(root.right,num,mid+1, high);
		}
	}
	public static void main(String args[]) {
		System.out.println(sortedArrayToBST(new int[]{1,2,3}));
	}
}
