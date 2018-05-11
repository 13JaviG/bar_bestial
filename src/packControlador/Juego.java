/**
 * 
 */
package packControlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;

import packModelo.Animal;
import packModelo.BarBestial;
import packModelo.CPU;
import packModelo.Carta;
import packModelo.CartaFactory;
import packModelo.ColaDelBar;
import packModelo.EnumColor;
import packModelo.Jugador;

/**
 * Representa el Juego Bar Bestial.
 */
public class Juego extends Observable {
	
	public static final EnumColor jugadorColor = EnumColor.AZUL;
	public static final EnumColor cpuColor = EnumColor.VERDE;

	private static Juego miJuego;
	
	private Jugador jugador;
	private CPU cpu;
	private int turno;
	private String usuarioSesion;
	
	private Juego() {
		jugador = new Jugador(jugadorColor);
		cpu = new CPU(cpuColor);
		turno = 0;
	}
	
	public static Juego getJuego() {
		if (miJuego == null) {
			miJuego = new Juego();
		}
		return miJuego;
	}
	
	/**
	 * Setter para el nombre del usuario que ha iniciado sesion.
	 * @param pUsuario
	 */
	public void setUsuarioSesion(String pUsuario) {
		this.usuarioSesion = pUsuario;
	}
	
	
	/**
	 * Compara las puntuaciones para saber si el jugador humano ha ganado.
	 * @return
	 */
	public boolean haGanadoJugador() {
		System.out.println(jugador.calcularPuntuacion()+"   "+cpu.calcularPuntuacion());
		return (jugador.calcularPuntuacion() > cpu.calcularPuntuacion());
	}
	
	/**
	 * Devuelve true si es fin del juego, false si no lo es.
	 * @return
	 */
	public boolean esFinDelJuego() {
		
		return (!jugador.tieneCartas() || !cpu.tieneCartas());
	}
	
	/**
	 * Inicia una nueva partida.
	 */
	public void juegoNuevo() {
		try {
			rellenarMazos();
			robarInicial();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jugarPartida();
	}
	
	/**
	 * Inicializa las cartas de cada uno pero no empieza el juego.
	 */
	public void testJuegoNuevo() {
		try {
			rellenarMazos();
			robarInicial();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Rellena las cartas de los mazos de los jugadores y las baraja.
	 * @throws Exception
	 */
	private void rellenarMazos() throws Exception {
		for(int i = 1; i <= 12; i++) {
			Animal anim = CartaFactory.getCartaFactory().crearCarta(i);
			jugador.addCarta(new Carta(i, jugadorColor, anim));
			cpu.addCarta(new Carta(i, cpuColor, anim));
		}
		jugador.barajar();
		cpu.barajar();
	}
	
	/**
	 * Coge las primeras 4 cartas del mazo como mano inicial
	 */
	private void robarInicial() {
		
		for(int i = 0; i<4; i++){
			jugador.cogerCarta();
			cpu.cogerCarta();
		}		
	}
	
	
	
	/**
	 * Imprime la informaci�n de las cartas de los jugadores.
	 */
	public void imprimirCartasJugadores() {
		System.out.println("########### Cartas Jugador ###########");
		System.out.println("----------- Mazo -----------");
		jugador.imprimirCartasMazo();
		System.out.println("----------- Mano -----------");
		jugador.imprimirCartasMano();
		
		System.out.println();
		System.out.println();
		System.out.println("########### Cartas CPU ###########");
		System.out.println("----------- Mazo -----------");
		cpu.imprimirCartasMazo();
		System.out.println("----------- Mano -----------");
		cpu.imprimirCartasMano();
	}
	
	/**
	 * Devuelve el n�mero de cartas de la mano del jugador
	 * @return
	 */
	public int numCartasManoJugador(){
		return jugador.numCartasMano();

	}
	
	/**
	 * Devuelve el n�mero de cartas del mazo del jugador
	 * @return
	 */
	public int numCartasMazoJugador()
	{
		return jugador.numCartasMazo();
	}
	
	
	/**
	 * El jugador coge una carta
	 */
	public void cogerCartaJugador()
	{
		if(numCartasMazoJugador()>0){
			jugador.cogerCarta();	
		}
		
	}
	/**
	 * Distribuye los turnos
	 * Empieza jugador
	 * */
	public void jugarPartida() {
		int ronda = 1;
		while (!esFinDelJuego()) {

			System.out.println("\n\n############# RONDA " + ronda + " ##################");
			System.out.println("------------------Campo:-----------------");
			ColaDelBar.getColaDelBar().imprimirColaDelBar();
			System.out.println("-----------------------------------------");

			System.out.println("\nTURNO DE JUGADOR.");
			System.out.println("Mano:");
			jugador.imprimirCartasMano();
			jugarJugador();
			System.out.println("------------------Campo:-----------------");
			ColaDelBar.getColaDelBar().imprimirColaDelBar();
			System.out.println("-----------------------------------------");
			System.out.println("Se ejecutan animaladas recurrentes...");
			ColaDelBar.getColaDelBar().hacerAnimaladasR();
			System.out.println("------------------Campo:-----------------");
			ColaDelBar.getColaDelBar().imprimirColaDelBar();
			System.out.println("-----------------------------------------");

			System.out.println("\nTURNO DE CPU.");
			System.out.println("CPU - coloca carta.");
			jugarCPU();
			System.out.println("------------------Campo:-----------------");
			ColaDelBar.getColaDelBar().imprimirColaDelBar();
			System.out.println("-----------------------------------------");
			System.out.println("Se ejecutan animaladas recurrentes...");
			ColaDelBar.getColaDelBar().hacerAnimaladasR();
			System.out.println("------------------Campo:-----------------");
			ColaDelBar.getColaDelBar().imprimirColaDelBar();
			System.out.println("-----------------------------------------");
			ronda++;
		}
		System.out.println("ha ganado jugador?"+haGanadoJugador());		
	}
	
	/**
	 * Juega una ronda en lugar de ser un bucle de todo el juego, útil para la ventana del juego.
	 */
	public void jugarRonda(int pIndiceCartaJugador) {
		this.notifyObservers(this.toJson());
		Carta temp=jugador.jugar(pIndiceCartaJugador);
		ColaDelBar.getColaDelBar().addCarta(temp);
		temp.hacerAnimalada();
		jugador.cogerCarta();
		this.jugarCPU();
		this.notifyObservers(this.toJson());
	}

	/**
	 * Hace que la CPU juegue.
	 */
	private void jugarCPU() {
		Random  rng=new Random();
		int numCartas = cpu.numCartasMano();
		Carta cartaCPU = cpu.jugar(rng.nextInt(numCartas));
		ColaDelBar.getColaDelBar().addCarta(cartaCPU);
		cartaCPU.hacerAnimalada();
		cpu.cogerCarta();
	}

	/** 
	 * jugador eligue pos de carta que quiere jugar la anade a la cola del bar
	 * hace su animalada y la animalada
	 * */
	private void jugarJugador() {

		Carta temp=null;
		Scanner teclado=new Scanner(System.in);
		boolean avanza=false;
		while(!avanza) {
			try{
				System.out.println("introduce la posicion de la carta a jugar");
				temp=jugador.jugar(teclado.nextInt()-1);
				ColaDelBar.getColaDelBar().addCarta(temp);
				temp.hacerAnimalada();
				avanza=true;
				jugador.cogerCarta();
			}catch(InputMismatchException e) {
				System.out.println("introduzca un numero");
				teclado.nextLine();
			}catch(IndexOutOfBoundsException e) {
				System.out.println("introduzca una posicion valida max "+jugador.numCartasMano());
			}
		}
		
	}
	
	/**
	 * Devuelve una representación en JSON del juego entero.
	 * @return
	 */
	public String toJson() {
		JSONObject json = new JSONObject();
		JSONObject jsonCola = new JSONObject(ColaDelBar.getColaDelBar().toJson());
		JSONObject jsonBar = new JSONObject(BarBestial.getBarBestial().toJson());
		JSONObject jsonJugador = new JSONObject(jugador.toJson());
		JSONObject jsonCPU = new JSONObject(cpu.toJson());
		
		json.put("partida_terminada", this.esFinDelJuego());
		json.put("cola_del_bar", jsonCola);
		json.put("bar_bestial", jsonBar);
		json.put("jugador", jsonJugador);
		json.put("cpu", jsonCPU);

		return json.toString(2);
	}
}

