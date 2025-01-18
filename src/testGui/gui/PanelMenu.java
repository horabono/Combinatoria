package testGui.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;

public class PanelMenu extends SuperPanel implements IMenu {

	private static final long serialVersionUID = 1L;
	private final JPanel panelBotones = new JPanel();
	
	private final List<OperacionesListener> listeners = new ArrayList<>();
	private final JList<String> lstOperaciones = new JList<>();

	public PanelMenu() {
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(evt -> ejecutar(evt));

		btnVolver.setText("Salir");
		panelBotones.add(btnVolver);
		panelBotones.add(btnEjecutar);
		
		JLabel lblOperaciones = new JLabel("Operaciones");
		lblOperaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOperaciones.setBounds(50, 50, 120, 20);
		add(lblOperaciones);
		
		add(panelBotones, BorderLayout.SOUTH);
		JScrollPane scrollOperaciones = new JScrollPane();
		scrollOperaciones.setBounds(50, 80, 190, 120);
		add(scrollOperaciones);
		lstOperaciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		scrollOperaciones.setViewportView(lstOperaciones);
	}

	private void ejecutar(ActionEvent evt) {
		for(OperacionesListener listener : listeners) {
			listener.ejecutar();
		}
	}

	@Override
	public void addOperacionesListener(OperacionesListener listener) {
		listeners.add(listener);
	}
	
	@Override
	public void setModel(ModeloLista modelo) {
		lstOperaciones.setModel(modelo);
	}

	@Override
	public int getOperacion() {
		return lstOperaciones.getSelectedIndex();
	}

}
