/**
 * 
 */
package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import packControlador.Juego;

/**
 * Librería usada: jUnit 5
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
