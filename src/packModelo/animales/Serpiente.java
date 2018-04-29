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
public class Serpiente extends Animal {
	@Override
	public void hacerAnimalada(Carta pCarta) {
		ColaDelBar.getColaDelBar().ordenarDesc();
	}
}
