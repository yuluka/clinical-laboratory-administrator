package main;

import java.util.Scanner;

public class Main {

	private static Scanner in = new Scanner(System.in);
	
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
