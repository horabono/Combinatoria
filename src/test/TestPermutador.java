package test;

import java.util.List;

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
		System.out.println("\nPermutaciones de " + total + " elementos tal como fueron generadas");
		int j = 0;
		do {
			System.out.print(String.format("[%3d] ", ++j));
			for(int i : conjunto) {
				System.out.print(String.format("%3d", i));
			}
			System.out.println();
		} while(p.permutar());
		
		System.out.println("\nPermutaciones ordenadas de " + total + " elementos");
		p.ejecutar();
		p.ordenar();
		List<int[]> resultado = p.getResultado();
		j = 0;
		for(int[] r : resultado) {
			System.out.print(String.format("[%3d] ", ++j));
			for(int i : r) {
				System.out.print(String.format("%3d", i));
			}
			System.out.println();
		}
	}

}
