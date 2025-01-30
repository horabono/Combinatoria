package testGui.gui;

public class PanelParticiones extends PanelOperaciones {

	private static final long serialVersionUID = 1L;

	public PanelParticiones() {
		super();
		
		lblConjunto.setText("Número a particionar");
		lblConjunto.setBounds(50, 50, 400, 24);
		txtConjunto.setBounds(450, 50, 50, 24);
		scrollResultados.setBounds(50, 80, 450, 600);
	}

}
