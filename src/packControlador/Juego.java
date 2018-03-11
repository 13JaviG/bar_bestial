/**
 * 
 */
package packControlador;

import packModelo.CPU;
import packModelo.Carta;
import packModelo.CartaFactory;
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
		Carta cartaCPU = cpu.jugar();
		// TODO implementar
	}
	
	/**
	 * Compara las puntuaciones para saber si el jugador humano ha ganado.
	 * @return
	 */
	public boolean haGanadoJugador() {
		return (jugador.calcularPuntuacion() > cpu.calcularPuntuacion());
	}
	
	/**
	 * Devuelve true si es fin del juego, false si no lo es.
	 * @return
	 */
	public boolean esFinDelJuego() {
		// TODO implementar
		return false;
	}
	
	/**
	 * Inicia una nueva partida.
	 */
	public void juegoNuevo() {
		try {
			rellenarMazos();
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
			jugador.addCarta(CartaFactory.getCartaFactory().crearCarta(i, jugadorColor));
			cpu.addCarta(CartaFactory.getCartaFactory().crearCarta(i, cpuColor));
		}
		jugador.barajar();
		cpu.barajar();
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
	

}