/**
 * 
 */
package packTests;


import org.junit.jupiter.api.Test;

import packControlador.Juego;

/**
 * Librer�a usada: jUnit 5
 * 
 * Tests para las cartas que tienen los jugadores.
 */
class TestCartasJugadores {

	@Test
	void test() {
		Juego.getJuego().juegoNuevo();
		Juego.getJuego().imprimirCartasJugadores();
	}

}
