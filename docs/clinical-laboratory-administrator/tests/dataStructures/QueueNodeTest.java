package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueNodeTest {

	private QueueNode<String> element;
	
	//Test cases
	public void setupStage1() {
		element = null;
	}
	
	public void setupStage2() {
		element = new QueueNode<String>("A");
	}
	
	//Tests
	@Test
	void nullTest() {
		setupStage1();
		
		assertNull(element);
	}
	
	@Test
	void creationTest() {
		setupStage2();
		
		assertNotNull(element);
		assertEquals("A", element.getValue());
	}

}
