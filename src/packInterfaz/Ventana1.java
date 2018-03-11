package packInterfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class Ventana1 {

	private JFrame frmVentana;
	private JLabel lblNorte;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 window = new Ventana1();
					window.frmVentana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVentana = new JFrame();
		frmVentana.setTitle("Primera Ventana");
		frmVentana.setBounds(100, 100, 450, 300);
		frmVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentana.getContentPane().add(getLblNorte(), BorderLayout.NORTH);
		frmVentana.getContentPane().add(getPanel(), BorderLayout.SOUTH);
	}

	private JLabel getLblNorte() {
		if (lblNorte == null) {
			lblNorte = new JLabel("Nombre");
		}
		return lblNorte;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
		}
		return panel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OK");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Cancel");
		}
		return btnNewButton_1;
	}
}
