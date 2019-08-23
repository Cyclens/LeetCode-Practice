
public class Reversed_Linked_List {

	public ListNode reverseList(ListNode head) {

		ListNode curr = head, prev = null, next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	public static void main (String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode revHead = new Reversed_Linked_List().reverseList(head);
		while (revHead != null) {
			System.out.println(revHead.val);
			revHead = revHead.next;
		}
	}

}
