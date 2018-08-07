import java.util.*;

public class LRUCache {
	private Map<Integer, DLNode> cache;
	DLNode head = null;
	DLNode tail = null;
	int capacity;

	public LRUCache(int capacity) {
		cache = new HashMap<Integer, DLNode>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			DLNode tgt = cache.get(key);
			int val = tgt.value;
			tgt.moveToHead();
			return val;
		} else
			return -1;

	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			DLNode tgt = cache.get(key);
			tgt.value = value;
			tgt.moveToHead();
		} else {
			if (capacity == 0)
				return;
			if (cache.size() == capacity) {
				cache.remove(head.key);
				head.remove();
			}
			DLNode newNode = new DLNode(key, value);
			newNode.add();
			cache.put(key, newNode);
		}
	}

	class DLNode {
		int key;
		int value;
		DLNode prev = null;
		DLNode next = null;

		public DLNode(int key, int value) {
			this.key = key;
			this.value = value;
		}

		private void add() {
			if (tail == null) {
				head = this;
				tail = this;
			} else {
				this.next = null;
				this.prev = tail;
				tail.next = this;
				tail = this;
			}
		}

		private void remove() {
			if (tail == this) {
				head = null;
				tail = null;
			} else {
				head = this.next;
				head.prev = null;
			}
		}

		private void moveToHead() {
			if (tail == this) return;
			else {
				if (this != head) {
					this.prev.next = this.next;
					this.next.prev = this.prev;
				}else {
					head = this.next;
				}
				this.add();
			}
		}
	}

	public static void main(String args[]) {
		LRUCache cache = new LRUCache(2 /* capacity */ );
		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1); // returns 1
		cache.put(3, 3); // evicts key 2
		cache.get(2); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		cache.get(1); // returns -1 (not found)
		cache.get(3); // returns 3
		cache.get(4); // returns 4

	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */