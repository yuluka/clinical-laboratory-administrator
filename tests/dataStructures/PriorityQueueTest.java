package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriorityQueueTest {

	private PriorityQueue<Integer, String> pQueue;
	
	//Test cases
	private void setupStage() {
		pQueue = null;
	}
	
	private void setupStage2() {
		pQueue = new PriorityQueue<>();
	}
	
	private void setupStage3() {
		pQueue = new PriorityQueue<>();
		
		pQueue.insert(1, "A");
		pQueue.insert(2, "B");
		pQueue.insert(1, "C");
		pQueue.insert(4, "D");
		pQueue.insert(3, "E");
	}
	
	//Tests
	@Test
	void nullTest() {
		setupStage();
		
		assertNull(pQueue);
	}
	
	@Test
	void creationTest() {
		setupStage2();
		
		assertNotNull(pQueue);
		assertEquals(0, pQueue.size());
	}

	@Test
	void insertTest() {
		setupStage3();
		
		pQueue.insert(2,"Ñ");
		assertTrue(pQueue.contains("Ñ"));
	}
	
	@Test
	void insertTest2() {
		setupStage3();
		
		pQueue.insert(9, "F");
		assertEquals(9, pQueue.maximum().getPriority());
		assertEquals("F", pQueue.maximum().getValue());
	}
	
	@Test
	void insertTest3() {
		setupStage3();
		
		pQueue.insert(0, "F");
		assertEquals(0, pQueue.getList().getBack().getValue().getPriority());
		assertEquals("F", pQueue.getList().getBack().getValue().getValue());
	}
	
	@Test
	//Tests that the maximum function doesn't remove the element with the max priority.
	void maximumTest() {
		setupStage3();
		
		PriorityElement<Integer, String> element  = pQueue.maximum();
		
		assertTrue(pQueue.contains(element));
	}
	
	@Test
	//Tests that the maximum function returns the element with the max priority.
	void maximumTest2() {
		setupStage2();
		
		pQueue.insert(1,"A");
		
		assertEquals(1,pQueue.maximum().getPriority());
		assertEquals("A", pQueue.maximum().getValue());
		
		pQueue.insert(999,"B");
		assertEquals(999,pQueue.maximum().getPriority());
		assertEquals("B", pQueue.maximum().getValue());		
	}
	
	@Test
	//Tests that the maximum function updates the element with the max priority when we insert an element with a higher priority.
	void maximumTest3() {
		setupStage3();
		
		PriorityElement<Integer, String> newElement  = new PriorityElement<>(9,"F");
		pQueue.insert(newElement.getPriority(), newElement.getValue());
		
		assertEquals(newElement.getPriority(),pQueue.maximum().getPriority());
		assertEquals(newElement.getValue(), pQueue.maximum().getValue());
	}
	
	@Test
	//Tests that the extractMax function returns the element with the max priority.
	void extractMaxTest() {
		setupStage2();
		
		pQueue.insert(1, "A");
		pQueue.insert(2, "B");
		
		PriorityElement<Integer, String> extractedElement = pQueue.extractMax();
		
		assertEquals(2,extractedElement.getPriority());
		assertEquals("B", extractedElement.getValue());
	}
	
	@Test
	//Tests that the extractMax function also removes the element with the max priority.
	void extractMaxTest2() {
		setupStage3();
		
		PriorityElement<Integer, String> maxElementInserted = pQueue.maximum();
		pQueue.extractMax();
		
		assertFalse(pQueue.contains(maxElementInserted));
	}
	
	@Test
	//Tests that the extractMax function updates updates the element with the max priority when we insert an element with a higher priority.
	void extractMaxTest3() {
		setupStage2();
		
		pQueue.insert(9, "F");
		
		PriorityElement<Integer, String> elementExtracted = pQueue.extractMax();
		
		assertEquals(9,elementExtracted.getPriority());
		assertEquals("F", elementExtracted.getValue());
		
		pQueue.insert(22, "G");
		
		elementExtracted = pQueue.extractMax();
		
		assertEquals(22,elementExtracted.getPriority());
		assertEquals("G", elementExtracted.getValue());
	}
	
	@Test
	//Tests that the increaseKey function increases the priority of a specified element to the new specified priority.
	void increaseKeyTest() throws Exception {
		setupStage3();
		
		pQueue.increaseKey(5, "A");
		
		assertEquals("A", pQueue.maximum().getValue());
		assertEquals(5, pQueue.maximum().getPriority());
	}
	
	@Test
	//Tests that the increaseKey function does nothing if the specified element doesn't exist in the queue.
	void increaseKeyTest2() throws Exception {
		setupStage3();
		
		pQueue.increaseKey(666, "Ñ");
		
		assertEquals("D", pQueue.maximum().getValue());
		assertEquals(4, pQueue.maximum().getPriority());
	}
	
	@Test
	/*Tests that the increaseKey function doesn't change the priority of the specified element if the
	specified priority (the new one) is lower than the current priority of that element.*/
	void increaseKeyTest3() throws Exception {
		setupStage3();
		
		//pQueue.increaseKey(3, "D");
		
		Exception exception = assertThrows(Exception.class, () ->{
			pQueue.increaseKey(3, "D");
		});
		
		assertEquals("You are trying to decrease the priority.", exception.getMessage());
		assertEquals("D", pQueue.maximum().getValue());
		assertEquals(4, pQueue.maximum().getPriority());
	}
}
