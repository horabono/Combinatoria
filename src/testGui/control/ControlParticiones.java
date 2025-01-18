package testGui.control;

import combinatoria.Particion;
import combinatoria.Partidor;
import testGui.gui.PanelParticiones;
import testGui.gui.ParticionesListener;

public class ControlParticiones extends ControlOperaciones {
	private Partidor partidor;
	
	public ControlParticiones(PanelParticiones panel) {
		super(panel);
		suscribirEventos();
	}
	
	private void suscribirEventos() {
		((PanelParticiones)panel).addParticionesListener(new ParticionesListener() {
			@Override
			public void ordenar() {
				ordenarParticiones();			}
		});
	}

	protected void ordenarParticiones() {
		try  {
			if(partidor == null) {
				throw new RuntimeException("Debe haber una partición");
			}
			ordenar();
		} catch(RuntimeException ex) {
			for(ControlResultadosListener listener : listeners) {
				listener.rechazar(ex.getMessage());
			}
		}
	}
	
	protected void operar() {
		partidor = new Partidor(conjunto);
		mostrarParticiones();
	}

	private void ordenar() {
		partidor.ordenar();
		mostrarParticiones();
	}
	
	private void mostrarParticiones() {
		modeloLista.clear();
		int j = 0;
		for(Particion parte : partidor.get()) {
			StringBuilder sb = new StringBuilder(String.format("[%3d] ", ++j));
			for(int i : parte.partes) {
				sb.append(String.format("%3d", i));
			}
			sb.append("\n");
			modeloLista.add(sb);
		}
	}

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

}
