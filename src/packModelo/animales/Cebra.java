/**
 * 
 */
package packModelo.animales;

import packModelo.Animal;
import packModelo.IRecurrente;

/**
 *
 */
public class Cebra extends Animal implements IRecurrente {

	/**
	 * Metodo que ejecuta la accion del animal para los que implementan
	 * la interfaz IRecurrente.
	 */
	@Override
	public void recurrir() {
		this.hacerAnimalada();
	}

}
