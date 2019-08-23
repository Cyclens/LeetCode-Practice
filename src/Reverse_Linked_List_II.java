
public class Reverse_Linked_List_II {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n || head == null) return head;
		ListNode dummyNode = new ListNode(0);
		ListNode dummy = dummyNode;
		ListNode curr = head;
		int count = n - m;
		while (m > 1) {
			dummy.next = curr;
			dummy = dummy.next;
			curr = curr.next;
			m--;
		}
		ListNode prev = null, next = null, cur = curr;
		
		while (count >= 0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count--;
		}
		dummy.next = prev;
		cur.next = next;
		return dummyNode.next;
	}

	
	
	public static void main (String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		int m = 1, n = 3;
		ListNode res1 = new Reverse_Linked_List_II().reverseBetween(head, m, n);
		//ListNode res2 = new Reverse_Linked_List_II().reverseBetween2(head, m, n);
		while (res1 != null) {
			System.out.println(res1.val);
			res1 = res1.next;
		}
	}
}
