package main;

import java.util.Scanner;

import model.LaboratoryAdministrator;

public class Main {

	private static Scanner in = new Scanner(System.in);
	
	private static LaboratoryAdministrator labAdministrator = new LaboratoryAdministrator();
	
	public static void main(String[] args) {
		System.out.println("¡Bienvenido!");
		
		labAdministrator.loadData();
		
		menu();
	}
	
	public static void menu() {
		System.out.println("\n----- Menu -----\n"
				+ "Selecciona qué deseas hacer:\n"
				+ "1) Ver lista de personas en el laboratorio.\n"
				+ "2) Ver el orden de atención de las unidades.\n"
				+ "3) Hacer ingreso de paciente.\n"
				+ "4) Hacer egreso de paciente.\n"
				+ "5) Ver todos los pacientes en el sistema.\n"
				+ "6) Enviar paciente al laboratorio.\n"
				+ "7) Buscar paciente.\n"
				+ "8) Deshacer acción.\n"
				+ "0) Salir.");
		
		int selection = Integer.parseInt(in.nextLine());
		
		switch (selection) {
		case 1:
			seePatientsInLab();
			break;

		case 2:
			seeAtentionOrder();
			break;

		case 3:
			saveAction();
			registerPatient();
			break;

		case 4:
			saveAction();
			egressPatient();
			break;

		case 5:
			seeAllPatients();
			break;

		case 6:
			sendPatientToLab();
			break;
			
		case 7:
			searchPatient();
			break;
			
		case 8:
			undoAction();
			break;
			
		case 0:
			System.out.println("\n¡Adiós!");
			System.exit(0);
			break;
			
		default:
			System.out.println("\nLa opción que elegiste no es válida. Intenta otra vez.");
			menu();
			break;
		}
	}
	
	public static void seePatientsInLab() {
		System.out.println("\n----- Ver lista de personas en el laboratorio -----\n");
		
		System.out.println(labAdministrator.displayAllPatientsInLab());
		
		menu();
	}
	
	public static void seeAtentionOrder() {
		System.out.println("\n----- Ver el orden de atención de las unidades -----\n");
		System.out.println("¿De qué unidad desea ver el orden de atención?"
				+ "\n1) Propósito general."
				+ "\n2) Hematología.");
		int selection = Integer.parseInt(in.nextLine());
		
		switch (selection) {
		case 1:
			System.out.println("\nOrden de atención de la unidad de propósito general:"
					+ "\nFila prioritaria:\n" + labAdministrator.displayGeneralPriorityPatients()
					+ "\nFila normal:\n" + labAdministrator.displayGeneralNonPriorityPatients());
			break;
			
		case 2:
			System.out.println("\nOrden de atención de la unidad de hematología:"
					+ "\nFila prioritaria:\n" + labAdministrator.displayHematologyPriorityPatients()
					+ "\nFila normal:\n" + labAdministrator.displayHematologyNonPriorityPatients());
			break;

		default:
			System.out.println("\nLa opción que elegiste no es válida. Intenta otra vez.");
			seeAtentionOrder();
			break;
		}
		
		menu();
	}
	
	public static void registerPatient() {
		System.out.println("\n----- Hacer ingreso de paciente -----\n");
		
		System.out.println("Ingrese la información del paciente que desea registrar."
				+ "\nNombre completo:");
		String name = in.nextLine();
		
		System.out.println("\nNúmero de identificación:");
		String id = in.nextLine();
		
		if(labAdministrator.searchPatient(id) != null) {
			System.out.println("\nEl paciente que desea registrar ya se encuentra registrado.");

			labAdministrator.clearActions();
			
			menu();
		}
		
		System.out.println("\nEdad (años):");
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
		
		if(labAdministrator.addPatient(name, priority, id, age, celNumber, address, unit, 
				priorityValue)) {
			System.out.println("\n¡Paciente ingresado exitosamente!");
		} else {
			System.out.println("\nOcurrió un error en el ingreso del paciente.");
		}
		
		menu();	
	}
	
	public static void egressPatient() {
		System.out.println("\n----- Hacer egreso de paciente -----\n");

		System.out.println("Ingrese el ID del paciente que desea egresar:");
		String id = in.nextLine();
		
		if(labAdministrator.egressPatient(id)) {
			System.out.println("\n¡El paciente ha sido egresado de manera "
					+ "correcta!");
		} else {
			System.out.println("\nHa habido un error en el egreso del paciente o "
					+ "el ID ingresado no se encuentra registrado en el sistema.");
			
			labAdministrator.clearActions();
		}
		
		menu();	
	}
	
	public static void saveAction() {
		labAdministrator.saveAction(labAdministrator);
		System.out.println(labAdministrator.getAllPatients().size());
	}
	
	public static void undoAction() {
		if(LaboratoryAdministrator.actions.isEmpty()) {
			System.out.println("\n(No hay acciones por deshacer)");
		} else {
			labAdministrator.undo();
			
			System.out.println("\n(Acción deshecha)");
		}
		
		menu();	
	}
	
	public static void seeAllPatients() {
		System.out.println("\n----- Ver todos los pacientes en el sistema -----\n");
		System.out.println("Los pacientes en el sistema son: "
				+ "\n" + labAdministrator.displayAllPatients());
		
		menu();
	}
	
	public static void sendPatientToLab() {
		System.out.println("\n----- Enviar paciente al laboratorio -----\n");
		
		System.out.println("¿A qué unidad desea enviar el paciente?"
				+ "\n1) Propósito general."
				+ "\n2) Hematología.");
		int selection = Integer.parseInt(in.nextLine());
		
		switch (selection) {
		case 1:
			labAdministrator.sendPatient2Lab(false);
			break;
			
		case 2:
			labAdministrator.sendPatient2Lab(true);
			break;

		default:
			System.out.println("\nLa opción que elegiste no es válida. Intenta otra vez.");
			sendPatientToLab();
			break;
		}
		
		menu();	
	}
	
	public static void searchPatient() {
		System.out.println("\n----- Buscar paciente -----\n");
		
		System.out.println("Digite el número de identificación del paciente que busca:");
		String id = in.nextLine();
		
		if(labAdministrator.searchPatient(id) != null) {
			System.out.println("\nUsuario encontrado:"
					+ labAdministrator.searchPatient(id).toString());
			
			if(!labAdministrator.isInQueues(id)) {
				System.out.println("El usaurio ya ha sido atentidido y debe ser egresado del "
						+ "sistema manualmente.");
			}
		} else {
			System.out.println("\nEl usuario que busca no se encuentra en el sistema.");
		}
		
		menu();
	}
}
