class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Reverse_Nodes_in_k_Group {

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) {
			curr = curr.next;
			count++;
		}
		if (count == k) {
			curr = reverseKGroup(curr, k);
			if (curr == null)
				System.out.println("null");
			else
				System.out.println(curr.val);
			while (count-- > 0) {
				ListNode tmp = head.next;
				head.next = curr;
				curr = head;
				head = tmp;
			}
			head = curr;
		}
		return head;
	}
	
	public ListNode reverseKGroup2(ListNode head, int k) {
		if (head == null || head.next == null || k < 2) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tail = dummy, prev = dummy, tmp;
		int count;
		while (true) {
			count = k;
			while (count-- > 0 && tail != null) {
				tail = tail.next;
			}
			if (tail == null) break;
			head = prev.next;
			while (prev.next != tail) {
				tmp = prev.next;
				prev.next = tmp.next;
				tmp.next = tail.next;
				tail.next = tmp;
			}
			tail = head;
			prev = head;
		}
		return dummy.next;
	}
	
	public static void main (String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		new Reverse_Nodes_in_k_Group().reverseKGroup(head, 2);
	}
}
