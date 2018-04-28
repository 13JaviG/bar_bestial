/**
 * 
 */
package packModelo.animales;

import packModelo.Animal;
import packModelo.ColaDelBar;

/**
 * @author ander
 *
 */
public class Foca extends Animal {
	
	public void hacerAnimalada() {
		ColaDelBar.getColaDelBar().reordenarCola();
	}
}
