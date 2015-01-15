/*
 * LeetCode 84  Remove Nth Node From End of List
 * easy
 * 做到一次过！棒棒的！
 * Time: o(2*n)
 * thought: 先确定list.size,然后remove 第 len-n的node
 */

/*
 * 参考到一个更好的思路！只需要o(n)!
 * 让 fast永远比slow快k步！！
 *  // let fast_pointer be n nodes ahead than slow_pointer
        while (n--) {
            fast = fast->next; 
        } 
        // move fast_pointer and slow_pointer in the same pace
        while (fast != NULL && fast->next != NULL) { 
            fast = fast->next;
            slow = slow->next;
        }
        // delete slow->next
        slow->next = slow->next->next;
 */
public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow, fast;
        if (head == null) return null;
        if (n==0) return head;
        if ((head.next == null) && (n>=1)) return null;
        ListNode cur = head;
        int num = 0;
        while (cur !=null) {
            cur = cur.next;
            num++;
        }
        num = num -n;
        if (num == 0) return head.next;
        cur = head;
        ListNode pre = null;
        while (num !=0) {
            pre = cur;
            cur = cur.next;
            num--;
        }
        remove(pre,cur);
        return head;
        
    }
    private void remove(ListNode pre, ListNode cur) {
       if (pre !=null) pre.next = cur.next;
        cur = null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
