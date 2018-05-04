package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packControlador.Juego;
import packModelo.Carta;
import packModelo.CartaFactory;

class TestJSON {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCarta() throws Exception {
		Carta carta = new Carta(3, Juego.jugadorColor, CartaFactory.getCartaFactory().crearCarta(3));
		String jsonString = carta.toJson();
		JSONObject json = new JSONObject(jsonString);
		assertEquals(3, json.getInt("numero"));
		assertEquals("azul", json.getString("color"));
		assertEquals("canguro", json.getString("animal"));
	}

}
