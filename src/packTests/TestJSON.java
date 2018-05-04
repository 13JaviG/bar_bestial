package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packControlador.Juego;
import packModelo.Carta;
import packModelo.CartaFactory;
import packModelo.ListaCartas;

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
	
	@Test
	void testCartaEnLista() throws Exception {
		ListaCartas lista = new ListaCartas();
		Carta carta1 = new Carta(2, Juego.jugadorColor, CartaFactory.getCartaFactory().crearCarta(2));
		Carta carta2 = new Carta(3, Juego.jugadorColor, CartaFactory.getCartaFactory().crearCarta(3));
		Carta carta3 = new Carta(4, Juego.jugadorColor, CartaFactory.getCartaFactory().crearCarta(4));
		lista.addCarta(carta1);
		lista.addCarta(carta2);
		lista.addCarta(carta3);
		
		System.out.println(lista.toJson());
		
		JSONObject json = new JSONObject(lista.toJson());
		JSONArray listaJson = new JSONArray(json.get("cartas").toString());

		JSONObject jsonCarta = (JSONObject) listaJson.get(1);

		assertEquals(3, jsonCarta.getInt("numero"));
		assertEquals("azul", jsonCarta.getString("color"));
		assertEquals("canguro", jsonCarta.getString("animal"));
	}
	
	

}
