/**
 * 
 */
package packControlador;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import packModelo.CPU;
import packModelo.Carta;
import packModelo.CartaFactory;
import packModelo.ColaDelBar;
import packModelo.EnumColor;
import packModelo.Jugador;
import packModelo.ListaCartas;

/**
 * Representa el Juego Bar Bestial.
 */
public class Juego {
	
	private static EnumColor jugadorColor = EnumColor.AZUL;
	private static EnumColor cpuColor = EnumColor.VERDE;
	
	private static Juego miJuego;
	private Jugador jugador;
	private CPU cpu;
	private int turno;
	
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
	 * Hace que la CPU juegue.
	 */
	private void jugarCPU() {
		Random  rng=new Random();
		Carta cartaCPU = cpu.jugar(rng.nextInt(cpu.numCartasMano()));
		ColaDelBar.getColaDelBar().addCarta(cartaCPU);
		cartaCPU.hacerAnimalada();
		cpu.cogerCarta();
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
		
		return !(jugador.tieneCartas() || cpu.tieneCartas());
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
	 * Rellena las cartas de los mazos de los jugadores y las baraja.
	 * @throws Exception
	 */
	private void rellenarMazos() throws Exception {
		for(int i = 1; i <= 12; i++) {
			jugador.addCarta(CartaFactory.getCartaFactory().crearCarta(i, jugadorColor));
			cpu.addCarta(CartaFactory.getCartaFactory().crearCarta(i, cpuColor));
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
		jugador.cogerCarta();
	}
	/**
	 * Distribuye los turnos
	 * Empieza jugador
	 * */
	public void jugarPartida() {
		while (!esFinDelJuego()) {
			jugarJugador();
			ColaDelBar.getColaDelBar().hacerAnimaladasR();
			jugarCPU();
			ColaDelBar.getColaDelBar().hacerAnimaladasR();
		}
		System.out.println("ha ganado jugador?"+haGanadoJugador());		
	}
	/** 
	 * Se encarga de realizar las acciones de las que consiste un turno 
	 * para el jugador
	 * */
	private void jugarJugador() {
		Carta temp=null;
		Scanner scn=new Scanner(System.in);
		boolean avanza=false;
		while(!avanza) {
			jugador.imprimirCartasMano();
			try{
				System.out.println("introduce la posicion de la carta a jugar");
				temp=jugador.jugar(scn.nextInt()-1);
				ColaDelBar.getColaDelBar().addCarta(temp);
				temp.hacerAnimalada();
				avanza=true;
				jugador.cogerCarta();
			}catch(InputMismatchException e) {
				System.out.println("introduzca un numero");
			}catch(IndexOutOfBoundsException e) {
				System.out.println("introduzca una posicion valida max "+jugador.numCartasMano());
			}
		}
	}
}
