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
public class Mofeta extends Animal {
	
	public void hacerAnimalada(Carta pCarta) 
	{
		ColaDelBar.getColaDelBar().rmvEspMasAltas();
	}
}
