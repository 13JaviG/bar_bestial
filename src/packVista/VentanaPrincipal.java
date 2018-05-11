package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.json.JSONObject;

import packControlador.Juego;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal implements Observer {

	private JFrame frame;
	private JPanel panelCartasCPU;
	private JPanel panelColaDelBar;
	private JPanel panelCartasJugador;
	private JLabel lblColaCarta3;
	private JLabel lblColaCarta4;
	private JLabel lblColaCarta2;
	private JLabel lblColaCarta1;
	private JLabel lblColaEntrada;
	private JLabel lblColaCarta5;
	private JLabel lblColaEsLoQueHay;
	private Component verticalStrut;
	private JPanel panel;
	private JButton btnCarta1;
	private JButton btnCarta2;
	private JButton btnCarta3;
	private JButton btnCarta4;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private Component verticalStrut_1;
	private JPanel panel_1;
	private JLabel lblCPUCarta1;
	private JLabel lblCPUCarta2;
	private JLabel lblCPUCarta3;
	private JLabel lblCPUCarta4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
		Juego.getJuego().addObserver(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPanelCartasCPU(), BorderLayout.NORTH);
		frame.getContentPane().add(getPanelColaDelBar(), BorderLayout.CENTER);
		frame.getContentPane().add(getPanelCartasJugador(), BorderLayout.SOUTH);
	}
	private JPanel getPanelCartasCPU() {
		if (panelCartasCPU == null) {
			panelCartasCPU = new JPanel();
			panelCartasCPU.setLayout(new BorderLayout(0, 0));
			panelCartasCPU.add(getMenuBar(), BorderLayout.NORTH);
			panelCartasCPU.add(getVerticalStrut_1(), BorderLayout.WEST);
			panelCartasCPU.add(getPanel_1(), BorderLayout.CENTER);
		}
		return panelCartasCPU;
	}
	private JPanel getPanelColaDelBar() {
		if (panelColaDelBar == null) {
			panelColaDelBar = new JPanel();
			panelColaDelBar.setLayout(new GridLayout(0, 7, 0, 0));
			panelColaDelBar.add(getLblColaEntrada());
			panelColaDelBar.add(getLblColaCarta1());
			panelColaDelBar.add(getLblColaCarta2());
			panelColaDelBar.add(getLblColaCarta3());
			panelColaDelBar.add(getLblColaCarta4());
			panelColaDelBar.add(getLblColaCarta5());
			panelColaDelBar.add(getLblColaEsLoQueHay());
		}
		return panelColaDelBar;
	}
	private JPanel getPanelCartasJugador() {
		if (panelCartasJugador == null) {
			panelCartasJugador = new JPanel();
			panelCartasJugador.setLayout(new BorderLayout(0, 0));
			panelCartasJugador.add(getVerticalStrut(), BorderLayout.WEST);
			panelCartasJugador.add(getPanel(), BorderLayout.CENTER);
		}
		return panelCartasJugador;
	}
	private JLabel getLblColaCarta3() {
		if (lblColaCarta3 == null) {
			lblColaCarta3 = new JLabel("New label");
		}
		return lblColaCarta3;
	}
	private JLabel getLblColaCarta4() {
		if (lblColaCarta4 == null) {
			lblColaCarta4 = new JLabel("New label");
		}
		return lblColaCarta4;
	}
	private JLabel getLblColaCarta2() {
		if (lblColaCarta2 == null) {
			lblColaCarta2 = new JLabel("New label");
		}
		return lblColaCarta2;
	}
	private JLabel getLblColaCarta1() {
		if (lblColaCarta1 == null) {
			lblColaCarta1 = new JLabel("New label");
		}
		return lblColaCarta1;
	}
	private JLabel getLblColaEntrada() {
		if (lblColaEntrada == null) {
			lblColaEntrada = new JLabel("New label");
		}
		return lblColaEntrada;
	}
	private JLabel getLblColaCarta5() {
		if (lblColaCarta5 == null) {
			lblColaCarta5 = new JLabel("New label");
		}
		return lblColaCarta5;
	}
	private JLabel getLblColaEsLoQueHay() {
		if (lblColaEsLoQueHay == null) {
			lblColaEsLoQueHay = new JLabel("New label");
		}
		return lblColaEsLoQueHay;
	}
	private Component getVerticalStrut() {
		if (verticalStrut == null) {
			verticalStrut = Box.createVerticalStrut(150);
		}
		return verticalStrut;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getBtnCarta1());
			panel.add(getBtnCarta2());
			panel.add(getBtnCarta3());
			panel.add(getBtnCarta4());
		}
		return panel;
	}
	private JButton getBtnCarta1() {
		if (btnCarta1 == null) {
			btnCarta1 = new JButton("New button");
			btnCarta1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Juego.getJuego().jugarRonda(0);
				}
			});
		}
		return btnCarta1;
	}
	private JButton getBtnCarta2() {
		if (btnCarta2 == null) {
			btnCarta2 = new JButton("New button");
			btnCarta2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Juego.getJuego().jugarRonda(1);
				}
			});
		}
		return btnCarta2;
	}
	private JButton getBtnCarta3() {
		if (btnCarta3 == null) {
			btnCarta3 = new JButton("New button");
			btnCarta3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Juego.getJuego().jugarRonda(2);
				}
			});
		}
		return btnCarta3;
	}
	private JButton getBtnCarta4() {
		if (btnCarta4 == null) {
			btnCarta4 = new JButton("New button");
			btnCarta4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Juego.getJuego().jugarRonda(3);
				}
			});
		}
		return btnCarta4;
	}
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMntmNewMenuItem_1());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("New menu");
			mnNewMenu.add(getMntmNewMenuItem());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("New menu item");
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("New menu item");
		}
		return mntmNewMenuItem_1;
	}
	private Component getVerticalStrut_1() {
		if (verticalStrut_1 == null) {
			verticalStrut_1 = Box.createVerticalStrut(150);
		}
		return verticalStrut_1;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(1, 0, 0, 0));
			panel_1.add(getLblCPUCarta1());
			panel_1.add(getLblCPUCarta2());
			panel_1.add(getLblCPUCarta3());
			panel_1.add(getLblCPUCarta4());
		}
		return panel_1;
	}
	private JLabel getLblCPUCarta1() {
		if (lblCPUCarta1 == null) {
			lblCPUCarta1 = new JLabel("New label");
		}
		return lblCPUCarta1;
	}
	private JLabel getLblCPUCarta2() {
		if (lblCPUCarta2 == null) {
			lblCPUCarta2 = new JLabel("New label");
		}
		return lblCPUCarta2;
	}
	private JLabel getLblCPUCarta3() {
		if (lblCPUCarta3 == null) {
			lblCPUCarta3 = new JLabel("New label");
		}
		return lblCPUCarta3;
	}
	private JLabel getLblCPUCarta4() {
		if (lblCPUCarta4 == null) {
			lblCPUCarta4 = new JLabel("New label");
		}
		return lblCPUCarta4;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String jsonString = (String) arg1;
		JSONObject json = new JSONObject(jsonString);
		// TODO Usar la info del json para poner las cartas en la pantalla
		// TODO tener en cuenta que si la foca a cambiado el orden la cola del bar se rellena al reves
		// TODO poner como activos solo los botones del jugador que tengan cartas, si no lo tienen desactivar los botones

		// #####################################################################
		// ejemplo de como poner una imagen
		// seria buena idea sacar todo esto a una funcion
		BufferedImage wPic;
		try {
			// TODO el codigo para obtener la imagen debería ser multiplataforma (windows, linux)
			wPic = ImageIO.read(this.getClass().getResource("../packImagenes/cartas/puerta-del-cielo.png"));
			// importante escalar la imagen
			Image newimg = wPic.getScaledInstance(100, 200,  java.awt.Image.SCALE_SMOOTH);
			// convertirla en un icono para ponerlo en los labels
			ImageIcon imagen = 	new ImageIcon(newimg);
			getLblCPUCarta4().setIcon(imagen);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// fin de ejemplo de como poner una imagen
		// #####################################################################
	}
}
