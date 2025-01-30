package testGui.control;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import testGui.gui.FrameSize;
import testGui.gui.PanelCombinaciones;
import testGui.gui.PanelMenu;
import testGui.gui.PanelParticiones;
import testGui.gui.PanelPermutaciones;

public class ControlBase {
	private final JFrame frame;

	public ControlBase(JFrame frame) {
		this.frame = frame;
		ubicarVentana();
		presentarPanelMenu();
	}
	
	private void ubicarVentana() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(FrameSize.size);
		frame.setSize(FrameSize.size);
		frame.setVisible(true);
		frame.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - frame.getWidth()) / 2;
		int y = (screenSize.height - frame.getHeight()) / 2;
		frame.setLocation(x, y);
	}
	
	private void presentarPanelMenu() {
		frame.setTitle("Menú de operaciones");
		PanelMenu panel = new PanelMenu();
		presentarPanel(panel);
		ControlMenu control = new ControlMenu(panel);
		control.addControlPanelListener(new ControlPanelListener() {
			@Override
			public void cerrar() {
				frame.dispose();
			}
		});
		control.addControlMenuListener(new ControlMenuListener() {
			@Override
			public void ejecutar(TipoOperacion operacion) {
				switch(operacion) {
				case PERMUTACIONES:
					presentarPanelPermutaciones();
					break;
				case COMBINACIONES:
					presentarPanelCombinaciones();
					break;
				case VARIACIONES:
					presentarPanelVariaciones();
					break;
				case PARTICIONES:
					presentarPanelParticiones();
					break;
				}
			}
			@Override
			public void rechazar(String mensaje) {
				showErrorMessage(panel, mensaje);
			}
		});
	}

	private void presentarPanelPermutaciones() {
		frame.setTitle("Permutaciones");
		PanelPermutaciones panel = new PanelPermutaciones();
		presentarPanel(panel);
		ControlOperaciones control = new ControlPermutaciones(panel);
		suscribirEventos(panel, control);
	}
	
	private void presentarPanelCombinaciones() {
		frame.setTitle("Combinaciones");
		PanelCombinaciones panel = new PanelCombinaciones();
		presentarPanel(panel);
		ControlOperaciones control = new ControlCombinaciones(panel);
		suscribirEventos(panel, control);
	}
	
	// Para las variaciones se usa el mismo panel
	// pero con diferente controlador
	private void presentarPanelVariaciones() {
		frame.setTitle("Variaciones");
		PanelCombinaciones panel = new PanelCombinaciones();
		presentarPanel(panel);
		ControlOperaciones control = new ControlVariaciones(panel);
		suscribirEventos(panel, control);
	}

	private void presentarPanelParticiones() {
		frame.setTitle("Particiones");
		PanelParticiones panel = new PanelParticiones();
		presentarPanel(panel);
		ControlOperaciones control = new ControlParticiones(panel);
		suscribirEventos(panel, control);
	}
	
	private void suscribirEventos(JPanel panel, ControlOperaciones control) {
		control.addControlPanelListener(new ControlPanelListener() {
			@Override
			public void cerrar() {
				presentarPanelMenu();
			}
		});
		control.addControlResultadosListener(new ControlResultadosListener() {
			@Override
			public void rechazar(String mensaje) {
				showErrorMessage(panel, mensaje);
			}
		});
	}

	private void presentarPanel(JPanel panel) {
		Container container = frame.getContentPane();
		container.removeAll();
		container.add(panel, BorderLayout.CENTER);
		container.validate();
		container.repaint();
        frame.pack();
	}
	
	@SuppressWarnings("unused")
	private void showInformationMessage(JPanel panel, String message) {
		JOptionPane.showMessageDialog(panel, message, frame.getTitle(), JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void showErrorMessage(JPanel panel, String message) {
		JOptionPane.showMessageDialog(panel, message, frame.getTitle(), JOptionPane.ERROR_MESSAGE);
	}
	
	@SuppressWarnings("unused")
	private int showConfirmationMessage(JPanel panel, String message) {
		return JOptionPane.showConfirmDialog(panel, message, frame.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

}
