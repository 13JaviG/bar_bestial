/**
 * 
 */
package packModelo.animales;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
		if (pCarta.getColor() == Juego.jugadorColor) {
			Scanner in = new Scanner(System.in);
			int numSaltos = 0;
			while ((numSaltos != 1) && (numSaltos != 2)) {
				String textoDialogo = JOptionPane.showInputDialog("Cuantas cartas salta el canguro? (1 o 2)");
				try {
					numSaltos = Integer.parseInt(textoDialogo);
				} catch (NumberFormatException e) {
					numSaltos = -1;
				}
			}

			for (int i = 0; i < numSaltos; i++) {
				ColaDelBar.getColaDelBar().avanzarUna(pCarta);
			}
			
		} else {
			Random rand = new Random();
			int numSaltos = rand.nextInt(2) + 1;
			
			for (int i = 0; i < numSaltos; i++) {
				ColaDelBar.getColaDelBar().avanzarUna(pCarta);
			}
		}
		
	}

}
