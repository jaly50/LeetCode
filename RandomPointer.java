/*
 * LeetCode 61  Copy List with Random Pointer 
 * date: 2014/10/7
 * ��ȫ�Լ�д�� ��hashmap store random; ����һ����linkedlist
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 */
import java.util.HashMap;
import java.util.Map;


public class RandomPointer {
	
	 // O(1)time, o(1) space  �ο�����C�ĳ�������  476ms
	//����ͬ�ķŵ���һ��~�����Ͳ���Hash�� ʡ�˿ռ�ð���
	//ȱ���ǻ�Ӱ��ԭ����linkedlist
	//ʱ�䲢û���ٶ��٣����Ƕ���ԭ����list,�����Σ�գ���Ҫ�ڻ�ȥ�����Ի���hashmap������
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
	//Store by HashMap  �Լ�д��~  546ms �������������
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
