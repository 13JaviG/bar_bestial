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
public class Camaleon extends Animal {
	@Override
	public void hacerAnimalada(Carta pCarta) {
		ColaDelBar.getColaDelBar().clonar(pCarta);
	}
}
