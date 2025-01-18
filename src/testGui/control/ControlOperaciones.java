package testGui.control;

import java.util.ArrayList;
import java.util.List;

import testGui.gui.OperacionesListener;
import testGui.gui.PanelOperaciones;

public abstract class ControlOperaciones extends SuperControl {
	protected final List<ControlResultadosListener> listeners = new ArrayList<>();
	protected int conjunto;

	public ControlOperaciones(PanelOperaciones panel) {
		super(panel);
		panel.setModel(modeloLista);
		suscribirEventos();
	}

	public void addControlResultadosListener(ControlResultadosListener listener) {
		listeners.add(listener);
	}
	
	private void suscribirEventos() {
		((PanelOperaciones)panel).addOperacionesListener(new OperacionesListener() {
			@Override
			public void ejecutar() {
				ejecutarOperacion();
			}
		});
	}

	private void ejecutarOperacion() {
		try  {
			validar();
			operar();
		} catch(RuntimeException ex) {
			for(ControlResultadosListener listener : listeners) {
				listener.rechazar(ex.getMessage());
			}
		}
	}
	
	protected abstract void validar();
	protected abstract void operar();

}
