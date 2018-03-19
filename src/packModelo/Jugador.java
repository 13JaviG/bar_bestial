/**
 * 
 */
package packModelo;

import java.util.Iterator;

/**
 * Representa a un jugador.
 */
public class Jugador {
	
	private ListaCartas suMano;
	private ListaCartas suMazo;
	private EnumColor color;
	
	public Jugador(EnumColor pColor) {
		color = pColor;
		suMano = new ListaCartas();
		suMazo = new ListaCartas();
	}
	
	/**
	 * Añade una carta al mazo.
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		suMazo.addCarta(pCarta);
	}
	
	/**
	 * Añade una carta a la mano
	 * @param pCarta
	 */
	private void addCartaMano(Carta pCarta){
		suMano.addCarta(pCarta);
	}
	
	/**
	 * Elimina una carta de la mano.
	 * @param pCarta
	 * @return
	 */
	public boolean rmvCartaMano(Carta pCarta) {
		return suMano.rmvCarta(pCarta);
	}
	
	
	
	
	/**
	 * Elimina una carta del mazo.
	 * @param pCarta
	 * @return
	 */
	public boolean rmvCartaMazo(Carta pCarta) {
		return suMazo.rmvCarta(pCarta);
	}
	
	/**
	 * Calcula la puntuacion del jugador.
	 * @return
	 */
	public int calcularPuntuacion() {
		// TODO implementar
		return -1;
	}
	
	public Carta jugar() {
		// TODO implementar
		return null;
	}
	
	/**
	 * Devuelve true si tiene cartas, false si no tiene.
	 * @return
	 */
	public boolean tieneCartas() {
		return (suMano.cuantasCartas() != 0);
	}
	
	/**
	 * Baraja las cartas de su mazo.
	 */
	public void barajar() {
		suMazo.desordenar();
	}

	/**
	 * Dada una lista de cartas imprime su contenido.
	 * @param cartas
	 */
	private void imprimirCartas(ListaCartas cartas) {
		Iterator<Carta> it = cartas.getIterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
	/**
	 * Imprime la información de las cartas del mazo.
	 */
	public void imprimirCartasMazo() {
		imprimirCartas(suMazo);
	}

	/**
	 * Imprime la información de las cartas de la mano.
	 */
	public void imprimirCartasMano() {
		imprimirCartas(suMano);
	}
	
	/**
	 * Coge una carta del mazo y la coloca en su mano
	 */
	public void cogerCarta() {
		
		addCarta(suMazo.rmvCarta(suMazo.cuantasCartas()-1));
		
	}

}
