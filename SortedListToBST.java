/*
 * LeetCode 79  Convert Sorted List to Binary Search Tree
 * date: 2014/10/16
 * AVL树要insert, delete并不容易，要各种rotation
 * but insert an orded list into Binary search tree is easy.
 */
public class SortedListToBST {
	 public TreeNode sortedListToBST(ListNode head) {
	     ListNode slow, fast;
	     if (head == null) return null;
	     if (head.next ==null) return new TreeNode(head.val);
	     slow = head; fast = head.next;
	     ListNode pre=null; // pre is slow's pre
	     while (fast.next!=null) {
	    	 pre = slow;
	    	 slow = slow.next;
	    	 fast = fast.next;
	    	 if (fast.next !=null) fast = fast.next;
	     }
	     ListNode mid = slow;
	     ListNode right = mid.next;
	     if (pre !=null) pre.next = null;
	     TreeNode root =new TreeNode(mid.val);
	     if (pre!=null) root.left = sortedListToBST(head);
	     root.right = sortedListToBST(right);
	     
		 return root;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SortedListToBST  s = new  SortedListToBST();
		 ListNode head =new ListNode(1);
		 ListNode h2 =new ListNode(2);
		 ListNode h3 =new ListNode(3);
		 head.next = h2;
		 h2.next =h3;
		System.out.println( s.sortedListToBST(head).val);
	}

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */