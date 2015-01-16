import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * LeetCode 68 Binary Tree Level Order Traversal II 
 * ������򵥵�
 * ��queue��¼���ӽڵ㣬 ��arraylist��β�Ϳ�ʼ�ӣ�����insertʱ�临�Ӷ���o(n)�� ���ﲻ��
 * (*�����)y �����Ҿ���linkedList,�̳�list�����й��ܣ��ɹ�ʵ�����o(1)�ĸ��Ӷȣ������ģ�
 */
public class LevelOrderBottom {
	 public static List<List<Integer>> levelOrderBottom(TreeNode root) {
	     Queue<TreeNode> st = new LinkedList<TreeNode>(); 
	    // List<List<Integer>> list = new ArrayList<List<Integer>>();
	     List<List<Integer>> list = new LinkedList<List<Integer>>();
	     List<Integer> tree = new ArrayList<Integer>(1);
	     int cur=1,next=0, count =1; 
	     if (root !=null) st.add(root);
	     else return list;
	     while (!st.isEmpty()) {
	         root = st.poll();
	         tree.add(root.val);
	         cur--;
	         if (root.left !=null) {
	             st.add(root.left);
	             next++;
	         }
	         if (root.right !=null) {
	             st.add(root.right);
	             next++;
	         }
	         if (cur == 0) {
	             cur = next;
	             next = 0;
	             if (count%2==0) Collections.reverse(tree);
	             list.add(0,tree);
	             tree = new ArrayList<Integer>(cur);
	             count++;
	         }
	     }
	     return list;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
