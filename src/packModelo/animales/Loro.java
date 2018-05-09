/**
 * 
 */
package packModelo.animales;

import java.io.IOException;
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
public class Loro extends Animal {
	
	public void hacerAnimalada(Carta pCarta)
	{	
		if (pCarta.getColor() == Juego.jugadorColor) {
			Scanner in = new Scanner(System.in);
			int pIndex = 0;
				System.out.println("Qué posición ocupa la carta que deseas eliminar?");
				System.out.println("Introduce un valor entre 0 y "+(ColaDelBar.getColaDelBar().cuantasHay()-1));
				pIndex = in.nextInt();
				ColaDelBar.getColaDelBar().rmvCarta(pIndex);
			}
			
		 else {
					Random rand = new Random();
					int pIndex = rand.nextInt(ColaDelBar.getColaDelBar().cuantasHay()-1) + 0;
			
					
					ColaDelBar.getColaDelBar().rmvCarta(pIndex);
					
			}
		}
}
