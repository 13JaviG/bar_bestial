package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import packControlador.ClienteBD;
import packControlador.Juego;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicioSesion {

	private JFrame frmInicioDeSesion;
	private JTextField usuarioField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicioSesion window = new VentanaInicioSesion();
					window.frmInicioDeSesion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaInicioSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicioDeSesion = new JFrame();
		frmInicioDeSesion.setTitle("Inicio De Sesion");
		frmInicioDeSesion.setBounds(100, 100, 450, 300);
		frmInicioDeSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInicioDeSesion.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmInicioDeSesion.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnInicioSesion = new JButton("Iniciar Sesion");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ClienteBD.getClienteBD().iniciarSesion(usuarioField.getText(), passwordField.getText())){
					JOptionPane.showMessageDialog(panel, "Fallo en inicio sesion","error", JOptionPane.ERROR_MESSAGE);
				}else {
					Juego.getJuego().setUsuarioSesion(usuarioField.getText());
					frmInicioDeSesion.dispose();
					VentanaMenu.main();
				}
			}
		});
		panel.add(btnInicioSesion);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmInicioDeSesion.dispose();
				VentanaRegistro.main(null);
			}
		});
		panel.add(btnRegistrarse);
		
		JPanel panel_1 = new JPanel();
		frmInicioDeSesion.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(71, 38, 78, 15);
		panel_1.add(lblUsuario);
		
		usuarioField = new JTextField();
		usuarioField.setBounds(152, 36, 124, 19);
		panel_1.add(usuarioField);
		usuarioField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Contraseña:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(50, 74, 83, 15);
		panel_1.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(152, 72, 124, 19);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
	}
}
