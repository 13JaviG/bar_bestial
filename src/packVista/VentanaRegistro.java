package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

import packControlador.ClienteBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

public class VentanaRegistro {

	private JFrame frmIntroduceTusDatos;
	private JPanel panelAbajo;
	private JButton btnRegistrarse;
	private JPanel panelFormulario;
	private JLabel labelUsuario;
	private JLabel labelPass;
	private JLabel labelRepetirPass;
	private JTextField txtUsuario;
	private JPasswordField txtPass;
	private JPasswordField txtRepetirPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro window = new VentanaRegistro();
					window.frmIntroduceTusDatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaRegistro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIntroduceTusDatos = new JFrame();
		frmIntroduceTusDatos.setTitle("Introduce tus datos para registrarte");
		frmIntroduceTusDatos.setBounds(100, 100, 450, 300);
		frmIntroduceTusDatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIntroduceTusDatos.getContentPane().add(getPanelAbajo(), BorderLayout.SOUTH);
		frmIntroduceTusDatos.getContentPane().add(getPanelFormulario(), BorderLayout.CENTER);
	}
	private JPanel getPanelAbajo() {
		if (panelAbajo == null) {
			panelAbajo = new JPanel();
			panelAbajo.add(getBtnRegistrarse());
		}
		return panelAbajo;
	}
	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					registrarse();
				}	
			});
		}
		return btnRegistrarse;
	}
	
	/**
	 * Registra al usuario en el sistema.
	 * @return
	 */
	private boolean registrarse() {
		boolean exito = false;
		// dice que getText esta deprecated pero sigue funcionando bien
		String pass = getTxtPass().getText();
		String repetirPass = getTxtRepetirPass().getText();
		String usuario = getTxtUsuario().getText();
		if (pass.isEmpty() || repetirPass.isEmpty() || usuario.isEmpty()){
			JOptionPane.showMessageDialog(getPanelFormulario(), "Los campos no pueden estar vacios.", "Error al registrarse", JOptionPane.ERROR_MESSAGE);
		} else {
			if (!pass.equals(repetirPass)){
				JOptionPane.showMessageDialog(getPanelFormulario(), "Los passwords no coinciden.", "Error al registrarse", JOptionPane.ERROR_MESSAGE);
			} else {
				exito = ClienteBD.getClienteBD().registrarse(usuario, pass);
				if (exito) {
					JOptionPane.showMessageDialog(getPanelFormulario(), usuario + " fue registrado satisfactoriamente.", "Registro", JOptionPane.INFORMATION_MESSAGE);
					frmIntroduceTusDatos.dispose();
					VentanaMenu.main(null);
				} else {
					JOptionPane.showMessageDialog(getPanelFormulario(), "El nombre del usuario elegido ya existe.\nElige otro nombre.", "Error al registrarse", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		return exito;
	}
	
	private JPanel getPanelFormulario() {
		if (panelFormulario == null) {
			panelFormulario = new JPanel();
			panelFormulario.setBorder(new EmptyBorder(30, 30, 30, 30));
			GridBagLayout gbl_panelFormulario = new GridBagLayout();
			gbl_panelFormulario.columnWidths = new int[]{0, 0, 0};
			gbl_panelFormulario.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panelFormulario.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panelFormulario.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelFormulario.setLayout(gbl_panelFormulario);
			GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
			gbc_labelUsuario.anchor = GridBagConstraints.EAST;
			gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
			gbc_labelUsuario.gridx = 0;
			gbc_labelUsuario.gridy = 0;
			panelFormulario.add(getLabelUsuario(), gbc_labelUsuario);
			GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
			gbc_txtUsuario.insets = new Insets(0, 0, 5, 0);
			gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUsuario.gridx = 1;
			gbc_txtUsuario.gridy = 0;
			panelFormulario.add(getTxtUsuario(), gbc_txtUsuario);
			GridBagConstraints gbc_labelPass = new GridBagConstraints();
			gbc_labelPass.anchor = GridBagConstraints.EAST;
			gbc_labelPass.insets = new Insets(0, 0, 5, 5);
			gbc_labelPass.gridx = 0;
			gbc_labelPass.gridy = 1;
			panelFormulario.add(getLabelPass(), gbc_labelPass);
			GridBagConstraints gbc_txtPass = new GridBagConstraints();
			gbc_txtPass.insets = new Insets(0, 0, 5, 0);
			gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPass.gridx = 1;
			gbc_txtPass.gridy = 1;
			panelFormulario.add(getTxtPass(), gbc_txtPass);
			GridBagConstraints gbc_labelRepetirPass = new GridBagConstraints();
			gbc_labelRepetirPass.anchor = GridBagConstraints.EAST;
			gbc_labelRepetirPass.insets = new Insets(0, 0, 0, 5);
			gbc_labelRepetirPass.gridx = 0;
			gbc_labelRepetirPass.gridy = 2;
			panelFormulario.add(getLabelRepetirPass(), gbc_labelRepetirPass);
			GridBagConstraints gbc_txtRepetirPass = new GridBagConstraints();
			gbc_txtRepetirPass.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRepetirPass.gridx = 1;
			gbc_txtRepetirPass.gridy = 2;
			panelFormulario.add(getTxtRepetirPass(), gbc_txtRepetirPass);
		}
		return panelFormulario;
	}
	private JLabel getLabelUsuario() {
		if (labelUsuario == null) {
			labelUsuario = new JLabel("usuario");
		}
		return labelUsuario;
	}
	private JLabel getLabelPass() {
		if (labelPass == null) {
			labelPass = new JLabel("password");
		}
		return labelPass;
	}
	private JLabel getLabelRepetirPass() {
		if (labelRepetirPass == null) {
			labelRepetirPass = new JLabel("repetir password");
		}
		return labelRepetirPass;
	}
	private JTextField getTxtUsuario() {
		if (txtUsuario == null) {
			txtUsuario = new JTextField();
			txtUsuario.setColumns(10);
		}
		return txtUsuario;
	}
	private JPasswordField getTxtPass() {
		if (txtPass == null) {
			txtPass = new JPasswordField();
		}
		return txtPass;
	}
	private JPasswordField getTxtRepetirPass() {
		if (txtRepetirPass == null) {
			txtRepetirPass = new JPasswordField();
		}
		return txtRepetirPass;
	}
}
