package model;

import java.util.Random;

public class Patient {

	private String name;
	private boolean priority;
	private String priorityStr;
	private String id;
	private String age;
	private String celNumber;
	private String address;
	private boolean unit;
	private String unitStr;
	private int priorityValue;

	/**
	 * Constructs a patient with its information.
	 * 
	 * @param name the name of the patient.
	 * @param priority the representation of whether the patient has priority or not.
	 * @param id the id of the patient.
	 * @param age the age of the patient.
	 * @param celNumber the patient's cell phone number.
	 * @param address the address in which the patient lives.
	 * @param unit the unit to which the patient is going.
	 */
	public Patient(String name, boolean priority, String id, String age, String celNumber, String address, boolean unit,
			int priorityValue) {
		this.name = name;
		this.priority = priority;
		this.id = id;
		this.age = age;
		this.celNumber = celNumber;
		this.address = address;
		this.unit = unit;
		this.priorityValue = priorityValue;
		
		setUnitStr();
		setPriorityStr();
	}
	
	/**
	 * Returns the patient's name.
	 * 
	 * @return name the patient's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the patient's name to the specified name.
	 * 
	 * @param name the patient's name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the representation of whether the patient has priority or not.
	 * 
	 * @return the representation of whether the patient has priority or not.
	 */
	public boolean getPriority() {
		return this.priority;
	}

	/**
	 * Sets the representation of whether the patient has priority or not to the specified 
	 * boolean value.
	 * 
	 * @param priority the representation of whether the patient has priority or not
	 */
	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	/**
	 * Returns the patient's id.
	 * 
	 * @return the patient's id.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Sets the patient's id to the specified id.
	 * 
	 * @param id the patient's id.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns the patient's age.
	 * 
	 * @return the patient's age.
	 */
	public String getAge() {
		return this.age;
	}

	/**
	 * Sets the patient's age to the specified age.
	 * 
	 * @param age the patient's age.
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * Returns the patient's cell phone number.
	 * 
	 * @return the patient's cell phone number.
	 */
	public String getCelNumber() {
		return this.celNumber;
	}

	/**
	 * Sets the patient's cell phone number to the specified cell phone number.
	 * 
	 * @param celNumber the patient's cell phone number.
	 */
	public void setCelNumber(String celNumber) {
		this.celNumber = celNumber;
	}

	/**
	 * Returns the patient's address.
	 * 
	 * @return the patient's address.
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Sets the patient's address to the specified address.
	 * 
	 * @param address the patient's address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the unit to which the patient is going.
	 * 
	 * @return the unit to which the patient is going.
	 */
	public boolean getUnit() {
		return this.unit;
	}

	/**
	 * Sets the unit to which the patient is going to the specified unit.
	 * 
	 * @param unit the unit to which the patient is going.
	 */
	public void setUnit(boolean unit) {
		this.unit = unit;
	}

	/**
	 * Returns the patient's priority value.
	 * 
	 * @return the patient's priority value.
	 */
	public int getPriorityValue() {
		return this.priorityValue;
	}

	/**
	 * Sets the patient's priority value to the specified value.
	 * 
	 * @param priorityValue the patient's priority value.
	 */
	public void setPriorityValue(int priorityValue) {
		this.priorityValue = priorityValue;
	}
	
	/**
	 * Returns the representation of whether the patient has priority or not, but in words.
	 * 
	 * @return the representation of whether the patient has priority or not in words.
	 */
	public String getPriorityStr() {
		return priorityStr;
	}

	/**
	 * Sets the representation of whether the patient has priority or not in words by using
	 * the priority parameter.
	 */
	public void setPriorityStr() {
		if(priority) {
			this.priorityStr = "Sí";
		} else {
			this.priorityStr = "No";
		}
	}

	/**
	 * Returns the representation, in words, of the unit to which the patient is going.
	 * 
	 * @return the representation, in words, of the unit to which the patient is going.
	 */
	public String getUnitStr() {
		return unitStr;
	}

	/**
	 * Sets the representation, in words, of the unit to which the patient is going by using 
	 * the unit parameter.
	 */
	public void setUnitStr() {
		if(unit) {
			this.unitStr = "Hematología";
		} else {
			this.unitStr = "Propósito general";
		}		
	}
	
	/**
	 * Starts a thread in which a random time is generated, between one and two minutes,
	 * after which the patient will leave the laboratory that has received as a parameter.
	 * 
	 * @param lab the laboratory in which the patient is located and from which the patient
	 * will leave at the end of the time.
	 */
	public void startTimeInLab(Laboratory lab) {
		new Thread(() -> {
			int minimunTimeInLab = 60;
			int maximunTimeInLab = 120;
			
			Random random = new Random();
			int timeInLab = random.nextInt(maximunTimeInLab) + minimunTimeInLab;
			
			for(int i = 0; i < timeInLab; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			lab.removePatient(this);
			
		}).start();
	}

	/**
	 * Returns all the patient's information.
	 * 
	 * @return all the patient's information.
	 */
	@Override
	public String toString() {
		return "\n***"
				+ "\nNombre: " + name + ""
				+ "\nPrioridad: " + priorityStr
				+ "\nNúmero de identificación: " + id 
				+ "\nEdad: " + age 
				+ "\nNúmero de teléfono: " + celNumber 
				+ "\nDirección: " + address 
				+ "\nUnidad de destino: " + unitStr 
				+ "\nValor de prioridad: " + priorityValue
				+ "\n***\n";
	}
	
}