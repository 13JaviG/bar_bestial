package packVista;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import packControlador.ClienteBD;

public class VentanaRanking extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static VentanaRanking miVentanaRanking;

	/**
	 * Launch the application.
	 */
	public void empezar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRanking frame = getVentanaRanking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public VentanaRanking() throws SQLException {
		setTitle("Ranking de Puntuaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Rellenar las tablas con datos de la BBDD
		JSONArray hola = ClienteBD.getClienteBD().obtenerRanking();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnCount(3);
		modelo.setColumnIdentifiers(new String[]{"usuario","puntos","fecha"});
		modelo.setRowCount(hola.length());
		for (int i = 0;i<hola.length();i++){
			JSONObject hh =hola.getJSONObject(i);
			if(i==0){			
				modelo.setValueAt("USUARIO", i, 0);
				modelo.setValueAt("PUNTOS", i, 1);
				modelo.setValueAt("FECHA", i, 2);
			}
			else{
			modelo.setValueAt(hh.getString("usuario"), i, 0);
			modelo.setValueAt(hh.getInt("puntos"), i, 1);
			modelo.setValueAt(hh.get("fecha"), i, 2);
			}
		}
		table = new JTable();
		table.setModel(modelo);
		table.setBounds(30, 32, 377, 190);
		contentPane.add(table);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miVentanaRanking.setVisible(false);
				miVentanaRanking = null;
				//ACCEDER AL MENÚ
			}
		});
		btnVolver.setBounds(318, 228, 89, 23);
		contentPane.add(btnVolver);
	}
	
	public static VentanaRanking getVentanaRanking() throws SQLException {
		if (miVentanaRanking == null) {
			miVentanaRanking = new VentanaRanking();
			VentanaMenu.getMenu().main();
		}
		return miVentanaRanking;
	}
}