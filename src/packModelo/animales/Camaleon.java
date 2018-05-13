/**
 * 
 */
package packModelo.animales;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import packControlador.Juego;
import packModelo.Animal;
import packModelo.Carta;
import packModelo.CartaFactory;
import packModelo.ColaDelBar;

/**
 * @author ander
 *
 */
public class Camaleon extends Animal {
	@Override
	public void hacerAnimalada(Carta pCarta) {
		Carta temp=null;
		int opcion = 0;
		Scanner teclado=new Scanner(System.in);
		boolean avanza=false;
		if(pCarta.getColor()== Juego.jugadorColor) {
			while(!avanza) {
				System.out.println("Campo:");
				ColaDelBar.getColaDelBar().imprimirColaDelBar();
				try{
					String textoDialogo = JOptionPane.showInputDialog("introduce la posicion de la carta a copiar");
					int numCopiar=Integer.parseInt(textoDialogo);
					temp = ColaDelBar.getColaDelBar().getCarta(numCopiar-1);
					avanza=true;
					opcion=temp.getNum();
				}catch(InputMismatchException e) {
					System.out.println("introduzca un numero");
					teclado.nextLine();
				}catch(IndexOutOfBoundsException e) {
					System.out.println("introduzca una posicion valida max "+ ColaDelBar.getColaDelBar().cuantasHay());
				}
			}
		}else {
			Random rng=new Random();
			opcion=rng.nextInt(ColaDelBar.getColaDelBar().cuantasHay());
		}
		if(opcion!=5) {
			try {
				CartaFactory.getCartaFactory().crearCarta(opcion).hacerAnimalada(pCarta);
			} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
	}
}
