package model;

import java.util.ArrayList;

public class Laboratory {

	private ArrayList<Patient> patientsInLab;
	private ArrayList<Patient> generalPatients;
	private ArrayList<Patient> hematologyPatients;
	
	public Laboratory() {
		this.patientsInLab = new ArrayList<>();
		this.generalPatients = new ArrayList<>();
		this.hematologyPatients = new ArrayList<>();
	}
	
	public void enterPatient(Patient patient) {
		patientsInLab.add(patient);
		
		if(!patient.getUnit()) {
			generalPatients.add(patient);
		} else {
			hematologyPatients.add(patient);
		}
		
		patient.startTimeInLab(this);
	}
	
	public void removePatient(Patient patient) {
		if(!patient.getUnit()) {
			removeGeneralPatient(patient);
		} else {
			removeHematologyPatient(patient);
		}
		
		patientsInLab.remove(patient);
		
		System.out.println("Se ha eliminado a: " + patient.getName());
	}
	
	public void removeGeneralPatient(Patient patient) {
		generalPatients.remove(patient);
	}
	
	public void removeHematologyPatient(Patient patient) {
		hematologyPatients.remove(patient);
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

	public ArrayList<Patient> getGeneralPatients() {
		return generalPatients;
	}

	public void setGeneralPatients(ArrayList<Patient> generalPatients) {
		this.generalPatients = generalPatients;
	}

	public ArrayList<Patient> getHematologyPatients() {
		return hematologyPatients;
	}

	public void setHematologyPatients(ArrayList<Patient> hematologyPatients) {
		this.hematologyPatients = hematologyPatients;
	}
}