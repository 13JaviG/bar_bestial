/**
 * 
 */
package packTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import packControlador.ClienteBD;

/**
 * @author ander
 *
 */
class TestBD {

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
	void test() {
		JSONArray lista = ClienteBD.getClienteBD().obtenerRanking();
		Iterator<Object> it = lista.iterator();

		while (it.hasNext()) {
			JSONObject current = (JSONObject) it.next();
			System.out.println(current.get("fecha"));
			System.out.println(current.get("usuario"));
			System.out.println(current.get("puntos"));
			System.out.println();
		}
	}

}
