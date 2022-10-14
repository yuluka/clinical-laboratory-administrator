package main;

import java.util.Scanner;

import model.LaboratoryAdministrator;

public class Main {

	private static Scanner in = new Scanner(System.in);
	
	private static LaboratoryAdministrator labAdministrator = new LaboratoryAdministrator();
	
	public static void main(String[] args) {
		System.out.println("¡Bienvenido!");
		
		menu();
	}
	
	public static void menu() {
		System.out.println("\n----- Menu -----\n"
				+ "Selecciona qué deseas hacer:\n"
				+ "1) Ver lista de personas en el laboratorio.\n"
				+ "2) Ver el orden de atención de las unidades.\n"
				+ "3) Hacer ingreso de paciente.\n"
				+ "4) Hacer egreso de paciente.\n"
				+ "5) Deshacer acción.\n"
				+ "6) Enviar paciente al laboratorio.\n");
		
		int selection = Integer.parseInt(in.nextLine());
		
		switch (selection) {
		case 1:
			seePatientsInLab();
			break;

		case 2:
			seeAtentionOrder();
			break;

		case 3:
			registerPatient();
			break;

		case 4:
			egressPatient();
			break;

		case 5:
			undoAction();
			break;

		case 6:
			sendPatientToLab();
			break;
			
		default:
			System.out.println("\nLa opción que elegiste no es válida. Intenta otra vez.");
			menu();
			break;
		}
	}
	
	public static void seePatientsInLab() {
		System.out.println("\n----- Ver lista de personas en el laboratorio -----\n");
		
		menu();
	}
	
	public static void seeAtentionOrder() {
		System.out.println("\n----- Ver el orden de atención de las unidades -----\n");
		
		menu();
	}
	
	public static void registerPatient() {
		System.out.println("\n----- Hacer ingreso de paciente -----\n");
		
		System.out.println("Ingrese la información del paciente que desea registrar."
				+ "\nNombre:");
		String name = in.nextLine();
		
		System.out.println("\nNúmero de identificación:");
		String id = in.nextLine();
		
		System.out.println("\nEdad:");
		String age = in.nextLine();
		
		System.out.println("\nNúmero de teléfono:");
		String celNumber = in.nextLine();
		
		System.out.println("\nDirección:");
		String address = in.nextLine();
		
		System.out.println("\n¿Tiene prioridad?"
				+ "\n1) No."
				+ "\n2) Sí.");
		int prioritySelect = Integer.parseInt(in.nextLine());
		
		while(prioritySelect > 2 || prioritySelect < 1) {
			System.out.println("\nSelección inválida. Vuelve a intentar:");
			prioritySelect = Integer.parseInt(in.nextLine());
		}
		
		System.out.println("\n¿A qué unidad se dirige?"
				+ "\n1) Propósito general."
				+ "\n2) Hematología.");
		int unitSelect = Integer.parseInt(in.nextLine());
		
		while(unitSelect > 2 || unitSelect < 1) {
			System.out.println("\nSelección inválida. Vuelve a intentar:");
			unitSelect = Integer.parseInt(in.nextLine());
		}
		
		boolean priority = false;
		if(prioritySelect == 2) {
			priority = true;
		}
		
		boolean unit = false;
		if(unitSelect == 2) {
			unit = true;
		}
		
		int priorityValue = 0;
		if(priority) {
			System.out.println("\nIngrese la prioridad que posee la persona "
					+ "(está ordenado de menor a mayor):"
					+ "\n1) Discapacidad."
					+ "\n2) Embarazo."
					+ "\n3) Adulto mayor.");
			priorityValue = Integer.parseInt(in.nextLine());
			
			while (priorityValue < 1 || priorityValue > 3) {
				System.out.println("\nSelección inválida. Vuelve a intentar:");
				
				priorityValue = Integer.parseInt(in.nextLine());
			}
		}
		
		labAdministrator.addPatient(name, priority, id, age, celNumber, address, unit, priorityValue);
		
		menu();	
	}
	
	public static void egressPatient() {
		System.out.println("\n----- Hacer egreso de paciente -----\n");
		
		menu();	
	}
	
	public static void undoAction() {
		System.out.println("\n----- Deshacer acción -----\n");
		
		menu();	
	}
	
	public static void sendPatientToLab() {
		System.out.println("\n----- Enviar paciente al laboratorio -----\n");
		
		menu();	
	}
}
