

/*
 * 328. Odd Even Linked List
 * Scarlett Chen
 * 10/17/2016 Mon 11:50
 * time: o(n), space: o(1)
 * Reference No.
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode first = odd, second = even;
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                odd.next = head;
                odd = odd.next;
            }
            else {
                even.next = head;
                even =even.next;
            }
            head = head.next;
            isOdd = !isOdd;
            
        }
        odd.next = second.next;
        // note: 尾巴清零，否则当odd为最后一个数时，会尾大不掉，无限循环
        even.next = null;
        return first.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
