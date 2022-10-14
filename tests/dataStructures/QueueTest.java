package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	private Queue<String> queue;
	
	//Test cases
	public void setupStage1() {
		queue = null;
	}
	
	private void setupStage2() {
		queue = new Queue<>();
	}
	
	public void setupStage3() {
		queue = new Queue<>();
		
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");
	}
	
	//Tests
	@Test
	void nullTest() {
		setupStage1();
		
		assertNull(queue);
	}
	
	@Test
	void creationTest() {
		setupStage2();
		
		assertNotNull(queue);
	}
	
	@Test
	void creationTest2() {
		setupStage2();
		
		assertTrue(queue.isEmpty());
		assertEquals(0,queue.size());
	}

	@Test
	void creationTest3() {
		setupStage3();
		
		assertFalse(queue.isEmpty());
	}
	
	@Test
	void enqueueTest() {
		setupStage2();
		
		queue.enqueue("A");
		
		assertTrue(queue.contains("A"));
	}
	
	@Test
	void enqueueTest2() {
		setupStage2();
		
		queue.enqueue("A");
		assertEquals("A", queue.back().getValue());
	}
	
	@Test
	void enqueueTest3() {
		setupStage2();
		
		queue.enqueue("A");
		assertEquals("A", queue.front().getValue());
		
		queue.enqueue("B");
		assertEquals("B", queue.back().getValue());
		assertEquals("A", queue.front().getValue());
		
		queue.enqueue("C");
		assertEquals("C", queue.back().getValue());
		assertEquals("A", queue.front().getValue());
	}
	
	@Test
	void dequeueTest() {
		setupStage2();
		
		queue.enqueue("A");
		
		assertEquals(queue.front(),queue.dequeue());
	}
	
	@Test
	void dequeueTest2() {
		setupStage3();
		
		QueueNode<String> element = queue.dequeue();
		
		assertFalse(queue.contains(element.getValue()));
	}
	
	@Test
	void dequeueTest3() {
		setupStage2();
		
		assertNull(queue.dequeue());
	}
	
	@Test
	void isEmptyTest() {
		setupStage2();
		
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void isEmptyTest2() {
		setupStage2();
		
		queue.enqueue("A");
		
		assertFalse(queue.isEmpty());
	}
	
	@Test
	void isEmptyTest3() {
		setupStage2();
		
		queue.enqueue("A");
		queue.enqueue("B");
		queue.dequeue();
		queue.dequeue();
		
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void frontTest() {
		setupStage2();
		
		queue.enqueue("A");
		
		assertEquals("A", queue.front().getValue());
	}	
	
	@Test
	void frontTest2() {
		setupStage3();
		
		assertEquals("A", queue.front().getValue());
		
		queue.dequeue();
		assertEquals("B", queue.front().getValue());
		
		queue.dequeue();
		assertEquals("C", queue.front().getValue());
	}
	
	@Test
	void frontTest3() {
		setupStage3();
		
		QueueNode<String> element = queue.front();
		
		assertTrue(queue.contains(element.getValue()));
	}
	
	@Test
	void containsTest() {
		setupStage2();
		
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		
		assertTrue(queue.contains("A"));
		assertTrue(queue.contains("B"));
		assertTrue(queue.contains("C"));
		assertTrue(queue.contains("D"));
	}
}
