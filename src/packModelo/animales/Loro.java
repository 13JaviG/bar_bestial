/**
 * 
 */
package packModelo.animales;

import java.io.IOException;
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
public class Loro extends Animal {
	
	public void hacerAnimalada(Carta pCarta)
	{	
		if (pCarta.getColor() == Juego.jugadorColor) {
			int pIndex = 0;
				String textoDialogo = JOptionPane.showInputDialog("Qué posición ocupa la carta que deseas eliminar? Introduce un valor entre 0 y "+(ColaDelBar.getColaDelBar().cuantasHay()-1));
				pIndex = Integer.parseInt(textoDialogo);
				ColaDelBar.getColaDelBar().rmvCarta(pIndex);
			}
			
		 else {
					Random rand = new Random();
					int pIndex = rand.nextInt(ColaDelBar.getColaDelBar().cuantasHay()-1) + 0;
			
					
					ColaDelBar.getColaDelBar().rmvCarta(pIndex);
					
			}
		}
}
