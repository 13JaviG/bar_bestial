package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import packControlador.Juego;

import java.awt.Color;
import java.awt.FlowLayout;

public class VentanaMenu {

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu window = new VentanaMenu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setBackground(Color.WHITE);
		frmMenu.getContentPane().setBackground(Color.WHITE);
		frmMenu.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmMenu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Juego.getJuego().testJuegoNuevo();
				VentanaPrincipal pri=new VentanaPrincipal();
				frmMenu.dispose();
			}
		});
		btnJugar.setBounds(150, 58, 114, 25);
		panel.add(btnJugar);
		
		JButton btnRanking = new JButton("Ranking");
		btnRanking.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frmMenu.dispose();
				VentanaRanking.getVentanaRanking().empezar();
			}
		});
		btnRanking.setBounds(150, 95, 114, 25);
		panel.add(btnRanking);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frmMenu.dispose();
				
			}
			
		});
		btnSalir.setBounds(150, 132, 114, 25);
		panel.add(btnSalir);
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 450, 300);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
