/**
 * 
 */
package packModelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Representa una lista de cartas de animales.
 */
public class ListaCartas {
	
	private ArrayList<Carta> cartas;
	
	public ListaCartas() {
		cartas = new ArrayList<Carta>();
	}
	
	/**
	 * Añade una carta a la lista.
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		cartas.add(pCarta);
	}
	
	/**
	 * Elimina una carta de la lista.
	 * @param pCarta
	 */
	public boolean rmvCarta(Carta pCarta) {
		return cartas.remove(pCarta);
	}

	/**
	 * Elimina una carta de la lista.
	 * @param pCarta
	 */
	public Carta rmvCarta(int pIndex) {
		return cartas.remove(pIndex);
	}
	
	/**
	 * Devuelve un iterador de la lista de cartas.
	 */
	public Iterator<Carta> getIterator() {
		return cartas.iterator();
	}
	
	/**
	 * Devuelve el número de cartas que hay en la lista.
	 * @return
	 */
	public int cuantasCartas() {
		return cartas.size();
	}
	
	/**
	 * Desordena de forma aleatoria la lista de cartas.
	 */
	public void desordenar() {
		Collections.shuffle(cartas);
	}
	
	/**
	 * Elimina todas las cartas de la lista.
	 */
	public void vaciar() {
		cartas.clear();
	}

}
