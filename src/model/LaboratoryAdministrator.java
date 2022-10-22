package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dataStructures.Hashtable;
import dataStructures.Map;
import dataStructures.PriorityQueue;
import dataStructures.Queue;
import dataStructures.Stack;

public class LaboratoryAdministrator implements Cloneable {

	private final String SEPARATOR = ",";
	
	private Hashtable<String,Patient> patients;
	private PriorityQueue<Integer,Patient> generalPriorityPatients;
	private Queue<Patient> generalNonPriorityPatients;
	private PriorityQueue<Integer, Patient> hematologyPriorityPatients;
	private Queue<Patient> hematologyNonPriorityPatients;
	
	public static Stack<LaboratoryAdministrator> actions = new Stack<>();
	
	private Laboratory lab;

	/**
	 * Constructs a laboratory administrator.
	 */
	public LaboratoryAdministrator() {
		this.patients = new Hashtable<>();
		this.generalPriorityPatients = new PriorityQueue<>();
		this.generalNonPriorityPatients = new Queue<>();
		this.hematologyPriorityPatients = new PriorityQueue<>();
		this.hematologyNonPriorityPatients = new Queue<>();
		
		this.lab = new Laboratory();
	}

	/**
	 * Adds 
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
		
		patients.insert(newPatient.getId(), newPatient);
		sendPatientToQueue(newPatient);
		
		return true;
	}
	
	/**
	 * 
	 * @param newPatient
	 */
	public boolean addPatient(Patient newPatient) {
		if(searchPatient(newPatient.getId()) != null) {
			return false;
		}
		
		patients.insert(newPatient.getId(), newPatient);
		sendPatientToQueue(newPatient);
		
		return true;
	}
	
	/**
	 * 
	 * @param newPatient
	 */
	public void sendPatientToQueue(Patient newPatient) {
		if(newPatient.getPriority()) {
			if(!newPatient.getUnit()) {
				generalPriorityPatients.insert(newPatient.getPriorityValue(), newPatient);
			} else {
				hematologyPriorityPatients.insert(newPatient.getPriorityValue(),newPatient);
			}
		} else {
			if(!newPatient.getUnit()) {
				generalNonPriorityPatients.enqueue(newPatient);
			} else {
				hematologyNonPriorityPatients.enqueue(newPatient);
			}
		}
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
	
	/**
	 * 
	 * @param unit
	 */
	public void sendPatient2Lab(boolean unit) {
		if(!unit) {
			if(generalPriorityPatients.size() != 0) {
				//Enviar paciente prioritario
				lab.enterPatient(generalPriorityPatients.extractMax().getValue());
			} else {
				//Enviar paciente no prioritaio
				lab.enterPatient(generalNonPriorityPatients.dequeue().getValue());
			}
		} else {
			if(hematologyPriorityPatients.size() != 0) {
				lab.enterPatient(hematologyPriorityPatients.extractMax().getValue());
			} else {
				lab.enterPatient(hematologyNonPriorityPatients.dequeue().getValue());
			}
		}
	}
	
	

	/**
	 * Deletes a patients from the list with all the patients in the system.
	 * 
	 * @param id the of the patient to delete.
	 */
	public boolean egressPatient(String id) {
		Patient patient = searchPatient(id);
		
		if(patient == null) {
			return false;
		}
	
		egressOfQueues(patient);
		
		patients.delete(new Map<String, Patient>(id, patient));
		
		if(isInQueues(patient)) {
			return false;
		}
		
		return true;
	}
	
	public void egressOfQueues(Patient patient) {
		if(generalNonPriorityPatients.contains(patient)) {
			egressPatientOfQueue(patient,generalNonPriorityPatients);
			
			return;
		} else if(generalPriorityPatients.contains(patient)) {
			egressPatientOfPriorityQueue(patient, generalPriorityPatients);
			
			return;
		} else if(hematologyNonPriorityPatients.contains(patient)) {
			egressPatientOfQueue(patient, hematologyNonPriorityPatients);
			
			return;
		} else if(hematologyPriorityPatients.contains(patient)) {
			egressPatientOfPriorityQueue(patient, hematologyPriorityPatients);
			
			return;
		}
	}
	
	/**
	 * Removes the specified patient of the specified queue.
	 * 
	 * @param patient the patient to remove.
	 * @param queue the queue in which the patient is.
	 * @return the boolean value of the operation's result.
	 */
	private boolean egressPatientOfQueue(Patient patient, 
			Queue<Patient> queue) {
		int size = queue.size();
		boolean result = false;
		
		for (int i = 0; i < size-1; i++) {
			if(queue.front().getValue().getId().equalsIgnoreCase(patient.getId())) {
				queue.dequeue();
				
				result = true;
			}
			
			Patient auxPatient = queue.dequeue().getValue();
			queue.enqueue(auxPatient);
		}
		
		return result;
	}
	
	/**
	 * Removes the specified patient of the specified priority queue.
	 * 
	 * @param patient the patient to remove.
	 * @param pQueue the priority queue in which the patient is.
	 * @return the boolean value of the operation's result.
	 */
	private boolean egressPatientOfPriorityQueue(Patient patient, 
			PriorityQueue<Integer, Patient> pQueue) {
		Queue<Patient> auxQueue = new Queue<Patient>();
		
		while (pQueue.size() != 0) {
			if(pQueue.maximum().getValue().getId().equalsIgnoreCase(patient.getId())) {
				pQueue.extractMax();
			} else {
				auxQueue.enqueue(pQueue.extractMax().getValue());
			}
		}
		
		int size = auxQueue.size();
		
		for (int i = 0; i < size; i++) {
			pQueue.insert(auxQueue.front().getValue().getPriorityValue(), 
					auxQueue.dequeue().getValue());
		}
		
		return false;
	}
	

	/**
	 * Says if the specified patient is in any queue.
	 * 
	 * @param patient the patient to search in the queues.
	 * @return the boolean value of whether the patient is in any queue or 
	 * not.
	 */	
	public boolean isInQueues(Patient patient) {
		if(generalNonPriorityPatients.contains(patient) || generalPriorityPatients.contains(patient)
				|| hematologyNonPriorityPatients.contains(patient) || hematologyPriorityPatients.contains(patient)) {
			return true;
		}
		
		return false;
	}
	
	public boolean isInQueues(String id) {
		if(searchPatient(id) != null) {
			return isInQueues(searchPatient(id));
		}
		
		return false;
	}

	public Hashtable<String, Patient> getAllPatients() {
		return patients;
	}
	
	public String displayAllPatients() {
		String info = "";
		
		if(patients.size() == 0) {
			return "No hay pacientes en el sistema.";
		}
		
		for (int i = 0; i < patients.size(); i++) {
			info += patients.get(i).getValue().toString();
			
			if(!isInQueues(patients.get(i).getValue())) {
				info += "(Este usuario ya ha sido atentidido y debe ser egresado del "
						+ "sistema manualmente)";
			}
		}
		
		return info;
	}
	
	public ArrayList<Patient> getAllPatientsInLab() {
		return lab.getPatientsInLab();
	}
	
	public String displayAllPatientsInLab() {
		String info = "";
		
		if(lab.getPatientsInLab().size() == 0) {
			return "El laboratorio está vacío.";
		}
		
		for (int i = 0; i < lab.getPatientsInLab().size(); i++) {
			info += lab.getPatientsInLab().get(i).toString();
		}
		
		return info;
	}

	public PriorityQueue<Integer,Patient> getHematologyPriorityPatients() {
		return hematologyPriorityPatients;
	}
	
	public String displayHematologyPriorityPatients() {
		return printPriorityQueue(hematologyPriorityPatients);
	}

	public Queue<Patient> getHematologyNonPriorityPatients() {
		return hematologyNonPriorityPatients;
	}
	
	public String displayHematologyNonPriorityPatients() {
		return printQueue(hematologyNonPriorityPatients);
	}

	public PriorityQueue<Integer,Patient> getGeneralPriorityPatients() {
		return generalPriorityPatients;
	}
	
	public String displayGeneralPriorityPatients() {
		return printPriorityQueue(generalPriorityPatients);
	}

	public Queue<Patient> getGeneralNonPriorityPatients() {
		return generalNonPriorityPatients;
	}
	
	public String displayGeneralNonPriorityPatients() {
		return printQueue(generalNonPriorityPatients);
	}

	private String printPriorityQueue(PriorityQueue<Integer, Patient> pQueue) {
		String info = "";
		
		if(pQueue.size() == 0) {
			return "No hay personas esperando en esta fila.";
		}
		
		for (int i = 0; i < pQueue.size(); i++) {
			info += pQueue.get(i).getValue().toString();
		}
		
		return info;
	}
	
	private String printQueue(Queue<Patient> queue) {
		String info = "";
		
		int size = queue.size();
		
		if(size == 0) {
			return "No hay personas esperando en esta fila.";
		}
		
		for (int i = 0; i < size; i++) {
			Patient auxPatient = queue.front().getValue();
			info += queue.dequeue().getValue().toString();
			
			queue.enqueue(auxPatient);
		}
		
		return info;
	}
	
	public void loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/DataBase.txt"));
			
			String line = br.readLine();
			
			while(line != null) {
				String[] parts = line.split(SEPARATOR);
				
				boolean priority = Boolean.parseBoolean(parts[1]);
				boolean unit = Boolean.parseBoolean(parts[6]);
				int priorityValue = Integer.parseInt(parts[7]);
				
				Patient newPatient = new Patient(parts[0],priority,parts[2],parts[3],
						parts[4],parts[5],unit,priorityValue);
				
				addPatient(newPatient);
				
				line = br.readLine();
			}
			
			br.close();
		
			System.out.println("\n¡Pacientes cargados exitosamente!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveAction(LaboratoryAdministrator toSave) {
		LaboratoryAdministrator aux = (LaboratoryAdministrator) clone();
		actions.push(aux);
	}

	@Override
	public Object clone() {
		try {
			LaboratoryAdministrator aux = (LaboratoryAdministrator) super.clone();
			aux.patients = patients.clone();
			
			return aux;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	public void undo() {
		new Thread(() -> {
			LaboratoryAdministrator auxLab = actions.pop().getValue();
			
			Hashtable<String, Patient> auxTable = auxLab.patients;
			
			generalNonPriorityPatients = new Queue<>();
			generalPriorityPatients = new PriorityQueue<>();
			hematologyNonPriorityPatients = new Queue<>();
			hematologyPriorityPatients = new PriorityQueue<>();
			
			for (int i = auxTable.size()-1; i >= 0; i--) {
				sendPatientToQueue(auxTable.get(i).getValue());
			}
			
			patients = auxTable;
		}).start();
	}
	
	public void clearActions() {
		while (!actions.isEmpty()) {
			actions.pop();
		}
	}
}