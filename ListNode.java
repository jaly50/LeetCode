import java.util.HashSet;
import java.util.Set;


public class ListNode {
	int val;
	     ListNode next;
	      ListNode(int x) {
	         val = x;
	          next = null;
	      }
	      static void tostring(ListNode a) {
	    	  if (a!=null) {System.out.print("the List is: ");}
	    	while (a!=null) { System.out.print(a.val+" "); a= a.next; }  
	    	System.out.println();
	      }
	      
	      public static ListNode deleteDuplicates(ListNode head) {
	          Set<Integer> set = new HashSet<Integer>();
	          ListNode ans = head;
	          if (head==null) return head;
	          set.add(head.val);
	      	while (head.next!=null) {
	      		if (set.contains(head.next.val)) {
	      		    head = head.next;
	      		}
	      		else set.add(head.next.val);
	      		head = head.next;
	      		if (head==null) return ans;
	      	}
	      	return ans; 
	      }
	  public static void main(String[] args) {
		  ListNode a = new ListNode(1);
		  ListNode b = new ListNode(2);
		  ListNode c = new ListNode(3);
		  ListNode d = new ListNode(4);
		  a.next = b;
		  b.next =c;
		  c.next = d;
		  ListNode.tostring(a);
		  ListNode cur = a;
		  
		  
		  ReverseKGroup rk = new ReverseKGroup();
	        
	       // ListNode.tostring(rk.reverse(a,2));
	        ListNode.tostring(rk.reverseKGroup(a, 3));
		//while (a!=null) { System.out.println(a.val); a= a.next; }
	  }
}
