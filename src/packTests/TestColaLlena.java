package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packModelo.Animal;
import packModelo.BarBestial;
import packModelo.Carta;
import packModelo.CartaFactory;
import packModelo.ColaDelBar;
import packModelo.EnumColor;
import packModelo.EsLoQueHay;

class TestColaLlena {

	@BeforeEach
	void setUp() throws Exception {
		for (int i = 1; i <= 5; i++) {
			Animal anim = CartaFactory.getCartaFactory().crearCarta(i);
			ColaDelBar.getColaDelBar().addCarta(new Carta(i, EnumColor.AZUL, anim));
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		ColaDelBar.getColaDelBar().vaciar();
	}

	@Test
	void colaLlena() {
		/*#Case cola llena */
		assertEquals(true,ColaDelBar.getColaDelBar().estaLlena());
		/*#Case cola no llena */
		ColaDelBar.getColaDelBar().rmvCarta(4);
		assertEquals(false,ColaDelBar.getColaDelBar().estaLlena());
	}
	
	@Test
	void entranBarSalenCola() {
		/*#Case estan vacias */
		assertEquals(0,BarBestial.getBarBestial().cuantasCartas());
		assertEquals(0,EsLoQueHay.getEsLoQueHay().cuantasCartas());
		/*#Case fin de turno cola llena salen de cola del bar */
		ColaDelBar.getColaDelBar().hacerAnimaladasR();
		assertEquals(2,BarBestial.getBarBestial().cuantasCartas());
		assertEquals(1,EsLoQueHay.getEsLoQueHay().cuantasCartas());
		/*#Case fin de turno cola no llena no salen de cola del bar */
		ColaDelBar.getColaDelBar().hacerAnimaladasR();
		assertEquals(2,BarBestial.getBarBestial().cuantasCartas());
		assertEquals(1,EsLoQueHay.getEsLoQueHay().cuantasCartas());
	}

}
	


