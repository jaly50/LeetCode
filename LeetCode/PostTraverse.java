import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * LeetCode 54 Binary Tree Postorder Traversal 
 * Date: 2014/10/4
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 树的后序遍历，递归好写。
 * 迭代法参考了标准答案~ 按左边儿子层层放入栈中，看看栈的最后一个有没有右孩子，有右孩子的就先重复第一步 ；没有的就加入list
 * 真的是超酷的想法！！我觉得我自己很难想到！！！
 */

public class PostTraverse {
    List<Integer> list;
    //这个方法也很好，这个方法不需要动原来的树。。。用flag标志 是右孩子要进栈(true)还是 root出栈（false）
    /*
    public static void postTraverse(BinaryTree root) {
    	  Stack s = new Stack();
    	  BinaryTree p = root;
    	  //pre标记最近出栈的节点，用于判断是否是p节点的右孩子，如果是的话，就可以访问p节点
    	  BinaryTree pre = p;
    	  //flag标记是出栈还是继续将左孩子进栈
    	  boolean flag = true;
    	  while(p!=null || !s.isEmpty()) {
    	   if(p!=null && flag) {
    	    s.push(p);
    	    p = p.lchild;
    	   }
    	   else {
    	    if(s.isEmpty()) return;
    	    p = (BinaryTree)s.peek();
    	    if(p.rchild != null && p.rchild!=pre) {
    	     p = p.rchild;
    	     flag = true;
    	    }
    	    else {
    	     p = (BinaryTree)s.pop();
    	     visit(p);
    	     flag = false;
    	     pre = p;
    	    }
    	   }
    	  }
    	 }
    */
	//Iterative way
	 public static List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> list  = new ArrayList<Integer>();
       Stack<TreeNode> st = new Stack<TreeNode>(); 
       TreeNode pre = null;
       while ((root !=null) || (!st.isEmpty())) {
    	   while (root!=null) {
    		   st.push(root);
    		   root =root.left;
    	   } 
    	   root = st.peek();
    	   if ((root.right != null)&& (pre != root.right)) {
    		   root = root.right;  
    	   } 
    	   else if (!st.isEmpty()) {
    		   pre = st.pop();
    		   list.add((Integer)pre.val);
    		   root = null;
    		   
    	   }
       }
        return list;
    }
// Recursive way
public List<Integer> postorderTraversal1(TreeNode root) {
    list  = new ArrayList<Integer>();
    add(root);
    return list;
}
public void add(TreeNode root) {
    if (root == null) return;
    if (root.left != null) add(root.left);
    if (root.right != null) add(root.right);
    list.add(root.val);
}
	public static void main(String args[]) {
		TreeNode x = new TreeNode(1);
		x.right = new TreeNode(2);
		System.out.println(postorderTraversal(x));
	}
}
