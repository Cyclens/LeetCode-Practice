class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class ReverseLinkedList {

	public static ListNode reverse(ListNode head) {
		ListNode node = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = node;
			node = head;
			head = next;
		}
		return node;
	}
}
