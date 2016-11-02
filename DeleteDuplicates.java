/*
 * Leetcode 108
 * Date: 11/4/2014
 * 一点点小错误，差不多算一次过吧。。简单题〜
 */
public class DeleteDuplicates {
	 public ListNode deleteDuplicates(ListNode head) {
	        ListNode cur = head;
	        ListNode mark=null;
	        ListNode pre = new ListNode(-3241);
	        pre.next = head;
	        head= pre;
	        while (cur !=null) {
	        	// Forgot the precondition
	            if (mark!=null && mark.val == cur.val) {
	                pre.next = cur.next;
	            }
	            else
	            if (cur.next!=null && cur.val==cur.next.val) {
	               mark = cur; 
	               pre.next = cur.next;
	            }
	            else {
	                pre = cur;
	            }
	            cur = cur.next;
	        }
	        return head.next;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
