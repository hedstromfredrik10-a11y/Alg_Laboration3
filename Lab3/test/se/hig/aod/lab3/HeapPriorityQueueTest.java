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

	static final Integer[] INT_FIXTURE = {}; // TODO fill with random integers

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

	// TODO ADD MORE TESTS
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 *
	 */
}
