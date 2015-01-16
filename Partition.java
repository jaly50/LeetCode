/*
 * LeetCode 146  Partition List 
 * Author: Scarlett Chen
 * Time:12/14/2014 Sun 4:25 PM
 * 解法就是再建一个list放较大值，最后再拼接
 * 需要注意的就是把一个数挪给较大的list时，要让turn.next=null
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head==null || head.next==null) return head;
        ListNode second = new ListNode(-1);
        ListNode first= new ListNode(-1);
        ListNode secondHead = second;
        ListNode firstHead = first;
        first.next = head;
        while (first.next!=null) {
           if (first.next.val < x) {
              first = first.next;
           }
           else {
        	   ListNode turn = first.next;
               first.next = turn.next;
               turn.next = null;
               second.next = turn;
               second = second.next;
               
           }
           
        }
        first.next = secondHead.next;
        return firstHead.next;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partition p = new Partition();
		ListNode head =new ListNode(1);
		head.next = new ListNode(1);
		p.print(p.partition(head, 0));

	}
	private void print(ListNode head) {
		// TODO Auto-generated method stub
		while (head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

}
