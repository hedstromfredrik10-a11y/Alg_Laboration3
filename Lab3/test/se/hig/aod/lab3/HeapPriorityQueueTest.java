package se.hig.aod.lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * xxxxxx
 * 
 * @author xxxx
 */
class HeapPriorityQueueTest {

	static final Integer[] INT_FIXTURE = { 1, 2, 5, 4, 7, 9, 7, 4, 4, 6, 5, 9, 1, 12, 23, 1, 53 };

	HeapPriorityQueue<Integer> nonEmptyQueue;
	HeapPriorityQueue<Integer> emptyQueue;

	@BeforeEach
	void setUp() throws Exception {
		nonEmptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);
		emptyQueue = new HeapPriorityQueue<Integer>(INT_FIXTURE.length);

		for (int testData : INT_FIXTURE) {
			nonEmptyQueue.enqueue(testData);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		nonEmptyQueue = null;
		emptyQueue = null;
	}

	@Test
	void testClearNonEmptyQueue() {
		nonEmptyQueue.clear();
		assertTrue(nonEmptyQueue.isEmpty(), "intQueue borde vara tom efter en clear");
	}

	@Test
	void testClearEmptyQueue() {
		emptyQueue.clear();
		assertTrue(emptyQueue.isEmpty(), "emptyQueue should be empty after clear");
	}

	@Test
	void testIsEmptyOnNewQueue() {
		assertTrue(emptyQueue.isEmpty(), "Ny kö ska vara tom");
		assertEquals(0, emptyQueue.size(), "Ny kö ska ha storlek 0");
	}

	@Test
	void testSizeAfterEnqueue() {
		assertEquals(INT_FIXTURE.length, nonEmptyQueue.size(),
				"Storleken ska motsvara antal enqueue");
	}

	@Test
	void testGetFrontReturnsMaxElement() {
		assertEquals(53, nonEmptyQueue.getFront(),
				"Fronten ska vara största elementet i max-heap");
	}

	@Test
	void testGetFrontOnEmptyQueueThrowsException() {
		assertThrows(PriorityQueueEmptyException.class,
				() -> emptyQueue.getFront(),
				"getFront på tom kö ska kasta undantag");
	}

	@Test
	void testEnqueueSingleElement() {
		emptyQueue.enqueue(10);
		assertFalse(emptyQueue.isEmpty());
		assertEquals(1, emptyQueue.size());
		assertEquals(10, emptyQueue.getFront());
	}

	@Test
	void testEnqueueUntilFullThrowsException() {
		HeapPriorityQueue<Integer> smallQueue = new HeapPriorityQueue<>(1);
		smallQueue.enqueue(1);

		assertThrows(PriorityQueueFullException.class,
				() -> smallQueue.enqueue(2),
				"enqueue på full kö ska kasta undantag");
	}

	@Test
	void testDequeueReturnsMaxElement() {
		int max = nonEmptyQueue.dequeue();
		assertEquals(53, max, "dequeue ska returnera största elementet");
	}

	@Test
	void testDequeueReducesSize() {
		int sizeBefore = nonEmptyQueue.size();
		nonEmptyQueue.dequeue();
		assertEquals(sizeBefore - 1, nonEmptyQueue.size(),
				"dequeue ska minska storleken med 1");
	}

	@Test
	void testDequeueOnEmptyQueueThrowsException() {
		assertThrows(PriorityQueueEmptyException.class,
				() -> emptyQueue.dequeue(),
				"dequeue på tom kö ska kasta undantag");
	}

	@Test
	void testDequeueReturnsElementsInDescendingOrder() {
		int previous = Integer.MAX_VALUE;

		while (!nonEmptyQueue.isEmpty()) {
			int current = nonEmptyQueue.dequeue();
			assertTrue(current <= previous,
					"Heap-egenskapen bruten: " + current + " > " + previous);
			previous = current;
		}
	}

	@Test
	void testClearAndReuseQueue() {
		nonEmptyQueue.clear();
		assertTrue(nonEmptyQueue.isEmpty());

		nonEmptyQueue.enqueue(42);
		assertEquals(42, nonEmptyQueue.getFront());
	}

}
