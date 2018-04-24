/**
 * 
 */
package packModelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

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
	 * Elimina una carta de la lista y te la devuelve.
	 * @param pCarta
	 */
	public Carta rmvCarta(int pIndex) {
		return cartas.remove(pIndex);
	}
	
	/**
	 * Intercambia de posición dos cartas
	 * @param pCarta1, pCarta2 
	 * Cartas a intercambiar
	 */
	public void intercambiar(Carta pCarta1, Carta pCarta2){
		
		Carta aux = pCarta1;
		cartas.set(cartas.indexOf(pCarta1), pCarta2);
		cartas.set(cartas.indexOf(pCarta2), aux);
		
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
	
	/**
	 * Devuelve el índice de una carta dada
	 * @param pCarta
	 * Carta de la que queremos saber el índice
	 */
	public int indexCarta(Carta pCarta){
		return cartas.indexOf(pCarta);
	}
	
	/**
	 * Devuelve la carta en determinada posición
	 * @param pIndex
	 * Índice de la carta a devolver
	 */
	public Carta cartaIndex(int pIndex){
		return cartas.get(pIndex);
	}
}
