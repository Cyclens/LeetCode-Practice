class SinglyNode {
	int val;
	SinglyNode next;

	public SinglyNode(int val) {
		this.val = val;
	}
}

class MyLinkedList {
	private SinglyNode head;
	static int len;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = null;
		len = 0;
	}

	public SinglyNode getNode(int index) {
		if (index > len - 1) index = len - 1;
		else if (index < 0) index = 0;
		SinglyNode node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		SinglyNode node = getNode(index);
		return node == null ? -1 : node.val;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		SinglyNode node = new SinglyNode(val);
		node.next = head;
		head = node;
		len++;
		return;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		if (head == null) {
			addAtHead(val);
			return;
		}
		SinglyNode prev = getNode(len - 1);
		SinglyNode node = new SinglyNode(val);
		prev.next = node;
		len++;
		return;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index <= 0) {
			addAtHead(val);
			return;
		} else if (index >= len) {
			addAtTail(val);
			return;
		} else {
			SinglyNode prev = getNode(index - 1);
			if (prev == null) {
				return;
			}
			SinglyNode node = new SinglyNode(val);
			SinglyNode next = prev.next;
			prev.next = node;
			node.next = next;
			len++;
			return;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		SinglyNode node = getNode(index);
		if (node == null) {
			return;
		}
		SinglyNode prev = getNode(index - 1);
		SinglyNode next = getNode(index + 1);
		if (prev == null) {
			head = next;
		}else {
			prev.next = next;
		}
		len--;
	}
}

public class Singly_Linked_List {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		ll.addAtHead(1);
		ll.addAtTail(3);
		ll.addAtIndex(1, 2);
		ll.get(1);
		ll.deleteAtIndex(1);
		ll.get(1);
	}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
