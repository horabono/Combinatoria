package testGui.control;

import java.util.ArrayList;
import java.util.List;

import testGui.gui.ModeloLista;
import testGui.gui.OperacionesListener;
import testGui.gui.PanelListener;
import testGui.gui.SuperPanel;

public abstract class SuperControl {
	protected final SuperPanel panel;
	private final List<ControlPanelListener> listeners = new ArrayList<>();
	protected final ModeloLista modeloLista = new ModeloLista();

	public SuperControl(SuperPanel panel) {
		this.panel = panel;
		suscribirEventos();
	}
	
	private void suscribirEventos() {
		panel.addPanelListener(new PanelListener() {
			@Override
			public void salir() {
				cerrar();
			}
		});
		
		panel.addOperacionesListener(new OperacionesListener() {
			@Override
			public void ejecutar() {
				ejecutarOperacion();
			}
		});
	}
	
	private void cerrar() {
		for(ControlPanelListener listener : listeners) {
			listener.cerrar();
		}
	}
	
	public void addControlPanelListener(ControlPanelListener listener) {
		listeners.add(listener);
	}
	
	protected abstract void ejecutarOperacion(); 

}
