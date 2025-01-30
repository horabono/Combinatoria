package testGui.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelCombinaciones extends PanelOperaciones implements ICombinaciones {

	private static final long serialVersionUID = 1L;
	private final JTextField txtSubconjunto = new JTextField();

	public PanelCombinaciones() {
		super();
		
		lblConjunto.setText("Cantidad de elementos del conjunto");
		lblConjunto.setBounds(50, 50, 400, 24);
		txtConjunto.setBounds(450, 50, 50, 24);
		
		JLabel lblSubconjunto = new JLabel("Cantidad de elementos del subconjunto");
		lblSubconjunto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubconjunto.setBounds(50, 80, 400, 24);
		add(lblSubconjunto);
		
		txtSubconjunto.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSubconjunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSubconjunto.setBounds(450, 80, 50, 24);
		add(txtSubconjunto);
		scrollResultados.setBounds(50, 110, 450, 600);
	}

	@Override
	public String getSubconjunto() {
		return txtSubconjunto.getText().trim();
	}

}
