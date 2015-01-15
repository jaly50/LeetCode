/*
 * LeetCode 61  Copy List with Random Pointer 
 * date: 2014/10/7
 * 完全自己写： 用hashmap store random; 复制一个新linkedlist
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 */
import java.util.HashMap;
import java.util.Map;


public class RandomPointer {
	
	 // O(1)time, o(1) space  参考别人C的程序试试  476ms
	//把相同的放到后一个~这样就不用Hash了 省了空间好棒！
	//缺点是会影响原来的linkedlist
	//时间并没有少多少，但是动了原来的list,这个很危险，还要摆回去。所以还是hashmap方法好
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode first = head, second = null;
		while (first !=null) {
			second = new RandomListNode(first.label);
			second.next =first.next;
			first.next = second;
			first = first.next.next;
		}
		first = head;
		while (first !=null) {
			second = first.next;
			if (first.random !=null)
			second.random = first.random.next;
			first = first.next.next;
		}
		first = head;
		if (head !=null )second = head.next; 
		head = second;
		while (first != null) {
			second = first.next;
			first.next = second.next;
			if (second.next !=null)
			second.next = second.next.next;
			first = first.next;
			second = second.next;
		}
		return head;
		
	}
	//Store by HashMap  自己写哒~  546ms 还是这个方法好
	 public RandomListNode copyRandomListByHash(RandomListNode head) {
	        RandomListNode sec=null, pre=null, head2 = null, cur = head;
	        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
	        // normal copy
	        while (cur != null) {
	            sec = new RandomListNode(cur.label);
	            if (pre != null) {
	                pre.next = sec;
	            }
	            else head2 = sec;
	            map.put(cur,sec);
	            pre = sec;
	            cur = cur.next;
	        }
	        // ramdompointer copy
	        sec = head2;
	        while (head != null) {
	            if (map.containsKey(head.random)) {
	                sec.random = map.get(head.random);
	            }
	            head = head.next;
	            sec = sec.next;
	        }
	        return head2;
	        
	        
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
