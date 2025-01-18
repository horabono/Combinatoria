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
 	
	private void setTitle(String title) {
		frame.setTitle(title);
	}
	
	private void presentarPanelMenu() {
		setTitle("Menú de operaciones");
		PanelMenu panel = new PanelMenu();
		presentarPanel(panel);
		ControlMenu control = new ControlMenu(panel);
		
		control.addControlListener(new ControlListener() {
			@Override
			public void cerrar() {
				frame.dispose();
			}
		});
		
		control.addControlMenuListener(new ControlMenuListener() {
			@Override
			public void rechazar(String mensaje) {
				showErrorMessage(panel, mensaje);
			}
			
			@Override
			public void aceptar(TipoOperacion operacion) {
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
		});
	}

	private void presentarPanelPermutaciones() {
		setTitle("Permutaciones");
		PanelPermutaciones panel = new PanelPermutaciones();
		presentarPanel(panel);
		ControlPermutaciones control = new ControlPermutaciones(panel);
		control.addControlListener(new ControlListener() {
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
	
	private void presentarPanelCombinaciones() {
		setTitle("Combinaciones");
		PanelCombinaciones panel = new PanelCombinaciones();
		presentarPanel(panel);
		ControlCombinaciones control = new ControlCombinaciones(panel);
		control.addControlListener(new ControlListener() {
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
	
	private void presentarPanelVariaciones() {
		setTitle("Variaciones");
		PanelCombinaciones panel = new PanelCombinaciones();
		presentarPanel(panel);
		ControlVariaciones control = new ControlVariaciones(panel);
		control.addControlListener(new ControlListener() {
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

	private void presentarPanelParticiones() {
		setTitle("Particiones");
		PanelParticiones panel = new PanelParticiones();
		presentarPanel(panel);
		ControlParticiones control = new ControlParticiones(panel);
		control.addControlListener(new ControlListener() {
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
