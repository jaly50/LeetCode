
public class DetectCycle {
	  public static ListNode detectCycle(ListNode head) {
	        if ((head ==null) || (head.next == null)) return null;
	        ListNode slow = head, fast = head;
	        while (fast !=null)   {
	        	//fast.next shouldn't be in the while loop
	        	// to make sure fast is : last.next, but not last
	            slow = slow.next;
	            fast = fast.next;
	            if (fast !=null) fast = fast.next;
	            //when they meet
	            if (slow == fast)
	             break;
	        }
	        // no cycle
	        if (fast ==null) return null;
	        slow = head;
	        while (slow !=fast) {
	            slow = slow.next;
	            fast = fast.next;
	        }
	        return slow;
	      }
	 public static void main(String[] args) {
		 ListNode a = new ListNode(1);
		 ListNode b = new ListNode(2);
		 a.next = b;
		 b.next = a;
		 System.out.println(detectCycle(a));
	 }
}
