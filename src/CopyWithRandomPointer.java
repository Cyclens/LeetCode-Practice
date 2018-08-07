class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}

public class CopyWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode iter = head, next;
		while (iter != null) {
			RandomListNode copy = new RandomListNode(iter.label);
			next = iter.next;
			iter.next = copy;
			copy.next = next;
			iter = next;
		}
		
		iter = head;
		while (iter != null) {
			if (iter.random != null) {
				iter.next.random = iter.random.next;
			}
			iter = iter.next.next;
		}
		
		iter = head;
		RandomListNode newHead = new RandomListNode(0);
		RandomListNode copy, copyHead = newHead;
		while (iter != null) {
			next = iter.next.next;
			copy = iter.next;
			copyHead.next = copy;
			copyHead = copy;
			iter.next = next;
			iter = next;
			
		}
		return newHead;
	}
}
