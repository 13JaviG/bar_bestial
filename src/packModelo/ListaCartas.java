/**
 * 
 */
package packModelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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
	 * A�ade una carta a la lista.
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		cartas.add(pCarta);
	}

	/**
	 * A�ade una carta a la lista en el indice indicado
	 * @param pCarta
	 */
	public void addCarta(int pIndice, Carta pCarta) {
		cartas.add(pIndice, pCarta);
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
	 * Intercambia de posici�n dos cartas
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
	 * Devuelve el n�mero de cartas que hay en la lista.
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
	 * Dada una lista de cartas imprime su contenido.
	 * @param cartas
	 */
	public void imprimirCartas() {
		Iterator<Carta> it = cartas.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	/**
	 * Devuelve el �ndice de una carta dada
	 * @param pCarta
	 * Carta de la que queremos saber el �ndice
	 */
	public int indexCarta(Carta pCarta){
		return cartas.indexOf(pCarta);
	}
	
	/**
	 * Devuelve la carta en determinada posici�n
	 * @param pIndex
	 * �ndice de la carta a devolver
	 */
	public Carta cartaIndex(int pIndex){
		return cartas.get(pIndex);
	}

	public void ordenarDescendente() {
		// TODO Auto-generated method stub
		
	}

	public void reordenar() {
		// TODO Auto-generated method stub
		Collections.reverse(cartas);
	}
	}
