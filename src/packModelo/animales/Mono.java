/**
 * 
 */
package packModelo.animales;

import packModelo.Animal;
import packModelo.Carta;
import packModelo.ColaDelBar;

/**
 * @author ander
 *
 */
public class Mono extends Animal {

	public void hacerAnimalada(Carta pCarta) 
	{
		ColaDelBar.getColaDelBar().rmvTodasConNum(10); // cocodrilos
		ColaDelBar.getColaDelBar().rmvTodasConNum(11); // hipopotamos
		ColaDelBar.getColaDelBar().ponerPrimera(pCarta);
		ColaDelBar.getColaDelBar().avanzarTodasConNum(pCarta.getNum());
	}
}
