package test;

public final class Test {
	
	private int menu() {
		System.out.println("\nSeleccione la operación");
		System.out.println("0. Terminar");
		System.out.println("1. Permutaciones");
		System.out.println("2. Combinaciones");
		System.out.println("3. Variaciones");
		System.out.println("4. Particiones");
		System.out.print("Su opción: ");
		return Entrada.ingresarEnteroEntre(0, 4);
	}
	
	public void ejecutar() {
		int opcion;		
		while((opcion = menu()) != 0) {
			switch(opcion) {
			case 1:
				TestPermutador.ejecutar();
				break;
			case 2:
				TestCombinador.ejecutar();
				break;
			case 3:
				TestVariador.ejecutar();
				break;
			case 4:
				TestPartidor.ejecutar();
				break;
			}
		}
		System.out.println("\nFIN DEL PROGRAMA");
	}

	public static void main(String[] args) {
		new Test().ejecutar();
	}

}
