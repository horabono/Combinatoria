package testGui.control;

import combinatoria.Permutador;
import testGui.gui.PanelOperaciones;
import testGui.gui.PanelPermutaciones;

public class ControlPermutaciones extends ControlOperaciones {
	private int[] vector = null;

	public ControlPermutaciones(PanelPermutaciones panel) {
		super(panel);
	}

	@Override
	protected void validar() {
		String strCantidad = ((PanelOperaciones)panel).getConjunto();
		if(strCantidad.isEmpty()) {
			throw new RuntimeException("Falta indicar la cantidad");
		}
		try {
			conjunto = Integer.parseInt(strCantidad);
		} catch (Exception ex) {
			throw new RuntimeException("La cantidad debe ser numérica");
		}
		if(conjunto < 1) {
			throw new RuntimeException("No puede ser menor que 1");
		}
	}
	
	@Override
	protected void operar() {
		vector = new int[conjunto];
		for(int i = 0; i < conjunto; i++) {
			vector[i] = i+1;
		}
		operador = new Permutador(vector);
		operador.ejecutar();
		mostrarResultado();
	}

}
