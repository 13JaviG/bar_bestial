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

class TestAnimaladas {
	EnumColor jugarColor = Juego.jugadorColor;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		ColaDelBar.getColaDelBar().vaciar();
	}

	@Test
	void testLeon() throws Exception {
		System.out.println("leon");
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(4,jugarColor,CartaFactory.getCartaFactory().crearCarta(4)));
		Carta leon=new Carta(12,jugarColor,CartaFactory.getCartaFactory().crearCarta(12));
		ColaDelBar.getColaDelBar().addCarta(leon);
		leon.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(leon,ColaDelBar.getColaDelBar().getCarta(0));
	}
	@Test
	void testFoca() throws Exception {
		System.out.println("foca");
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(4,jugarColor,CartaFactory.getCartaFactory().crearCarta(4)));
		Carta foca=new Carta(6,jugarColor,CartaFactory.getCartaFactory().crearCarta(6));
		ColaDelBar.getColaDelBar().addCarta(foca);
		foca.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(foca,ColaDelBar.getColaDelBar().getCarta(0));
	}
	@Test
	void testSerpiente() throws Exception {
		System.out.println("Serpiente");
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(4,jugarColor,CartaFactory.getCartaFactory().crearCarta(4)));
		Carta serpiente=new Carta(9,jugarColor,CartaFactory.getCartaFactory().crearCarta(9));
		ColaDelBar.getColaDelBar().addCarta(serpiente);
		serpiente.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(serpiente,ColaDelBar.getColaDelBar().getCarta(0));
	}
	@Test
	void testCamaleon() throws Exception {
		System.out.println("Camaleon");
		Carta pruebaCSerp=new Carta(9,jugarColor,CartaFactory.getCartaFactory().crearCarta(9));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(pruebaCSerp);
		Carta camaleon=new Carta(5,jugarColor,CartaFactory.getCartaFactory().crearCarta(5));
		ColaDelBar.getColaDelBar().addCarta(camaleon);
		camaleon.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(pruebaCSerp,ColaDelBar.getColaDelBar().getCarta(0));
	}

	@Test
	void testCanguro() throws Exception {
		System.out.println("\nCanguro");
		Carta canguro = new Carta(3,jugarColor,CartaFactory.getCartaFactory().crearCarta(3));
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor, CartaFactory.getCartaFactory().crearCarta(1)));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor, CartaFactory.getCartaFactory().crearCarta(2)));
		ColaDelBar.getColaDelBar().addCarta(canguro);
		System.out.println("Estado del bar antes del salto");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		canguro.hacerAnimalada();
		System.out.println("Estado del bar después del salto");
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
	}
}
