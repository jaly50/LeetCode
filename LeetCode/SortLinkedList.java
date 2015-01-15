/*
 * LeetCode 52 Sort List 
 * Date: 2014/10/1
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 用的 mergesort
 * 自己写的~
 * slow and fast node!
 */
public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if ((head==null) || (head.next ==null)) return head;
         ListNode slow= head, fast = head.next;
          while ((fast !=null) && (fast.next !=null)) {
              slow = slow.next;
              fast = fast.next.next;
          }
          ListNode left = head, middle;
          middle = slow.next;
          slow.next = null;
          left = sortList(left);
          middle = sortList(middle);
          return merge(left, middle);
       }
       public ListNode merge(ListNode left, ListNode right) {
    	   if ((left == null) && (right == null )) return null;
           ListNode semi = new ListNode(0);
           ListNode head = semi;
           while ((left!=null) || (right !=null)) {
               if (left ==null) {
                   head.next = right;
                    right = right.next;   
               }
                else if (right == null) {
                    head.next = left;
                    left = left.next;
                }
               else if (left.val < right.val) {
                   head.next = left;
                   left = left.next;
               }
               else {
                   head.next = right;
                   right =right.next;
               }
               head = head.next;
           }
           return semi.next;
           
       }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
