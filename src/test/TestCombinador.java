package test;

import java.util.List;

import combinatoria.Combinador;

public class TestCombinador {
	
	public static void ejecutar() {
		System.out.println("\nCOMBINACIONES\n");
		System.out.print("Ingrese la cantidad total de elementos del conjunto: ");
		int total = Entrada.ingresarEnteroMinimo(1);
		System.out.print("Ingrese la cantidad del subconjunto: ");
		int parcial = Entrada.ingresarEnteroEntre(1, total);
		int[] conjunto = new int[total];
		for(int i = 0; i < total; i++) {
			conjunto[i] = i+1;
		}
		
		List<int[]> lista = Combinador.combinar(conjunto, parcial);
		System.out.println("\nCombinaciones de " + total + " elementos tomados de a " + parcial);
		int j = 0;
		for(int[] a : lista) {
			System.out.print(String.format("[%3d] ", ++j));
			for(int i : a) {
				System.out.print(String.format("%3d", i));
			}
			System.out.println();
		}
		
		Combinador c = new Combinador(conjunto, parcial);
		System.out.println("\nCombinaciones ordenadas de " + total + " elementos tomados de a " + parcial);
		c.ordenar();
		j = 0;
		for(int[] resultado : c.getResultado()) {
			System.out.print(String.format("[%3d] ", ++j));
			for(int i : resultado) {
				System.out.print(String.format("%3d", i));
			}
			System.out.println();
		}
	}

}
