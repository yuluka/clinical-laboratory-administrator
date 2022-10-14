package model;

import java.util.ArrayList;

public class Laboratory {

	private ArrayList<Patient> patientsInLab;
	
	public Laboratory() {
		this.patientsInLab = new ArrayList<>();
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
}