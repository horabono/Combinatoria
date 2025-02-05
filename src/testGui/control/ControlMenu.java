package testGui.control;

import java.util.ArrayList;
import java.util.List;

import testGui.gui.PanelMenu;

public class ControlMenu extends SuperControl {
	private final List<ControlMenuListener> listeners = new ArrayList<>();
	private TipoOperacion operacion;

	public ControlMenu(PanelMenu panel) {
		super(panel);
		panel.setModel(modeloLista);
		cargarOperaciones();
	}

	protected void ejecutarOperacion() {
		try {
			validar();
			for(ControlMenuListener listener : listeners) {
				listener.ejecutar(operacion);
			}
		} catch(RuntimeException ex) {
			for(ControlMenuListener listener : listeners) {
				listener.rechazar(ex.getMessage());
			}
		}
	}

	public void addControlMenuListener(ControlMenuListener listener) {
		listeners.add(listener);
	}

	private void cargarOperaciones() {
		for(TipoOperacion operacion : TipoOperacion.values()) {
			modeloLista.add(operacion);
		}
	}
	
	private void validar() {
		int index = ((PanelMenu)panel).getOperacion();
		if(index < 0) {
			throw new RuntimeException("Debe seleccionar una operación");
		}
		operacion = TipoOperacion.values()[index];
	}

}
