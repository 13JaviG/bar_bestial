package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packControlador.Juego;
import packModelo.CartaFactory;
import packModelo.ColaDelBar;
import packModelo.EnumColor;
import packModelo.Jugador;

public class TestCogerCartas {
	
	
	
	@Test
	public void test() {
		Juego.getJuego().juegoNuevo();
		/*#Case primera vez que robas carta, se roban 4 y el mazo tiene 4 menos, es decir 8 */
		assertEquals(4, Juego.getJuego().numCartasManoJugador());
		assertEquals(8, Juego.getJuego().numCartasMazoJugador());
		/*#Case robar una carta distinta a la inicial, el jugador tiene una carta más en mano,
		 * es decir, 5 y el mazo una menos, 7*/
		Juego.getJuego().cogerCartaJugador();
		assertEquals(5, Juego.getJuego().numCartasManoJugador());
		assertEquals(7, Juego.getJuego().numCartasMazoJugador());
	}

}
