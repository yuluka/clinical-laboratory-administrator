package model;

import dataStructures.Hashtable;
import dataStructures.PriorityQueue;
import dataStructures.Queue;

public class LaboratoryAdministrator {

	Hashtable<Integer,Patient> patients;
	PriorityQueue<Integer,Patient> generalProrityPatients;
	Queue<Patient> generalNonPriorityPatients;
	PriorityQueue<Integer, Patient> hematologyPriorityPatients;
	Queue<Patient> hematologyNonPriorityPatients;

	public LaboratoryAdministrator() {
		this.patients = new Hashtable<>();
		this.generalProrityPatients = new PriorityQueue<>();
		this.generalNonPriorityPatients = new Queue<>();
		this.hematologyPriorityPatients = new PriorityQueue<>();
		this.hematologyNonPriorityPatients = new Queue<>();
	}

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
	public boolean addPatient(String name, boolean priority, String id, String age, 
			String celNumber, String address, boolean unit, int priorityValue) {
		if(searchPatient(id) != null) {
			return false;
		}
		
		Patient newPatient = new Patient(name, priority, id, age, celNumber, address, 
				unit, priorityValue);
		
		patients.insert(patients.size()+1, newPatient);
		
		return true;
	}

	/**
	 * 
	 * @param id
	 */
	public Patient searchPatient(String id) {
		for (int i = 0; i < patients.size(); i++) {
			if(patients.get(i).getValue().getId().equalsIgnoreCase(id)) {
				return patients.get(i).getValue();
			}
		}
		
		return null;
	}

	/**
	 * 
	 * @param id
	 * @param priorityValue
	 */
	public boolean assignPriority(String id, int priorityValue) {
		throw new UnsupportedOperationException();
	}

	public void sendPatient2Lab() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean egressPatient(String id) {
		throw new UnsupportedOperationException();
	}

	public void undo() {
		throw new UnsupportedOperationException();
	}

	public Hashtable<Integer, Patient> getAllPatients() {
		throw new UnsupportedOperationException();
	}

	public PriorityQueue<Integer,Patient> getHematologyPriorityPatients() {
		throw new UnsupportedOperationException();
	}

	public Queue<Patient> getHematologyNonPriorityPatients() {
		throw new UnsupportedOperationException();
	}

	public PriorityQueue<Integer,Patient> getGeneralPrioritypatients() {
		throw new UnsupportedOperationException();
	}

	public Queue<Patient> getGeneralNonPriorityPatients() {
		throw new UnsupportedOperationException();
	}

}