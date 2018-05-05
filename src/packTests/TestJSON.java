package packTests;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packControlador.Juego;
import packModelo.Animal;
import packModelo.Carta;
import packModelo.CartaFactory;
import packModelo.ColaDelBar;
import packModelo.EnumColor;
import packModelo.Jugador;
import packModelo.ListaCartas;

class TestJSON {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Comprueba que la carta tiene los valores correctos.
	 * @throws Exception
	 */
	@Test
	void testCarta() throws Exception {
		Carta carta = new Carta(3, Juego.jugadorColor, CartaFactory.getCartaFactory().crearCarta(3));
		String jsonString = carta.toJson();
		JSONObject json = new JSONObject(jsonString);
		assertEquals(3, json.getInt("numero"));
		assertEquals("azul", json.getString("color"));
		assertEquals("canguro", json.getString("animal"));
	}
	
	/**
	 * Comprueba si el json indica el numero de carta que toca.
	 * @throws Exception
	 */
	@Test
	void testCartaEnLista() throws Exception {
		ListaCartas lista = new ListaCartas();
		Carta carta1 = new Carta(2, Juego.jugadorColor, CartaFactory.getCartaFactory().crearCarta(2));
		Carta carta2 = new Carta(3, Juego.jugadorColor, CartaFactory.getCartaFactory().crearCarta(3));
		Carta carta3 = new Carta(4, Juego.jugadorColor, CartaFactory.getCartaFactory().crearCarta(4));
		lista.addCarta(carta1);
		lista.addCarta(carta2);
		lista.addCarta(carta3);
		
		JSONObject json = new JSONObject(lista.toJson());
		JSONArray listaJson = new JSONArray(json.get("cartas").toString());

		JSONObject jsonCarta = (JSONObject) listaJson.get(1);

		assertEquals(3, jsonCarta.getInt("numero"));
		assertEquals("azul", jsonCarta.getString("color"));
		assertEquals("canguro", jsonCarta.getString("animal"));
	}
	
	/**
	 * Comprueba si el numero de cartas que indica el json es el correcto.
	 * @throws Exception
	 */
	@Test
	void testJugador() throws Exception {
		Jugador jugador = new Jugador(EnumColor.AZUL);
		for(int i = 1; i <= 12; i++) {
			Animal anim = CartaFactory.getCartaFactory().crearCarta(i);
			jugador.addCarta(new Carta(i, EnumColor.AZUL, anim));
		}
		jugador.barajar();
		jugador.cogerCarta();
		jugador.cogerCarta();
		jugador.cogerCarta();
		jugador.cogerCarta();
		String resultado = jugador.toJson();
		
		JSONObject json = new JSONObject(resultado);
		JSONObject jsonMano = json.getJSONObject("mano");
		JSONObject jsonMazo = json.getJSONObject("mazo");
		
		assertEquals(jsonMano.getInt("cuantas") + jsonMazo.getInt("cuantas"), 12);
	}
	
	/**
	 * Comprueba si la animalada de la foca actualiza la variable de entrada intercambiada.
	 * @throws Exception
	 */
	@Test
	void colaDelBar() throws Exception {
		for(int i = 1; i <= 4; i++) {
			Animal anim = CartaFactory.getCartaFactory().crearCarta(i);
			ColaDelBar.getColaDelBar().addCarta(new Carta(i, EnumColor.AZUL, anim));
		}
		// foca
		Animal anim = CartaFactory.getCartaFactory().crearCarta(6);
		Carta foca = new Carta(6, EnumColor.AZUL, anim);
		ColaDelBar.getColaDelBar().addCarta(foca);

		anim.hacerAnimalada(foca);
		JSONObject json = new JSONObject(ColaDelBar.getColaDelBar().toJson());
		
		assertEquals(true, json.getBoolean("entrada_intercambiada"));
		anim.hacerAnimalada(foca);

		JSONObject json2 = new JSONObject(ColaDelBar.getColaDelBar().toJson());
		assertEquals(false, json2.getBoolean("entrada_intercambiada"));
	}
	
	@Test
	void mostrarResultado() {
		Juego.getJuego().testJuegoNuevo();
		System.out.println(Juego.getJuego().toJson());
	}
	
	

}
