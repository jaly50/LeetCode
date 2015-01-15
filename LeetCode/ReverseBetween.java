/*
 * LeetCode 86  Reverse Linked List II 
 * Date: 2014/10/18
 * һ�ι������Ǹ�reverse K Group���
 * ���Ǳ߽磬��һ��һҪע��һ��
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
