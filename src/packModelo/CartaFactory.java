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
 * Representa una f�brica de cartas.
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
	 * Crea la carta bas�ndose en el n�mero y color indicados.
	 * @param pNum
	 * @param pColor
	 * @return
	 * @throws Exception
	 */
	public Animal crearCarta(int pNum) throws Exception {
		switch (pNum) {
		case 1:
			return new Mofeta();
		case 2:
			return new Loro();
		case 3:
			return new Canguro();
		case 4:
			return new Mono();
		case 5:
			return new Camaleon();
		case 6:
			return new Foca();
		case 7:
			return new Cebra();
		case 8:
			return new Jirafa();
		case 9:
			return new Serpiente();
		case 10:
			return new Cocodrilo();
		case 11:
			return new Hipopotamo();
		case 12:
			return new Leon();
		default:
			throw new Exception("El numero de la carta no está soportado.");
		}
	}
}
