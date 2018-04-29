/**
 * 
 */
package packModelo.animales;

import java.util.Random;
import java.util.Scanner;

import packControlador.Juego;
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
		if (pCarta.getColor() == Juego.jugadorColor) {
			Scanner in = new Scanner(System.in);
			int numSaltos = 0;
			while ((numSaltos != 1) && (numSaltos != 2)) {
				System.out.println("Cuantas cartas salta el canguro? (1 o 2)");
				numSaltos = in.nextInt();
			}
			
			for (int i = 0; i < numSaltos; i++) {
				ColaDelBar.getColaDelBar().avanzarUna(pCarta);
			}
			in.close();
		} else {
			Random rand = new Random();
			int numSaltos = rand.nextInt(2) + 1;
			
			for (int i = 0; i < numSaltos; i++) {
				ColaDelBar.getColaDelBar().avanzarUna(pCarta);
			}
		}
		
	}

}
