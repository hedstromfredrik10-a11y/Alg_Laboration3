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
		// TODO
		return 0;
	}

	private int leftChild(int currentIndex) {
		// TODO
		return 0;
	}

	private int rightChild(int currentIndex) {
		// TODO
		return 0;
	}

	private void reHeapUp(int currentIndex) {
		// TODO Recursive implementation
	}

	private void reHeapDown(int currentIndex) {
		// TODO Recursive implementation
	}

	@Override
	public void enqueue(T newElement) {
		if (isFull()) {
			throw new PriorityQueueFullException("Heap is full!");
		}
		size++;
		// TODO Code that inserts the new element at the last position in the array
		// TODO reHeapUp for new node
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new PriorityQueueEmptyException("Cannot dequeue empty Queue!");
		} else {
			T dequeuedElement = heap[0];// the root element of the heap

			// TODO Code that moves the last element in the heap to the root of the heap
			size--;
			// TODO reHeapDown for the new root of the heap

			return dequeuedElement;
		}
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
