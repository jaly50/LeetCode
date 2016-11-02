/*
 * LeetCode 86  Reverse Linked List II 
 * Date: 2014/10/18
 * 一次过！和那个reverse K Group差不多
 * 就是边界，加一减一要注意一下
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 */
public class ReverseBetween {
	 public ListNode reverseBetween(ListNode head, int m, int n) {
	        int count=0;
	        int len = n-m+1;
	        if (len==1) return head;
	        if (m==1) return reverse(head,len);
	        ListNode cur = head;
	        ListNode pre = null;
	        while (cur !=null) {
	            pre = cur;
	            cur = cur.next;
	            count++;
	            if (count == m-1) break;
	            
	        }
	        // reverse part
	        pre.next = reverse(cur,len);
	        return head;
	        
	    }
	    	private ListNode reverse(ListNode cur, int k) {
			ListNode head = cur;
			ListNode pre = null, next;
			while (k!=0) {
				next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
				k--;
			}
			head.next =cur;
			return pre;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
