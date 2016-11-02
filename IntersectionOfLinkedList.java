/*
 * LeetCode 153 
 * Scarlett Chen
 * @date : 12/27/2014
 */
public class IntersectionOfLinkedList {
	   public  static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	       //Firstly, to check the length distance of the two list
	       int k = 0;
	       ListNode first = headA, second = headB;
	       while (headA!=null && headB!=null) {
	           headA = headA.next;
	           headB = headB.next;
	       }
	       // make the first is shorter than the second
	       ListNode temp = headB==null? headA:headB;
	       if (headB==null && headA!=null) {
	           ListNode swap = first;
	           first = second;
	           second =first;
	       }
	      while (temp!=null) {
	                k++;
	                temp = temp.next;
	            }
	      //B walk K distance first
	      while (k>0) {
	          second = second.next;
	          k--;
	      }
	      while (first!=second) {
	          if (first==null || second==null) return null;
	          first = first.next;
	          second = second.next;
	      }
	      return first;  
	        
	    }
	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode headB = null;
		ListNode.tostring(getIntersectionNode(headA,headB));

	}

}
