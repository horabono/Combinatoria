package testGui.control;

import java.util.ArrayList;

import combinatoria.Variador;
import testGui.gui.PanelCombinaciones;

public class ControlVariaciones extends ControlOperaciones {
	private int subconjunto;
	
	public ControlVariaciones(PanelCombinaciones panel) {
		super(panel);
	}
	
	protected void operar() {
		modeloLista.clear();
		int[] vector = new int[conjunto];
		for(int i = 0; i < conjunto; i++) {
			vector[i] = i+1;
		}
		ArrayList<int[]> lista = Variador.variar(vector, subconjunto);
		int j = 0;
		for(int[] a : lista) {
			StringBuilder sb = new StringBuilder(String.format("[%3d] ", ++j));
			for(int i : a) {
				sb.append(String.format("%3d", i));
			}
			sb.append("\n");
			modeloLista.add(sb);
		}
	}

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
			throw new RuntimeException("Falta indicar la conjunto del subconjunto");
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

}
