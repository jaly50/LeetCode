/*
 * LeetCode 83  Reverse Nodes in k-Group  --hard
 * ��Ȼ���Լ���constant memory���������ģ�but it costs me more than 1 hour
 * type: LinkedList, reverse
 * ע�⣺when reversing k nodes, don't forget put the original head node . next ---> last node(exclusive in the k nodes)
 * 
 */
/*
 * ˼·�
 *  1. ��single linkedlist���doubly list..������һ��reference�ͺã�ֻ��Ҫ�ؽ�һ��list..�൱��o(n)��memory? ������Ҫ��
 */
public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k<=1) return head;
		ListNode next;
		ListNode cur = new ListNode(-1);
		cur.next = head;
		head = cur;
		while (cur !=null) {
			// next����һ�� k nodes' begining befre REVERSING
			// after reverse, the next becomes the last one  of that k nodes
			next = cur.next;
			if (next == null) break;
			cur.next = reverse(next,k);
			if (cur.next.equals(next)) break;
			cur = next;
		}
		return head.next;
	    }
   /*
    * reverse node: from cur,inclusive, and k nodes
    * return first node after reverse
    */
	private ListNode reverse(ListNode cur, int k) {
		ListNode head = cur;
		// make sure there is at least k node
		// otherwise, don't deal with them
		int count = 0;
		while ((cur !=null) && (count < k)) {
			cur = cur.next;
			count++;
		}
		if (count !=k) return head;
		cur = head;
		ListNode pre = null, next;
		while (k!=0) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			k--;
		}
		head.next =cur;
		return pre;
	}
	public static void main(String[] agrs) {
		
	}
}
