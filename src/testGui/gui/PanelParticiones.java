package testGui.gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class PanelParticiones extends PanelOperaciones {

	private static final long serialVersionUID = 1L;

	private List<ParticionesListener> listeners = new ArrayList<>();

	public PanelParticiones() {
		super();
		
		lblConjunto.setText("Número a particionar");
		lblConjunto.setBounds(50, 50, 400, 24);
		txtConjunto.setBounds(450, 50, 50, 24);
		scrollResultados.setBounds(50, 80, 450, 600);

		JButton btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(evt -> ordenar(evt));
		panelBotones.add(btnOrdenar);
	}

	public void addParticionesListener(ParticionesListener listener) {
		listeners.add(listener);
	}

	private void ordenar(ActionEvent evt) {
		for(ParticionesListener listener : listeners) {
			listener.ordenar();
		}
	}

}
