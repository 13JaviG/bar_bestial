/**
 * 
 */
package packModelo.animales;

import java.io.IOException;

import packModelo.Animal;
import packModelo.Carta;
import packModelo.ColaDelBar;

/**
 * @author ander
 *
 */
public class Loro extends Animal {
	
	public void hacerAnimalada(Carta pCarta)
	{	
		int pIndex = 0;
		try {
			System.out.println("Introduce el índice de la carta a eliminar"
					+ "Si no hay ninguna carta más, introduce: -1");
			pIndex = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ColaDelBar.getColaDelBar().rmvCarta(pIndex);
	}
}
