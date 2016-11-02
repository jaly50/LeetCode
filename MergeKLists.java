/*
 * LeetCode 82 Merge k Sorted Lists 
 * date: 2014/1017
 */
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

//参考别人的方法1： 每次merge 两个sort.. merge K次！
public class MergeKLists {
	//用归并排序试试吧，长度都相等的话。。应该是nlogn的复杂度
	 public ListNode mergeKLists(List<ListNode> lists) {
		 int len = lists.size();
		 if (len==0) return null;
		 if (len==1) return lists.get(0);
		 int mid = len/2;
		 ListNode left = mergeKLists(lists.subList(0, mid));
		 ListNode right =mergeKLists(lists.subList(mid, len));
		 return merge(left,right);
	 }
	private ListNode merge(ListNode left, ListNode right) {
		ListNode head = new ListNode(-1);
		ListNode node =head;
		while ((left!=null) || (right !=null)) {
			if (left == null) {
				node.next = right;
				break;
			}
			else if (right ==null) {
				node.next = left;
				break;
			}
			else if (left.val <= right.val) {
				node.next = left;
				left = left.next;
			}
			else {
				node.next =right;
				right =right.next;
			}
			node = node.next;
		}
		return head.next;
		
	}
	//自己写的答案超时了，最坏情况：n^2
	 public ListNode mergeKListsTLE(List<ListNode> lists) {
	     ListNode node=null, cur = node, pre = cur;
	     ListNode min = null;
	     boolean finished = false;
	     ListNode nodeI = null;
	     int index = -1;
	     while (true) {
	    	 min = null;
	    	 index = -1;
	    	 finished = true;
	    	 for (int i=0; i<lists.size(); i++) {
	    		 nodeI = lists.get(i);
	    		 if (nodeI!=null) {
	    			 finished = false;
	    			 if ((min==null) || (min.val > nodeI.val)) {
	    				 min = nodeI;
	    				 index = i;
	    				 
	    			 }
	    		 }
	    	 }
	            if (finished) break;
	      		cur = min; 
	      		lists.set(index,lists.get(index).next);
	      		if (pre== null) {
	      			node = cur;
	      	}
	      		else pre.next = cur;
	      		pre = cur;
	     }
	     return node;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeKLists mk = new MergeKLists();
		List<ListNode> lists = new ArrayList<ListNode>();
		ListNode node = new ListNode(3);
		node.next = new ListNode(7);
		lists.add(node);
		lists.add(new ListNode(2));
		ListNode head = mk.mergeKLists(lists);
		while (head !=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
