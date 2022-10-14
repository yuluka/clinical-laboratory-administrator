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
	
	public void setupStage3() {
		labAdministrator = new LaboratoryAdministrator();
		
		labAdministrator.addPatient("Lucas", true, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", true, 4);
		labAdministrator.addPatient("Marcelo", true, "1390281361", "19", "", 
				"Cra 121A #47A-46", true, 2);
		labAdministrator.addPatient("Andrés", true, "1007281365", "23", "", 
				"", true, 3);
		/*labAdministrator.addPatient("Juan", false, "1196241360", "20", "", 
				"", true, 0);
		labAdministrator.addPatient("Ana", false, "1390281360", "18", "", 
				"", false, 0);
		labAdministrator.addPatient("Andrés", true, "1007281365", "34", "", 
				"", false, 1);*/
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
	void creationTest4() {
		setupStage2();
		
		Patient newPatient = new Patient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false,0);
		
		assertTrue(labAdministrator.addPatient(newPatient));
		assertNotNull(labAdministrator.searchPatient(newPatient.getId()));
	}
	
	@Test
	void creationTest5() {
		setupStage3();
		
		assertNotNull(labAdministrator.searchPatient("1193211367"));
		assertNotNull(labAdministrator.searchPatient("1390281361"));
		assertNotNull(labAdministrator.searchPatient("1007281365"));
	}
	
	@Test
	void searchTest() {
		setupStage2();
		
		labAdministrator.addPatient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false,0);
		
		assertEquals("Lucas", labAdministrator.searchPatient("1193211367").getName());
		assertNotNull(labAdministrator.searchPatient("1193211367"));
	}
	
	@Test
	void queuesTest() {
		setupStage2();
		
		Patient newPatient = new Patient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false,0);
		
		labAdministrator.addPatient(newPatient);
		
		assertTrue(labAdministrator.getGeneralNonPriorityPatients().contains(newPatient));
	}
	
	@Test
	void queuesTest2() {
		setupStage2();
		
		Patient newPatient = new Patient("Lucas", true, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false,0);
		
		labAdministrator.addPatient(newPatient);
		
		assertTrue(labAdministrator.getGeneralPriorityPatients().contains(newPatient));
	}
	
	@Test
	void queuesTest3() {
		setupStage2();
		
		Patient newPatient = new Patient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", true,0);
		
		labAdministrator.addPatient(newPatient);
		
		assertTrue(labAdministrator.getHematologyNonPriorityPatients().contains(newPatient));
	}
	
	@Test
	void queuesTest4() {
		setupStage2();
		
		Patient newPatient = new Patient("Lucas", true, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", true,0);
		
		labAdministrator.addPatient(newPatient);
		
		assertTrue(labAdministrator.getHematologyPriorityPatients().contains(newPatient));
	}
	
	@Test
	void queuesTest5() {
		setupStage3();
		
		assertEquals(3,labAdministrator.getHematologyPriorityPatients().size());
	}
	
	@Test
	void patientsInLabTest() {
		setupStage2();
		
		assertEquals(0,labAdministrator.getAllPatientsInLab().size());
	}
	
	@Test
	void patientsInLabTest2() {
		setupStage3();
		
		assertEquals(0,labAdministrator.getAllPatientsInLab().size());
	}
	
	@Test
	void addPatientTest() {
		setupStage2();
		
		labAdministrator.addPatient("Lucas", true, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", true, 4);
		labAdministrator.addPatient("Marcelo", true, "1390281361", "19", "", 
				"Cra 121A #47A-46", true, 2);
		labAdministrator.addPatient("Andrés", true, "1007281365", "23", "", 
				"", true, 3);
		
		assertTrue(labAdministrator.getHematologyPriorityPatients().
				contains(labAdministrator.searchPatient("1193211367")));
		assertTrue(labAdministrator.getHematologyPriorityPatients().
				contains(labAdministrator.searchPatient("1390281361")));
		assertTrue(labAdministrator.getHematologyPriorityPatients().
				contains(labAdministrator.searchPatient("1007281365")));
	}
	
	@Test
	void addPatientTest2() {
		setupStage2();
		
		labAdministrator.addPatient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", true, 0);
		labAdministrator.addPatient("Marcelo", false, "1390281361", "19", "", 
				"Cra 121A #47A-46", true, 0);
		labAdministrator.addPatient("Andrés", false, "1007281365", "23", "", 
				"", true, 0);
		
		assertTrue(labAdministrator.getHematologyNonPriorityPatients().
				contains(labAdministrator.searchPatient("1193211367")));
		assertTrue(labAdministrator.getHematologyNonPriorityPatients().
				contains(labAdministrator.searchPatient("1390281361")));
		assertTrue(labAdministrator.getHematologyNonPriorityPatients().
				contains(labAdministrator.searchPatient("1007281365")));
	}
	
	@Test
	void addPatientTest3() {
		setupStage2();
		
		labAdministrator.addPatient("Lucas", true, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false, 2);
		labAdministrator.addPatient("Marcelo", true, "1390281361", "19", "", 
				"Cra 121A #47A-46", false, 4);
		labAdministrator.addPatient("Andrés", true, "1007281365", "23", "", 
				"", false, 1);
		
		assertTrue(labAdministrator.getGeneralPriorityPatients().
				contains(labAdministrator.searchPatient("1193211367")));
		assertTrue(labAdministrator.getGeneralPriorityPatients().
				contains(labAdministrator.searchPatient("1390281361")));
		assertTrue(labAdministrator.getGeneralPriorityPatients().
				contains(labAdministrator.searchPatient("1007281365")));
	}

	@Test
	void addPatientTest4() {
		setupStage2();
		
		labAdministrator.addPatient("Lucas", false, "1193211367", "20", "3218061902", 
				"Cra 121A #47A-46", false, 2);
		labAdministrator.addPatient("Marcelo", false, "1390281361", "19", "", 
				"Cra 121A #47A-46", false, 4);
		labAdministrator.addPatient("Andrés", false, "1007281365", "23", "", 
				"", false, 1);
		
		assertTrue(labAdministrator.getGeneralNonPriorityPatients().
				contains(labAdministrator.searchPatient("1193211367")));
		assertTrue(labAdministrator.getGeneralNonPriorityPatients().
				contains(labAdministrator.searchPatient("1390281361")));
		assertTrue(labAdministrator.getGeneralNonPriorityPatients().
				contains(labAdministrator.searchPatient("1007281365")));
	}
}
