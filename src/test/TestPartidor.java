package test;
import combinatoria.Partidor;

public class TestPartidor {
	
	public static void ejecutar() {
		System.out.println("\nPARTICIONES\n");
		System.out.print("Ingrese el número a particionar: ");
		int num = Entrada.ingresarEnteroMinimo(0);
		Partidor p = new Partidor(num);
		System.out.println("\nParticiones de " + p.numero + " tal como fueron generadas");
		System.out.print(p);
		p.ordenar();
		System.out.println("\nParticiones de " + p.numero + " ordenadas");
		System.out.print(p);
	}

}
