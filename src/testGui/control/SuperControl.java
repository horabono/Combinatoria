package testGui.control;

import java.util.ArrayList;
import java.util.List;

import testGui.gui.ModeloLista;
import testGui.gui.PanelListener;
import testGui.gui.SuperPanel;

public abstract class SuperControl {
	protected final SuperPanel panel;
	private final List<ControlListener> listeners = new ArrayList<>();
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
	}
	
	protected void cerrar() {
		for(ControlListener listener : listeners) {
			listener.cerrar();
		}
	}
	
	public void addControlListener(ControlListener listener) {
		listeners.add(listener);
	}

}
