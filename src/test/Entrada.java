package test;

import java.util.Scanner;

public class Entrada {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static int ingresarEntero() {
		boolean exito = false;
		int num = 0;
		do {
			String str = scanner.nextLine();
			try {
				num = Integer.parseInt(str);
				exito = true;
			} catch(NumberFormatException ex) {
				System.out.print("Debe ser un número entero\nIngrese nuevamente:  ");
			}
		} while(!exito);
		return num;
	}
	
	public static int ingresarEnteroEntre(int min, int max) {
		int opcion = ingresarEntero();
		while(opcion < min || opcion > max) {
			System.out.print("Debe ser entre " + min + " y " + max + "\nIngrese nuevamente: ");
			opcion = ingresarEntero();
		}
		return opcion;
	}
	
	public static int ingresarEnteroMinimo(int min) {
		int opcion = ingresarEntero();
		while(opcion < min) {
			System.out.print("No puede ser menor que " + min + "\nIngrese nuevamente: ");
			opcion = ingresarEntero();
		}
		return opcion;
	}

}
