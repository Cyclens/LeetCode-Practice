import java.util.Hashtable;

public class LRUwDLinkedList {
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
	}

	private void add(DLinkedNode node) {
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	private void remove(DLinkedNode node) {
		DLinkedNode prev = node.prev;
		DLinkedNode next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	private void moveToHead(DLinkedNode node) {
		this.remove(node);
		this.add(node);
	}

	private DLinkedNode poptail() {
		DLinkedNode poped = tail.prev;
		this.remove(poped);
		return poped;
	}

	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUwDLinkedList(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		head.prev = null;

		tail = new DLinkedNode();
		tail.next = null;

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null)
			return -1;

		this.moveToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		if (node == null) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.value = value;
			newNode.key = key;
			this.cache.put(key, newNode);
			this.add(newNode);
			++count;

			if (count > capacity) {
				DLinkedNode tail = this.poptail();
				this.cache.remove(tail.key);
				--count;
			}
		} 
		else {
			node.value = value;
			this.moveToHead(node);
		}

	}

	public static void main(String args[]) {
		LRUwDLinkedList cache = new LRUwDLinkedList(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4

	}
}
