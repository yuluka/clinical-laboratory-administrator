package model;

import java.util.*;

public class LaboratoryAdministrator {

	Collection<Patient> patients;
	Collection<Patient> generalProrityPatients;

	/**
	 * 
	 * @param name
	 * @param priority
	 * @param id
	 * @param age
	 * @param celNumber
	 * @param address
	 * @param unit
	 */
	public boolean addPatient(String name, boolean priority, String id, String age, String celNumber, String address, boolean unit) {
		// TODO - implement LaboratoryAdministrator.addPatient
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Patient searchPatient(String id) {
		// TODO - implement LaboratoryAdministrator.searchPatient
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param priorityValue
	 */
	public boolean assignPriority(String id, int priorityValue) {
		// TODO - implement LaboratoryAdministrator.assignPriority
		throw new UnsupportedOperationException();
	}

	public void sendPatient2Lab() {
		// TODO - implement LaboratoryAdministrator.sendPatient2Lab
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean egressPatient(String id) {
		// TODO - implement LaboratoryAdministrator.egressPatient
		throw new UnsupportedOperationException();
	}

	public void undo() {
		// TODO - implement LaboratoryAdministrator.undo
		throw new UnsupportedOperationException();
	}

	public Hashtable<Integer, Patient> getAllPatients() {
		// TODO - implement LaboratoryAdministrator.getAllPatients
		throw new UnsupportedOperationException();
	}

	public PriorityQueue<Patient> getHematologyPriorityPatients() {
		// TODO - implement LaboratoryAdministrator.getHematologyPriorityPatients
		throw new UnsupportedOperationException();
	}

	public Queue<Patient> getHematologyNonPriorityPatients() {
		// TODO - implement LaboratoryAdministrator.getHematologyNonPriorityPatients
		throw new UnsupportedOperationException();
	}

	public PriorityQueue<Patient> getGeneralPrioritypatients() {
		// TODO - implement LaboratoryAdministrator.getGeneralPrioritypatients
		throw new UnsupportedOperationException();
	}

	public Queue<Patient> getGeneralNonPriorityPatients() {
		// TODO - implement LaboratoryAdministrator.getGeneralNonPriorityPatients
		throw new UnsupportedOperationException();
	}

}