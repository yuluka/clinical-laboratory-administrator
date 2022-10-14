package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LaboratoryAdministratorTest {

	private LaboratoryAdministrator labAdministrator;
	
	//Test cases
	public void setupStage() {
		labAdministrator = null;
	}
	
	public void setupStage2() {
		labAdministrator = new LaboratoryAdministrator();
	}
	
	//Tests
	@Test
	void nullTest() {
		setupStage();
		
		assertNull(labAdministrator);	
	}
	
	@Test
	void creationTest() {
		setupStage2();
		
		assertNotNull(labAdministrator);	
	}
	
	@Test
	void creationTest2() {
		setupStage2();
		
		assertTrue(labAdministrator.addPatient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false,0));
	}
	
	@Test
	void creationTest3() {
		setupStage2();
		
		labAdministrator.addPatient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false,0);
		
		assertFalse(labAdministrator.addPatient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false,0));
	}
	
	@Test
	void searchTest() {
		setupStage2();
		
		labAdministrator.addPatient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false,0);
		
		assertEquals("Lucas", labAdministrator.searchPatient("1193211367").getName());
		assertNotNull(labAdministrator.searchPatient("1193211367"));
	}
}
