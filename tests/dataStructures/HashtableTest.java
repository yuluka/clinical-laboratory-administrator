package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashtableTest {

	private Hashtable<Integer, String> table;
	
	//Test cases
	public void setupStage() {
		table = null;
	}

	public void setupStage2() {
		table = new Hashtable<Integer, String>();
	}
	
	public void setupStage3() {
		table = new Hashtable<Integer, String>();
		
		table.insert(1, "A");
		table.insert(2, "B");
		table.insert(3, "C");
		table.insert(4, "D");
		table.insert(5, "E");
	}
	
	
	//Tests
	@Test
	void nullTest() {
		setupStage();
		
		assertNull(table);
	}

	@Test
	void creationTest() {
		setupStage2();
		
		assertNotNull(table);
	}
	
	@Test
	void creationTest2() {
		setupStage2();
		
		assertEquals(0, table.size());
	}
	
	@Test
	void insertTest() {
		setupStage2();
		
		table.insert(1, "A");
		
		assertTrue(table.contains(1));
	}
	
	@Test
	void insertTest2() {
		setupStage2();
		
		table.insert(1, "A");
		
		assertEquals("A", table.search(1).getValue());
	}
	
	@Test
	void insertTest3() {
		setupStage2();
		
		table.insert(1, "A");
		
		assertEquals("A", table.search(1).getValue());
		
		table.insert(1, "B");
		
		assertNotEquals("A", table.search(1).getValue());
		assertEquals("B", table.search(1).getValue());	
	}
	
	@Test
	void insertTest4() {
		setupStage2();
		
		table.insert(1, "A");
		
		assertEquals(1, table.size());
	}
	
	@Test
	void searchTest() {
		setupStage3();
		
		assertEquals("A", table.search(1).getValue());
	}
	
	@Test
	void searchTest2() {
		setupStage3();
		
		assertEquals("C", table.search(3).getValue());
	}
	
	@Test
	void searchTest3() {
		setupStage3();
		
		assertNotEquals("D", table.search(5).getValue());
	}
	
	@Test
	void searchTest4() {
		setupStage3();
		
		assertNull(table.search(7));
	}
	
	@Test
	void deleteTest() {
		setupStage2();
		
		table.insert(1, "A");
		table.delete(1);
		
		assertFalse(table.contains(1));
	}
	
	@Test
	void deleteTest2() {
		setupStage2();
		
		assertEquals(0, table.size());

		table.insert(1, "A");
		table.delete(1);
		
		assertEquals(0, table.size());
	}
}
