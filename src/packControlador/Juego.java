/**
 * 
 */
package packControlador;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import packModelo.Animal;
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
	 * Rellena las cartas de los mazos de los jugadores y las baraja.
	 * @throws Exception
	 */
	private void rellenarMazos() throws Exception {
		for(int i = 1; i <= 12; i++) {
			Animal animJug = CartaFactory.getCartaFactory().crearCarta(i);
			jugador.addCarta(new Carta(i, jugadorColor, animJug));
			Animal animCPU = CartaFactory.getCartaFactory().crearCarta(i);
			cpu.addCarta(new Carta(i, cpuColor, animCPU));
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
		while (!esFinDelJuego()) {
			jugarJugador();
			ColaDelBar.getColaDelBar().hacerAnimaladasR();
			jugarCPU();
			ColaDelBar.getColaDelBar().hacerAnimaladasR();
		}
		System.out.println("ha ganado jugador?"+haGanadoJugador());		
	}
	/** 
	 * jugador eligue pos de carta que quiere jugar la anade a la cola del bar
	 * hace su animalada y la animalada
	 * */
	private void jugarJugador() {
		Random  rng=new Random();
		int numCartas = jugador.numCartasMano();
		// TODO coge random de momento para hacer tests
		Carta cartaJugador = jugador.jugar(rng.nextInt(numCartas));
		ColaDelBar.getColaDelBar().addCarta(cartaJugador);
		// TODO si la carta requiere input pedirlo
		cartaJugador.hacerAnimalada();
		jugador.cogerCarta();
	}

	/**
	 * Hace que la CPU juegue.
	 */
	private void jugarCPU() {
		Random  rng=new Random();
		int numCartas = cpu.numCartasMano();
		Carta cartaCPU = cpu.jugar(rng.nextInt(numCartas));
		ColaDelBar.getColaDelBar().addCarta(cartaCPU);
		// TODO si la carta requiere input darle uno aleatorio
		cartaCPU.hacerAnimalada();
		cpu.cogerCarta();
	}
}
