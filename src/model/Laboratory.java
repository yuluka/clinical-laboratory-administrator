package model;

import java.util.ArrayList;

public class Laboratory {

	private ArrayList<Patient> patientsInLab;
	private ArrayList<Patient> generalPatients;
	private ArrayList<Patient> hematologyPatients;
	
	/**
	 * Constructs an empty laboratory with three lists. 
	 * The first one for all patients who enter the laboratory.
	 * The second one for the patients who enter the laboratory and going to the General unit.
	 * The third one for the patients who enter the laboratory and going to the Hematology
	 * unit.
	 */
	public Laboratory() {
		this.patientsInLab = new ArrayList<>();
		this.generalPatients = new ArrayList<>();
		this.hematologyPatients = new ArrayList<>();
	}
	
	/**
	 * Enters a patient into the laboratory by adding the patient to the list of all
	 * the patients in the laboratory and to the list of the unit to which the patient goes.
	 * 
	 * @param patient patient who is entering to the laboratory.
	 */
	public void enterPatient(Patient patient) {
		patientsInLab.add(patient);
		
		if(!patient.getUnit()) {
			generalPatients.add(patient);
		} else {
			hematologyPatients.add(patient);
		}
		
		patient.startTimeInLab(this);
	}

	/**
	 * Removes a patient from the laboratory by removing it from the list of all the patients 
	 * in the laboratory and from the list of the unit in which it is located.
	 * 
	 * @param patient patient being removed from the laboratory.
	 */
	public void removePatient(Patient patient) {
		if(!patient.getUnit()) {
			removeGeneralPatient(patient);
		} else {
			removeHematologyPatient(patient);
		}
		
		patientsInLab.remove(patient);
		
		System.out.println("Se ha eliminado a: " + patient.getName());
	}
	
	/**
	 * Removes a patient from the list of the patients in the General unit.
	 * 
	 * @param patient patient being removed from the General unit list.
	 */
	public void removeGeneralPatient(Patient patient) {
		generalPatients.remove(patient);
	}
	
	/**
	 * Removes a patient from the list of the patients in the Hematology unit.
	 * 
	 * @param patient patient being removed from the Hematology unit list.
	 */
	public void removeHematologyPatient(Patient patient) {
		hematologyPatients.remove(patient);
	}

	/**
	 * Returns the quantity of patients in the laboratory.
	 * 
	 * @return the quantity of patients in the laboratory.
	 */
	public int getTotalPatient() {
		return patientsInLab.size();
	}

	/**
	 * Returns the list with all the patients in the laboratory.
	 * 
	 * @return the list with all the patients in the laboratory.
	 */
	public ArrayList<Patient> getPatientsInLab() {
		return patientsInLab;
	}

	/**
	 * Returns the list with the patients in the General unit.
	 * 
	 * @return the list with the patients in the General unit.
	 */
	public ArrayList<Patient> getGeneralPatients() {
		return generalPatients;
	}
	
	/**
	 * Returns the list with the patients in the Hematology unit.
	 * 
	 * @return the list with the patients in the Hematology unit.
	 */
	public ArrayList<Patient> getHematologyPatients() {
		return hematologyPatients;
	}
}