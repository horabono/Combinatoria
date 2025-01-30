package testGui.control;

import combinatoria.Variador;
import testGui.gui.PanelCombinaciones;
import testGui.gui.PanelOperaciones;

public class ControlVariaciones extends ControlOperaciones {
	protected int subconjunto;
	
	public ControlVariaciones(PanelOperaciones panel) {
		super(panel);
	}

	@Override
	protected void validar() {
		String strCantidad = ((PanelCombinaciones)panel).getConjunto();
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
		String strSubconjunto = ((PanelCombinaciones)panel).getSubconjunto();
		if(strSubconjunto.isEmpty()) {
			throw new RuntimeException("Falta indicar la cantidad del subconjunto");
		}
		try {
			subconjunto = Integer.parseInt(strSubconjunto);
		} catch (Exception ex) {
			throw new RuntimeException("La cantidad debe ser numérica");
		}
		if(subconjunto < 1 || subconjunto > conjunto) {
			throw new RuntimeException("No puede ser menor que 1 ni mayor que " + conjunto);
		}
	}
	
	@Override
	protected void operar() {
		int[] vector = new int[conjunto];
		for(int i = 0; i < conjunto; i++) {
			vector[i] = i+1;
		}
		operador = new Variador(vector, subconjunto);
		mostrarResultado();
	}

}
