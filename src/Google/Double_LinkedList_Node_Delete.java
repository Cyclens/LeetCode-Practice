package Google;

class LinkedList {

	static Node head = null;

	class Node {

		int data;
		Node next, prev;

		Node(int d) {
			data = d;
			next = prev = null;
		}
	}
	
	void push(Node head_ref, int new_data) {
		Node new_node = new Node(new_data);
		new_node.prev = null;
		new_node.next = (head);
		if ((head) != null) 
			(head).prev = new_node;
		(head) = new_node;
	}

	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();

		list.push(head, 2);
		list.push(head, 4);
		list.push(head, 8);
		list.push(head, 10);

		System.out.println("Original Linked list ");
		list.printList(head);

		list.deleteNode(head, head); /* delete first node */

		list.deleteNode(head, head.next); /* delete middle node */

		list.deleteNode(head, head.next); /* delete last node */
		System.out.println("");

		System.out.println("Modified Linked List");
		list.printList(head);
	}
}

public class Double_LinkedList_Node_Delete {

	public void deleteNode(Node head_ref, Node del) {

		if (head == null || del == null) 
			return;
		if (head == del) 
			head = del.next;
		if (del.next != null) 
			del.next.prev = del.prev;
		if (del.prev != null) 
			del.prev.next = del.next;
		return;
	}
}
