package testGui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import testGui.control.ControlBase;

public class TestGui {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new ControlBase(new JFrame());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
