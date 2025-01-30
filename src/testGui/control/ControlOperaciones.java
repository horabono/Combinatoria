package testGui.control;

import java.util.ArrayList;
import java.util.List;

import combinatoria.IOperacion;
import testGui.gui.OrdenamientoListener;
import testGui.gui.PanelOperaciones;

public abstract class ControlOperaciones extends SuperControl {
	protected final List<ControlResultadosListener> listeners = new ArrayList<>();
	protected int conjunto;
	protected IOperacion operador = null;

	public ControlOperaciones(PanelOperaciones panel) {
		super(panel);
		panel.setModel(modeloLista);
		suscribirEventos();
	}

	public void addControlResultadosListener(ControlResultadosListener listener) {
		listeners.add(listener);
	}
	
	protected void suscribirEventos() {
		((PanelOperaciones)panel).addOrdenamientoListener(new OrdenamientoListener() {
			@Override
			public void ordenar() {
				ordenarResultado();			
			}
		});
	}

	protected void ordenarResultado() {
		try  {
			if(operador == null) {
				throw new RuntimeException("Debe haber un resultado");
			}
			ordenar();
		} catch(RuntimeException ex) {
			for(ControlResultadosListener listener : listeners) {
				listener.rechazar(ex.getMessage());
			}
		}
	}

	protected void ordenar() {
		operador.ordenar();
		mostrarResultado();
	}

	@Override
	protected void ejecutarOperacion() {
		try  {
			validar();
			operar();
		} catch(RuntimeException ex) {
			for(ControlResultadosListener listener : listeners) {
				listener.rechazar(ex.getMessage());
			}
		}
	}
	
	protected void mostrarResultado() {
		modeloLista.clear();
		int j = 0;
		for(int[] a : operador.getResultado()) {
			StringBuilder sb = new StringBuilder(String.format("[%3d] ", ++j));
			for(int i : a) {
				sb.append(String.format("%3d", i));
			}
			sb.append("\n");
			modeloLista.add(sb);
		}
	}
	
	protected abstract void validar();
	protected abstract void operar();

}
