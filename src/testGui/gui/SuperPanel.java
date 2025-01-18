package testGui.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class SuperPanel extends JPanel implements ISuper {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final List<PanelListener> listeners = new ArrayList<>();
	protected final JButton btnVolver = new JButton("Volver");

	protected SuperPanel() {
		super();
		
		setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		btnVolver.addActionListener(evt -> salir(evt));
	}
	
	public void addPanelListener(PanelListener listener) {
		listeners.add(listener);
	}
	
	public Component add(Component component) {
		return contentPanel.add(component);
	}

	private void salir(ActionEvent evt) {
		for(PanelListener listener : listeners) {
			listener.salir();
		}
	}
	
}
