package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.xml.internal.ws.assembler.dev.ServerTubelineAssemblyContext;

import packControlador.ClienteBD;
import packControlador.Juego;
import packModelo.ColaDelBar;

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
	private boolean estadoAnterior;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					Juego.getJuego().addObserver(window);
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
		JSONObject temp=new JSONObject(Juego.getJuego().toJson());
		ponerCartasJugador(temp.getJSONObject("jugador"));
		estadoAnterior=false;
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
			lblColaCarta3 = new JLabel(" ");
		}
		return lblColaCarta3;
	}
	private JLabel getLblColaCarta4() {
		if (lblColaCarta4 == null) {
			lblColaCarta4 = new JLabel(" ");
		}
		return lblColaCarta4;
	}
	private JLabel getLblColaCarta2() {
		if (lblColaCarta2 == null) {
			lblColaCarta2 = new JLabel(" ");
		}
		return lblColaCarta2;
	}
	private JLabel getLblColaCarta1() {
		if (lblColaCarta1 == null) {
			lblColaCarta1 = new JLabel(" ");
		}
		return lblColaCarta1;
	}
	private JLabel getLblColaEntrada() {
		if (lblColaEntrada == null) {
			String dir = System.getProperty("user.dir");
			Path path= Paths.get(dir, "src","packImagenes","cartas","puerta-del-cielo.png");
			lblColaEntrada = new JLabel(cargarImagen(path));
		}
		return lblColaEntrada;
	}
	private JLabel getLblColaCarta5() {
		if (lblColaCarta5 == null) {
			lblColaCarta5 = new JLabel(" ");
		}
		return lblColaCarta5;
	}
	private JLabel getLblColaEsLoQueHay() {
		if (lblColaEsLoQueHay == null) {
			String dir = System.getProperty("user.dir");
			Path path= Paths.get(dir, "src","packImagenes","cartas","es-lo-que-hay.png");
			lblColaEsLoQueHay = new JLabel(cargarImagen(path));
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
			btnCarta1 = new JButton(" ");
			btnCarta1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					desactivarBotones();
					Juego.getJuego().jugarRonda(0);
				}
			});
		}
		return btnCarta1;
	}
	private JButton getBtnCarta2() {
		if (btnCarta2 == null) {
			btnCarta2 = new JButton(" ");
			btnCarta2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					desactivarBotones();
					Juego.getJuego().jugarRonda(1);
				}
			});
		}
		return btnCarta2;
	}
	private JButton getBtnCarta3() {
		if (btnCarta3 == null) {
			btnCarta3 = new JButton(" ");
			btnCarta3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					desactivarBotones();
					Juego.getJuego().jugarRonda(2);
				}
			});
		}
		return btnCarta3;
	}
	private JButton getBtnCarta4() {
		if (btnCarta4 == null) {
			btnCarta4 = new JButton(" ");
			btnCarta4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					desactivarBotones();
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
			String dir = System.getProperty("user.dir");
			Path path= Paths.get(dir, "src","packImagenes","cartas","cara-trasera.png");
			lblCPUCarta1 = new JLabel(cargarImagen(path));
		}
		return lblCPUCarta1;
	}
	private JLabel getLblCPUCarta2() {
		if (lblCPUCarta2 == null) {
			String dir = System.getProperty("user.dir");
			Path path= Paths.get(dir, "src","packImagenes","cartas","cara-trasera.png");
			lblCPUCarta2 = new JLabel(cargarImagen(path));
		}
		return lblCPUCarta2;
	}
	private JLabel getLblCPUCarta3() {
		if (lblCPUCarta3 == null) {
			String dir = System.getProperty("user.dir");
			Path path= Paths.get(dir, "src","packImagenes","cartas","cara-trasera.png");
			lblCPUCarta3 = new JLabel(cargarImagen(path));
		}
		return lblCPUCarta3;
	}
	private JLabel getLblCPUCarta4() {
		if (lblCPUCarta4 == null) {
			String dir = System.getProperty("user.dir");
			Path path= Paths.get(dir, "src","packImagenes","cartas","cara-trasera.png");
			lblCPUCarta4 = new JLabel(cargarImagen(path));
		}
		return lblCPUCarta4;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		desactivarBotones();
		System.out.println("probando que recibe el update");
		String jsonString = (String) arg1;
		JSONObject json = new JSONObject(jsonString);
		JSONObject jsonCola=json.getJSONObject("cola_del_bar");
		JSONObject jsonJugador=json.getJSONObject("jugador");
		JSONObject jsonCPU=json.getJSONObject("cpu");
		ponerCartasCPU(jsonCPU);
		ponerCartasCola(jsonCola);
		ponerCartasJugador(jsonJugador);
		// TODO Usar la info del json para poner las cartas en la pantalla
		// TODO tener en cuenta que si la foca a cambiado el orden la cola del bar se rellena al reves, en el json de la cola te dice si es normal o cambiar de sitio la entrada
		// TODO poner como activos solo los botones del jugador que tengan cartas, si no lo tienen desactivar los botones
		botonesActivos(jsonJugador);
		if (json.getBoolean("partida_terminada")) 
		{
			frame.dispose();
			try {
				VentanaRanking.getVentanaRanking().empezar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void ponerCartasJugador(JSONObject pJsonJugador) {
		vaciarBotones();
		JSONObject mano=pJsonJugador.getJSONObject("mano");
		JSONArray cartas=mano.getJSONArray("cartas");
		int numeroCartas=mano.getInt("cuantas");
		for(int i=0;i<numeroCartas;i++) {
			JSONObject cartaActual=cartas.getJSONObject(i);
			int posicion=cartaActual.getInt("indice");
			String color=cartaActual.getString("color");
			int num=cartaActual.getInt("numero");
			ImageIcon image=elegirIcono(color, num);
			switch (posicion) {
			case 0:
				btnCarta1.setIcon(image);
				break;
			case 1:
				btnCarta2.setIcon(image);
				break;
			case 2:
				btnCarta3.setIcon(image);
				break;
			case 3:
				btnCarta4.setIcon(image);
				break;
				default:
			}
			
		}
	}
/**
 * vacia los iconos de los botones
 */
	private void vaciarBotones() {
		// TODO Auto-generated method stub
		btnCarta1.setIcon(null);
		btnCarta2.setIcon(null);
		btnCarta3.setIcon(null);
		btnCarta4.setIcon(null);
	}
/**
 * selecciona cual de los 2 metodos de colocacion de la cola debe usar
 * @param pJsonCola
 */
	private void ponerCartasCola(JSONObject pJsonCola) {
		vaciarCartasCola();
		int cuantas=pJsonCola.getInt("cuantas");
		System.out.println("LLega hasta aqui "+cuantas);
		boolean intercambiado=pJsonCola.getBoolean("entrada_intercambiada");
		JSONArray cartas=pJsonCola.getJSONArray("cartas");
		if(intercambiado) {
			colocarColaIntercambiada(cuantas,cartas);
			if(estadoAnterior!=intercambiado) {
				estadoAnterior=intercambiado;
				intercambiarExtremos();
			}
		}else {
			colocarCola(cuantas,cartas);
			if(estadoAnterior!=intercambiado) {
				estadoAnterior=intercambiado;
				intercambiarExtremos();
				}
		}
		
	}
/**
 * intercambia los iconos de es lo que hay y bar bestial
 */
private void intercambiarExtremos() {
	// TODO Auto-generated method stub
	Icon aux=lblColaEntrada.getIcon();
	lblColaEntrada.setIcon(lblColaEsLoQueHay.getIcon());
	lblColaEsLoQueHay.setIcon(aux);
}

/**
 * borra los iconos label que forman la cola
 */
	private void vaciarCartasCola() {
		// TODO Auto-generated method stub
		lblColaCarta1.setIcon(null);
		lblColaCarta2.setIcon(null);
		lblColaCarta3.setIcon(null);
		lblColaCarta4.setIcon(null);
		lblColaCarta5.setIcon(null);
	}
/**
 * coloca en los label cola los iconos de los animales en la cola del bar
 * @param pCuantas
 * @param pCartas
 */
	private void colocarCola(int pCuantas, JSONArray pCartas) {
		for(int i = 0;i<pCuantas;i++) {
			JSONObject cartaActual=pCartas.getJSONObject(i);
			int posicion=cartaActual.getInt("indice");
			ImageIcon a=elegirIcono(cartaActual.getString("color"),cartaActual.getInt("numero"));
			switch (posicion) {
			case 0:
				lblColaCarta1.setIcon(a);
				break;
			case 1:
				lblColaCarta2.setIcon(a);
				break;
			case 2:
				lblColaCarta3.setIcon(a);
				break;
			case 3:
				lblColaCarta4.setIcon(a);
				break;
			case 4:
				lblColaCarta5.setIcon(a);
				break;
			}
		}
	}
/**
 * coloca las cartas de manera inversa 
 * @param pCuantas
 * @param pCartas
 */
	private void colocarColaIntercambiada(int pCuantas, JSONArray pCartas) {
		for(int i = 0;i<pCuantas;i++) {
			JSONObject cartaActual=pCartas.getJSONObject(i);
			int posicion=cartaActual.getInt("indice");
			ImageIcon a=elegirIcono(cartaActual.getString("color"),cartaActual.getInt("numero"));
			switch (posicion) {
			case 0:
				lblColaCarta5.setIcon(a);
				break;
			case 1:
				lblColaCarta4.setIcon(a);
				break;
			case 2:
				lblColaCarta3.setIcon(a);
				break;
			case 3:
				lblColaCarta2.setIcon(a);
				break;
			case 4:
				lblColaCarta1.setIcon(a);
				break;
			}
		}
	}
/**
 * se encarga de devolver el icono animal que le corresponde
 * @param pColor
 * @param pNumero
 * @return
 */
	private ImageIcon elegirIcono(String pColor, int pNumero) {
		// TODO Auto-generated method stub
		String dir = System.getProperty("user.dir");
		Path path= Paths.get(dir, "src","packImagenes","cartas");
		Path rutaColor;
		if (pColor.equals("verde")) {
			rutaColor=Paths.get(path.toString(),"verde");
		}else {
			rutaColor=Paths.get(path.toString(),"azul");
		}
		path=Paths.get(rutaColor.toString(),pNumero+".png");
		return cargarImagen(path);
	}
/**
 * pone en los label de la cpu los iconos segun el numero de cartas que tenga
 * @param pJsonCPU
 */
	private void ponerCartasCPU(JSONObject pJsonCPU) {
		// TODO Auto-generated method stub
		JSONObject jsonMano=pJsonCPU.getJSONObject("mano");
		int numCartas=jsonMano.getInt("cuantas");
		if(!(numCartas==4)) {
			switch (numCartas){
			case 3:
				lblCPUCarta4.setIcon(null);
				break;
			case 2:
				lblCPUCarta3.setIcon(null);
				break;
			case 1:
				lblCPUCarta2.setIcon(null);
				break;
			default:
				lblCPUCarta1.setIcon(null);
				lblCPUCarta2.setIcon(null);
				lblCPUCarta3.setIcon(null);
				lblCPUCarta4.setIcon(null);
				
			}				
		}
	}
	

/**
 * inabilita los botones para que no salte ningun listener mientras otro esta en marcha
 */
	private void desactivarBotones() {
		// TODO Auto-generated method stub
		btnCarta1.setEnabled(false);
		btnCarta2.setEnabled(false);
		btnCarta3.setEnabled(false);
		btnCarta4.setEnabled(false);
	}
/**
 * activa los botones segun las cartas que tenga el jugador
 * @param pJsonJugador 
 */
	private void botonesActivos(JSONObject pJsonJugador) {
		JSONObject mano=pJsonJugador.getJSONObject("mano");
		int cuantasCartas=mano.getInt("cuantas");
		switch (cuantasCartas) {
		case 4:
			btnCarta1.setEnabled(true);
			btnCarta2.setEnabled(true);
			btnCarta3.setEnabled(true);
			btnCarta4.setEnabled(true);
			break;
		case 3:
			btnCarta1.setEnabled(true);
			btnCarta2.setEnabled(true);
			btnCarta3.setEnabled(true);
			break;
		case 2:
			btnCarta1.setEnabled(true);
			btnCarta2.setEnabled(true);
			break;
		case 1:
			btnCarta1.setEnabled(true);
			break;
		default:
		}
	}
/**
 * transforma la foto indicada en el path en ImageIcon
 * @param pPath
 * @return
 */
	private ImageIcon cargarImagen(Path pPath) {
		// #####################################################################
				// ejemplo de como poner una imagen
				// seria buena idea sacar todo esto a una funcion
				BufferedImage wPic;
				ImageIcon imagen=null;
				try {
					// TODO el codigo para obtener la imagen debería ser multiplataforma (windows, linux)
					wPic = ImageIO.read(pPath.toFile());
					// importante escalar la imagen
					Image newimg = wPic.getScaledInstance(100, 200,  java.awt.Image.SCALE_SMOOTH);
					// convertirla en un icono para ponerlo en los labels
					imagen = new ImageIcon(newimg);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				// fin de ejemplo de como poner una imagen
				// #####################################################################
				return imagen;
	}
}
