/**
 * 
 */
package packModelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

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
	public void intercambiar(int index1, int index2){
		Carta aux = cartaIndex(index1);
		Carta pCarta2 = cartaIndex(index2);
		cartas.set(index1, pCarta2);
		cartas.set(index2, aux);
		
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
	 * Crea un string en formato JSON de la lista de cartas.
	 * @return
	 */
	public String toJson() {
		JSONArray listaJson = new JSONArray();
		Iterator<Carta> it = cartas.iterator();
		int indice = 0;
		while (it.hasNext()) {
			JSONObject cartaActual = new JSONObject(it.next().toJson());
			cartaActual.put("indice", indice);

			listaJson.put(cartaActual);
			indice++;
		}
		JSONObject resultado = new JSONObject();
		resultado.put("cartas", listaJson);
		resultado.put("cuantas", this.cuantasCartas());
		return resultado.toString(2);
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
	/**
	 * ordena de mayor a menor la lista segun su numero de carta
	 */
	public void ordenarDescendente() {
		// TODO Auto-generated method stub
		Carta masAlta;
		ArrayList<Carta> temp=new ArrayList<Carta>();
		while(cartas.size()!=0) {
			masAlta=cartas.get(0);
			for(Carta i:cartas) {
				if(masAlta.getNum()<i.getNum()) {masAlta=i;}
			}
			temp.add(masAlta);
			cartas.remove(masAlta);
			
		}
		cartas=temp;
	}

	public void invertir() {
		// TODO Auto-generated method stub
		Collections.reverse(cartas);
	}

}
