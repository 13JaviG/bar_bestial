/**
 * 
 */
package packModelo;

import packModelo.animales.Camaleon;
import packModelo.animales.Canguro;
import packModelo.animales.Cebra;
import packModelo.animales.Cocodrilo;
import packModelo.animales.Foca;
import packModelo.animales.Hipopotamo;
import packModelo.animales.Jirafa;
import packModelo.animales.Leon;
import packModelo.animales.Loro;
import packModelo.animales.Mofeta;
import packModelo.animales.Mono;
import packModelo.animales.Serpiente;

/**
 * Representa una fábrica de cartas.
 */
public class CartaFactory {
	
	private static CartaFactory miCartaFactory;
	
	private CartaFactory() {};
	
	/**
	 * Devuelve la fabrica de cartas.
	 * @return
	 */
	public static CartaFactory getCartaFactory() {
		if (miCartaFactory == null) {
			miCartaFactory = new CartaFactory();
		}
		return miCartaFactory;
	}
	
	/**
	 * Crea la carta basándose en el número y color indicados.
	 * @param pNum
	 * @param pColor
	 * @return
	 * @throws Exception
	 */
	public Carta crearCarta(int pNum, EnumColor pColor) throws Exception {
		Carta carta;
		switch (pNum) {
		case 1:
			carta = new Carta(pNum, pColor, new Mofeta());
			break;

		case 2:
			carta = new Carta(pNum, pColor, new Loro());
			break;

		case 3:
			carta = new Carta(pNum, pColor, new Canguro());
			break;

		case 4:
			carta = new Carta(pNum, pColor, new Mono());
			break;

		case 5:
			carta = new Carta(pNum, pColor, new Camaleon());
			break;

		case 6:
			carta = new Carta(pNum, pColor, new Foca());
			break;

		case 7:
			carta = new Carta(pNum, pColor, new Cebra());
			break;

		case 8:
			carta = new Carta(pNum, pColor, new Jirafa());
			break;

		case 9:
			carta = new Carta(pNum, pColor, new Serpiente());
			break;

		case 10:
			carta = new Carta(pNum, pColor, new Cocodrilo());
			break;

		case 11:
			carta = new Carta(pNum, pColor, new Hipopotamo());
			break;

		case 12:
			carta = new Carta(pNum, pColor, new Leon());
			break;

		default:
			throw new Exception("El numero de la carta no está soportado.");
		}
		
		return carta;
	}
}
