package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packModelo.Carta;
import packModelo.ColaDelBar;
import packModelo.EnumColor;

class TestAnimaladas {
	EnumColor jugarColor=EnumColor.AZUL;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		ColaDelBar.getColaDelBar().vaciar();
	}

	@Test
	void testLeon() throws Exception {
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor));
		ColaDelBar.getColaDelBar().addCarta(new Carta(4,jugarColor));
		Carta leon=new Carta(12,jugarColor);
		ColaDelBar.getColaDelBar().addCarta(leon);
		leon.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(leon,ColaDelBar.getColaDelBar().getCarta(0));
	}
	@Test
	void testFoca() throws Exception {
		ColaDelBar.getColaDelBar().addCarta(new Carta(1,jugarColor));
		ColaDelBar.getColaDelBar().addCarta(new Carta(2,jugarColor));
		ColaDelBar.getColaDelBar().addCarta(new Carta(4,jugarColor));
		Carta foca=new Carta(6,jugarColor);
		ColaDelBar.getColaDelBar().addCarta(foca);
		foca.hacerAnimalada();
		ColaDelBar.getColaDelBar().imprimirColaDelBar();
		assertEquals(foca,ColaDelBar.getColaDelBar().getCarta(0));
	}

}
