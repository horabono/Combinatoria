package testGui.control;

import combinatoria.Combinador;
import testGui.gui.PanelOperaciones;

public class ControlCombinaciones extends ControlVariaciones {
	
	public ControlCombinaciones(PanelOperaciones panel) {
		super(panel);
	}
	
	@Override
	protected void operar() {
		int[] vector = new int[conjunto];
		for(int i = 0; i < conjunto; i++) {
			vector[i] = i+1;
		}
		operador = new Combinador(vector, subconjunto);
		mostrarResultado();
	}

}
