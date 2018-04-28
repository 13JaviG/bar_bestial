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
public class Leon extends Animal {
	public void hacerAnimalada() {
		ColaDelBar.getColaDelBar().primeraPosicionNoCuatros();
	}
}
