package test;

import combinatoria.Permutador;

public class TestPermutador {
	
	public static void ejecutar() {
		System.out.println("\nPERMUTACIONES\n");
		System.out.print("Ingrese la cantidad total de elementos del conjunto: ");
		int total = Entrada.ingresarEnteroMinimo(1);
		int[] conjunto = new int[total];
		for(int i = 0; i < total; i++) {
			conjunto[i] = i+1;
		}
		Permutador p = new Permutador(conjunto);
		System.out.println("\nPermutaciones de " + total + " elementos");
		int j = 0;
		do {
			System.out.print(String.format("[%3d] ", ++j));
			for(int i : conjunto) {
				System.out.print(String.format("%3d", i));
			}
			System.out.println();
		} while(p.permutar());
	}

}
