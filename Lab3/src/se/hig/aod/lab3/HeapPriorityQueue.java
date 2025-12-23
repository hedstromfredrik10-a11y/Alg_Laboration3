package se.hig.aod.lab3;

/**
 * A static heap implementation of a priority queue for elements of type T.
 * 
 * @author xxxx
 * 
 * @param <T> Data type of elements stored in the queue.
 */
public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T> {

	private T[] heap;
	private int size;
	private int maxSize;

	public HeapPriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		heap = (T[]) (new Comparable[maxSize]); // Create empty array of size maxSize
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Method that is specific for a static implementation of the heap, checks if
	 * the underlying array is full.
	 * 
	 * @return true if the underlying array is full
	 */
	public boolean isFull() {
		return size == maxSize;
	}

	@Override
	public int size() {
		return size;
	}

	private int parent(int currentIndex) {
		return (currentIndex - 1) / 2;
	}

	private int leftChild(int currentIndex) {
		return (currentIndex * 2) + 1;
	}

	private int rightChild(int currentIndex) {
		return (currentIndex * 2) + 2;
	}

	private void reHeapUp(int currentIndex) {
		if (currentIndex == 0) {
			return;
		}

		int parent = parent(currentIndex);

		if (heap[currentIndex].compareTo(heap[parent]) < 0) {
			return;
		}

		T parentElement = heap[parent];
		T childElement = heap[currentIndex];

		heap[currentIndex] = parentElement;
		heap[parent] = childElement;

		reHeapUp(parent);

	}

	private void reHeapDown(int currentIndex) {
		int largest = currentIndex;
		if (currentIndex >= size) {
			return;
		}

		if (leftChild(currentIndex) < size && heap[leftChild(currentIndex)].compareTo(heap[largest]) > 0) {
			largest = leftChild(currentIndex);

		}

		if (rightChild(currentIndex) < size
				&& heap[rightChild(currentIndex)].compareTo(heap[largest]) > 0) {
			largest = rightChild(currentIndex);

		}

		if (largest != currentIndex) {
			swap(currentIndex, largest);
			reHeapDown(largest);
		}
	}

	public void swap(int index, int largest) {
		T holdLargerElement = heap[largest];
		T holdIndex = heap[index];

		heap[largest] = holdIndex;
		heap[index] = holdLargerElement;

	}

	@Override
	public void enqueue(T newElement) {
		if (isFull()) {
			throw new PriorityQueueFullException("Heap is full!");
		}

		heap[size] = newElement;
		reHeapUp(size);
		size++;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new PriorityQueueEmptyException("Cannot dequeue empty Queue!");
		}
		T dequeuedElement = heap[0];
		heap[0] = heap[size - 1];
		size--;
		reHeapDown(0);
		return dequeuedElement;

	}

	@Override
	public T getFront() {
		if (isEmpty()) {
			throw new PriorityQueueEmptyException("Cannot get front of empty Queue!");
		} else {
			return heap[0];
		}
	}

	@Override
	public String toString() {
		String stringRepresentation = "";
		for (int i = 0; i < size; i++) {
			stringRepresentation = stringRepresentation + heap[i] + " ";
		}
		return stringRepresentation;
	}
}
