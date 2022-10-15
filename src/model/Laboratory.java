package model;

import java.util.ArrayList;

import dataStructures.Queue;

public class Laboratory {

	private ArrayList<Patient> patientsInLab;
	private Queue<Patient> generalPatients;
	private Queue<Patient> hematologyPatients;
	
	public Laboratory() {
		this.patientsInLab = new ArrayList<>();
		this.generalPatients = new Queue<>();
		this.hematologyPatients = new Queue<>();
	}
	
	public void enterPatient(Patient patient) {
		patientsInLab.add(patient);
		
		if(!patient.getUnit()) {
			generalPatients.enqueue(patient);
		} else {
			hematologyPatients.enqueue(patient);
		}
	}
	
	public void removeGeneralPatient() {
		generalPatients.dequeue();
	}
	
	public void removeHematologyPatient() {
		hematologyPatients.dequeue();
	}

	public int getTotalPatient() {
		return patientsInLab.size();
	}

	public ArrayList<Patient> getPatientsInLab() {
		return patientsInLab;
	}

	public void setPatientsInLab(ArrayList<Patient> patientsInLab) {
		this.patientsInLab = patientsInLab;
	}

	public Queue<Patient> getGeneralPatients() {
		return generalPatients;
	}

	public void setGeneralPatients(Queue<Patient> generalPatients) {
		this.generalPatients = generalPatients;
	}

	public Queue<Patient> getHematologyPatients() {
		return hematologyPatients;
	}

	public void setHematologyPatients(Queue<Patient> hematologyPatients) {
		this.hematologyPatients = hematologyPatients;
	}
}