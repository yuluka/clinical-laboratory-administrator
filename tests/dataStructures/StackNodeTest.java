package dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackNodeTest {

	private StackNode<String> stackElement;
	
	//Test cases
	public void setupStage() {
		stackElement = null;
	}
	
	public void setupStage2() {
		stackElement = new StackNode<>("A");
	}
	
	//Tests
	@Test
	void nullTest() {
		setupStage();
		
		assertNull(stackElement);
	}
	
	@Test
	void creationTest() {
		setupStage2();
		
		assertNotNull(stackElement);
	}

}
