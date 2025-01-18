package testGui.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public abstract class PanelOperaciones extends SuperPanel implements IOperaciones {

	private static final long serialVersionUID = 1L;
	protected final JPanel panelBotones = new JPanel();
	private final JList<String> lstResultados = new JList<>();
	protected final JTextField txtConjunto = new JTextField();
	protected final JLabel lblConjunto = new JLabel();
	protected final JScrollPane scrollResultados = new JScrollPane();

	private List<OperacionesListener> listeners = new ArrayList<>();

	protected PanelOperaciones() {
		super();
		
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(evt -> ejecutar(evt));
		panelBotones.add(btnVolver);
		panelBotones.add(btnEjecutar);
		add(panelBotones, BorderLayout.SOUTH);
		
		lblConjunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblConjunto);
		txtConjunto.setHorizontalAlignment(SwingConstants.RIGHT);
		txtConjunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(txtConjunto);
		
		add(scrollResultados);
		lstResultados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		scrollResultados.setViewportView(lstResultados);
	}

	private void ejecutar(ActionEvent evt) {
		for(OperacionesListener listener : listeners) {
			listener.ejecutar();
		}
	}

	public void addOperacionesListener(OperacionesListener listener) {
		listeners.add(listener);
	}
	
	@Override
	public void setModel(ModeloLista modelo) {
		lstResultados.setModel(modelo);
	}

	@Override
	public String getConjunto() {
		return txtConjunto.getText().trim();
	}

}
