/*
 * LeetCode 56  Reorder List 
 * Date: 2014/10/5
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 交了三次才对，为什么自己总会犯一些低级错误。
 * 比如从中间到最后逆转了，那 head当然是在最后一个啦。
 * 比如找到最后一个直到null,那当然还要pre才能是最后一个啦。
 */
public class ReOrder {
	public void reorderList(ListNode head) {
       if ((head == null) || (head.next == null)) return;
       ListNode slow = head, fast = head.next;
       while ((fast != null) &&  (fast.next != null)) {
    	   fast = fast.next.next;
    	   slow = slow.next;
       }
       ListNode cur = slow.next;
       slow.next = null;
       ListNode pre = null, temp = null;
       while (cur != null ) {
    	   temp = cur.next;
    	   cur.next = pre;
    	   pre = cur;
    	   cur = temp;
       }
       cur = pre;
       while ((head !=null) && (cur !=null)) {
    	   temp = cur.next;
    	   cur.next = head.next;
    	   head.next =cur;
    	   head  = cur.next;
    	   cur = temp;
       }
    }

}
