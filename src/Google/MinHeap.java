package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MinHeap {
	int capacity;
	int size;
	int[] heap;

	public MinHeap(int capacity) {
		size = 0;
		this.capacity = capacity;
		heap = new int[capacity];
		Arrays.fill(heap, -1);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	private int getParent(int i) {
		return i - 1 / 2;
	}

	private int getLeftChild(int i) {
		return 2 * i + 1;
	}

	private int getRightChild(int i) {
		return 2 * i + 2;
	}

	public void insert(int x) {
		if (isFull()) {
			throw new NoSuchElementException("Overflow Exception");
		}
		heap[size++] = x;
		heapify(size - 1);
	}

	private void heapify(int child) {
		int temp = heap[child];
		while (child > 0 && temp < heap[getParent(child)]) {
			heap[child] = heap[getParent(child)];
			child = heap[getParent(child)];
		}
		heap[child] = temp;
	}

	public int getMin() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return heap[0];
	}

	public int delete(int i) {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		int key = heap[i];
		heap[i] = heap[size - 1];
		size--;
		heapifyDown(i);
		return key;
	}

	private void heapifyDown(int i) {
		int child;
		int temp = heap[i];
		while (getLeftChild(i) < size) {
			child = minChild(i);
			if (heap[child] < temp)
				heap[i] = heap[child];
			else
				break;
			i = child;
		}
		heap[i] = temp;
	}

	private void heapifyUp(int i) {
		int temp = heap[i];
		while (i > 0 && heap[getParent(i)] > temp) {
			heap[i] = heap[getParent(i)];
			i = getParent(i);
		}
		heap[i] = temp;
	}

	private int minChild(int i) {
		int left = getLeftChild(i);
		int right = getRightChild(i);
		return left < right ? left : right;
	}

	public void printHeap() {
		System.out.println(Arrays.toString(heap));
	}

}
