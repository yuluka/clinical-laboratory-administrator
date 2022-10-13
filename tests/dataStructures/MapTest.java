package dataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MapTest {

	private Map<Integer,String> map;
	
	//Test cases
	public void setupStage() {
		map = null;
	}
	
	public void setupStage2() {
		map = new Map<Integer, String>(1,"A");
	}
	
	//Tests
	@Test
	void nullTest() {
		setupStage();
		
		assertNull(map);
	}
	
	@Test
	void creationTest() {
		setupStage2();
		
		assertNotNull(map);
		assertEquals(1,map.getKey());
		assertEquals("A",map.getValue());
	}
}
