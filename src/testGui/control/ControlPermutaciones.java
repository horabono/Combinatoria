package testGui.control;

import combinatoria.Permutador;
import testGui.gui.PanelOperaciones;
import testGui.gui.PanelPermutaciones;

public class ControlPermutaciones extends ControlOperaciones {
	public ControlPermutaciones(PanelPermutaciones panel) {
		super(panel);
	}
	
	protected void operar() {
		modeloLista.clear();
		int[] vector = new int[conjunto];
		for(int i = 0; i < conjunto; i++) {
			vector[i] = i+1;
		}
		Permutador p = new Permutador(vector);
		int j = 0;
		do {
			StringBuilder sb = new StringBuilder(String.format("[%3d] ", ++j));
			for(int i : vector) {
				sb.append(String.format("%3d", i));
			}
			sb.append("\n");
			modeloLista.add(sb);
		} while(p.permutar());
	}

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

}
