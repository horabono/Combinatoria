package testGui.control;

import combinatoria.Partidor;
import testGui.gui.PanelParticiones;
import testGui.gui.PanelOperaciones;

public class ControlParticiones extends ControlOperaciones {
	
	public ControlParticiones(PanelOperaciones panel) {
		super(panel);
	}

	@Override
	protected void validar() {
		String strCantidad = ((PanelParticiones)panel).getConjunto();
		if(strCantidad.isEmpty()) {
			throw new RuntimeException("Falta indicar el número");
		}
		try {
			conjunto = Integer.parseInt(strCantidad);
		} catch (Exception ex) {
			throw new RuntimeException("La entrada debe ser numérica");
		}
		if(conjunto < 1) {
			throw new RuntimeException("No puede ser menor que 1");
		}
	}
	
	@Override
	protected void operar() {
		operador = new Partidor(conjunto);
		mostrarResultado();
	}

}
