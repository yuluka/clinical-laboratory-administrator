package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	private Stack<String> stack;
	
	//Test cases
	public void setupStage() {
		stack = null;
	}
	
	public void setupStage2() {
		stack = new Stack<>();
	}
	
	public void setupStage3() {
		stack = new Stack<>();
		
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
	}
	
	//Tests
	@Test
	void nullTest() {
		setupStage();
		
		assertNull(stack);
	}
	
	@Test
	void creationTest() {
		setupStage2();
		
		assertNotNull(stack);
	}
	
	@Test
	void creationTest2() {
		setupStage2();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void creationTest3() {
		setupStage2();
		
		stack.push("A");
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	void pushTest() {
		setupStage2();
		
		stack.push("A");
		
		assertTrue(stack.contains("A"));
		assertEquals("A", stack.top().getValue());
	}
	
	@Test
	void pushTest2() {
		setupStage2();
		
		stack.push("B");
		
		assertTrue(stack.contains("B"));
		assertEquals("B", stack.top().getValue());
	}
	
	@Test
	void pushTest3() {
		setupStage2();
		
		stack.push("C");
		
		assertTrue(stack.contains("C"));
		assertEquals("C", stack.top().getValue());		
	}
	
	@Test
	void popTest() {
		setupStage2();
		
		stack.push("A");
		stack.pop();
		
		assertFalse(stack.contains("A"));
	}
	
	@Test
	void popTest2() {
		setupStage3();
		
		assertEquals(stack.top(),stack.pop());
	}
	
	@Test
	void popTest3() {
		setupStage2();
		
		assertNull(stack.pop());
	}
	
	@Test
	void isEmptyTest() {
		setupStage2();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void isEmptyTest2() {
		setupStage2();
		
		stack.push("A");
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	void isEmptyTest3() {
		setupStage2();
		
		stack.push("B");
		stack.pop();
		
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void topTest() {
		setupStage2();
		
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		assertEquals("C", stack.top().getValue());
	}
	
	@Test
	void topTest2() {
		setupStage2();
		
		stack.push("A");
		stack.top();
		
		assertTrue(stack.contains("A"));
	}
	
	@Test
	void topTest3() {
		setupStage2();
		
		assertNull(stack.top());
	}
}
