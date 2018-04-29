/**
 * 
 */
package packModelo.animales;

import packModelo.Animal;
import packModelo.Carta;
import packModelo.IRecurrente;

/**
 *
 */
public class Cebra extends Animal implements IRecurrente{
	

	public void hacerAnimalada(Carta pCarta) { }
	/**
	 * Metodo que ejecuta la accion del animal para los que implementan
	 * la interfaz IRecurrente.
	 */
	@Override
	public void recurrir(Carta pCarta) {
		this.hacerAnimalada(pCarta);
	}

}
