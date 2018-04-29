/**
 * 
 */
package packModelo.animales;

import java.util.Scanner;

import packModelo.Animal;
import packModelo.Carta;
import packModelo.ColaDelBar;

/**
 * @author ander
 *
 */
public class Canguro extends Animal {

	public void hacerAnimalada(Carta pCarta) {
		// TODO con scanner hasta que pongamos observers
		Scanner in = new Scanner(System.in);
		int numSaltos = 0;
		while ((numSaltos != 1) && (numSaltos != 2)) {
			System.out.println("Cuantas cartas salta el canguro? (1 o 2)");
			numSaltos = in.nextInt();
		}
		
		for (int i = 0; i < numSaltos; i++) {
			ColaDelBar.getColaDelBar().avanzarUna(pCarta);
		}
	}

}
