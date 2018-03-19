package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import packControlador.Juego;

class TestFinDeJuego {

	@Test
	void finDeJuego() {
		assertEquals(true,Juego.getJuego().esFinDelJuego());
		Juego.getJuego().juegoNuevo();
		Juego.getJuego().imprimirCartasJugadores();
		assertEquals(false,Juego.getJuego().esFinDelJuego());
	}

}
