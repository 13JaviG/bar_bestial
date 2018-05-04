/**
 * 
 */
package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packControlador.Juego;
import packModelo.Carta;
import packModelo.CartaFactory;
import packModelo.ColaDelBar;
import packModelo.EnumColor;

/**
 * @author ander
 *
 */
class TestCamaleon {

	EnumColor jugarColor = Juego.jugadorColor;
	EnumColor cpuColor = Juego.cpuColor;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws Exception {
		System.out.println("Camaleon");
		Carta pruebaCSerp=new Carta(9,jugarColor,CartaFactory.getCartaFactory().crearCarta(9));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(3,jugarColor, CartaFactory.getCartaFactory().crearCarta(3)));
		ColaDelBar.getColaDelBar().addCarta(pruebaCSerp);
		Carta camaleon=new Carta(5,jugarColor,CartaFactory.getCartaFactory().crearCarta(5));
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		System.out.println("hace animalada");
		ColaDelBar.getColaDelBar().addCarta(camaleon);
		camaleon.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
	}

}
