import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * LeetCode 54 Binary Tree Postorder Traversal 
 * Date: 2014/10/4
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * ���ĺ���������ݹ��д��
 * �������ο��˱�׼��~ ����߶��Ӳ�����ջ�У�����ջ�����һ����û���Һ��ӣ����Һ��ӵľ����ظ���һ�� ��û�еľͼ���list
 * ����ǳ�����뷨�����Ҿ������Լ������뵽������
 */

public class PostTraverse {
    List<Integer> list;
    //�������Ҳ�ܺã������������Ҫ��ԭ��������������flag��־ ���Һ���Ҫ��ջ(true)���� root��ջ��false��
    /*
    public static void postTraverse(BinaryTree root) {
    	  Stack s = new Stack();
    	  BinaryTree p = root;
    	  //pre��������ջ�Ľڵ㣬�����ж��Ƿ���p�ڵ���Һ��ӣ�����ǵĻ����Ϳ��Է���p�ڵ�
    	  BinaryTree pre = p;
    	  //flag����ǳ�ջ���Ǽ��������ӽ�ջ
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
