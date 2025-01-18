package testGui.gui;

public class PanelPermutaciones extends PanelOperaciones {

	private static final long serialVersionUID = 1L;

	public PanelPermutaciones() {
		super();
		
		lblConjunto.setText("Cantidad de elementos del conjunto");
		lblConjunto.setBounds(50, 50, 400, 24);
		txtConjunto.setBounds(450, 50, 50, 24);
		scrollResultados.setBounds(50, 80, 450, 600);
	}
	
}
