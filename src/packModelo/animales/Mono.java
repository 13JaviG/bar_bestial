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
		ColaDelBar cola = ColaDelBar.getColaDelBar();
		cola.rmvTodasConNum(10); // cocodrilos
		cola.rmvTodasConNum(11); // hipopotamos
		cola.ponerPrimera(pCarta);
		cola.avanzarTodasConNum(pCarta.getNum());
	}
}
