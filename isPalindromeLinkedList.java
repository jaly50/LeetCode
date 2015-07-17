/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * two pointer, one in the middile, reverse the latter half part; and check fist.next==send.next
 * Time o(n); space(o1)
 Scarlett chen 7/16/2015 Thu 9:21 pm
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode first =head;
        if (head==null || head.next==null) return true;
        ListNode second = first.next;
        while (second.next!=null) {
            first =first.next;
            second = second.next;
            if (second.next!=null) second = second.next;
        }
        // first is the last element in the first part
        second = reverse(first.next);
        first = head;
        while (first!=null && second!=null && first.val == second.val) {
            first = first.next;
            second = second.next;
        }
        if (first!=null && second!=null) return false;
        else return true;
        
    }
    public ListNode reverse(ListNode head) {
        ListNode pre= null;
        ListNode next  =null;
        while (head!=null) {
           next = head.next;
           head.next = pre;
           pre = head;
           head = next;
            
        }
        return pre;
    }
    
}
