/*
 * Leetcode 44  Add Two Numbers 
 * Date: 2014/9/28
 * reference: false
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class AddtwoNumber {
	private int num;
	
	
    // 9/4/2016 Sunday t= o(n) space= o(n) ListNode
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumb = new ListNode(-1);
        ListNode head = dumb;
        // 可以用一个sum代替carry, value两个变量
        int carry=0, value=0;
        while (l1!=null || l2!=null) {
        //l1==null和下面的l1!=null 可以合并
        //l12==null和l2!=null可以合并
        if (l1 == null) value = l2.val+carry;
        else if(l2==null) value = l1.val+carry;
        else value = l1.val + l2.val + carry;
        carry = value/10;
        head.next = new ListNode(value % 10);
        head = head.next;
        if (l1!=null) 
          l1 = l1.next;
        if (l2!=null) 
          l2 = l2.next;
        }
        // The last carry value
        if (carry >0) head.next= new ListNode(carry);
        return dumb.next;
        
    }
    
    
   	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null, pre = null, begin = null;
        int number = 0, pos = 0;
        ListNode empty= new ListNode(0);
        if ((l1 == null) && (l2 == null)) return null;
        while ((l1 !=null)  || (l2 != null)) {
        		if (l1 ==null) {
        			l1 = empty;
        		}
        		else if (l2 == null) {
        			l2 = empty;
        		}
            number = (l1.val + l2.val + pos) % 10;
            pos = (l1.val + l2.val +pos) / 10;
            node = new ListNode(number);
            if (pre != null) {
            	pre.next = node;
            }
            else begin = node;
            pre = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (pos >0) {
            pre.next = new ListNode(pos);
        }
        return begin;
    }
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
