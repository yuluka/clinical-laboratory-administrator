package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriorityElementTest {

	private PriorityElement<Integer, String> pElement;
	
	//Test cases
	public void setupStage() {
		pElement = null;
	}
	
	public void setupStage2() {
		pElement = new PriorityElement<>(1,"A");
	}
	
	//Tests
	@Test
	void nullTest() {
		setupStage();
		
		assertNull(pElement);
	}
	
	@Test
	void creationTest() {
		setupStage2();
		
		assertNotNull(pElement);
		assertEquals(1, pElement.getPriority());
		assertEquals("A", pElement.getValue());
	}

}
