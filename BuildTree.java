
/*
 * 一次过。但是难免边写边改。。如果在白板上写，还需要注意多一些。
 * 不喜欢用长名字命名，但是短名字常常含义不清。唉。
 * LeetCode 127:Construct Binary Tree from Preorder and Inorder Traversal 
 * 思路：递归，二分
 * Date:11/29/2014 Sat 3:15 AM
 * 
 */
import java.util.Arrays;


public class BuildTree {
	/*
	 * 在leetcode上直接写一次过的〜
	 * 代码也比前一题漂亮多了！
	 * 题目是通过后序和中序遍历建树，和前一题基本一样。。
	 * LeetCode:Construct Binary Tree from Inorder and Postorder Traversal 
	 * Date:11/29/2014 Sat 3:37 AM
	 * Author:Scarlett
	 */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len ==0) return null;
        TreeNode root = new TreeNode(postorder[len-1]);
        if (len==1) return root;
        int indexOfRoot = 0;
        for (int i=0; i<len; i++) {
            if (inorder[i] ==postorder[len-1]) {
                indexOfRoot = i;
            }
        }
        int[] inorderLeft, inorderRight, postorderLeft, postorderRight;
        inorderLeft = Arrays.copyOfRange(inorder,0,indexOfRoot);
        inorderRight = Arrays.copyOfRange(inorder,indexOfRoot+1,len);
        postorderLeft = Arrays.copyOfRange(postorder,0,indexOfRoot);
        postorderRight = Arrays.copyOfRange(postorder,indexOfRoot,len-1);
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        return root;
        
    }
    public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
    	if (preorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length==1) return root;
        int i=0;
        int[] inorderLeft, inorderRight,preorderLeft,preorderRight;
        //To find the root at int[] inorder, to divide it to two part
        for (int in=0; in<inorder.length; in++) {
            if (inorder[in] == preorder[0]) 
            { i = in; break;}
        }   
        	  inorderLeft = Arrays.copyOfRange(inorder,0,i);
              int leftLen = inorderLeft.length;
              inorderRight = Arrays.copyOfRange(inorder, i+1, inorder.length);
             preorderLeft = Arrays.copyOfRange(preorder, 1,1+leftLen);
             preorderRight = Arrays.copyOfRange(preorder, i+1, preorder.length);
              root.left = buildTree(preorderLeft,inorderLeft);
              root.right = buildTree(preorderRight, inorderRight);
              return root;
         
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
