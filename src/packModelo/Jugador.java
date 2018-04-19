/**
 * 
 */
package packModelo;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

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
	 * A�ade una carta al mazo.
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		suMazo.addCarta(pCarta);
	}
	
	/**
	 * A�ade una carta a la mano
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
	
	public Carta rmvCartaMano(int pIndCarta) {
		return suMano.rmvCarta(pIndCarta);
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
		return BarBestial.getBarBestial().calcularPuntuacion(color);
	}
	
	public Carta jugar(int pIndCarta) {
		Carta temp=new Carta(0, color, null);
		temp=suMano.rmvCarta(pIndCarta);
		suMano.rmvCarta(temp);
		return temp;
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
	 * Imprime la informaci�n de las cartas del mazo.
	 */
	public void imprimirCartasMazo() {
		suMazo.imprimirCartas();
	}

	/**
	 * Imprime la informaci�n de las cartas de la mano.
	 */
	public void imprimirCartasMano() {
		suMano.imprimirCartas();
	}
	
	/**
	 * Coge una carta del mazo y la coloca en su mano
	 * En caso de vacia no hace nada
	 */
	public void cogerCarta() {
		if(suMazo.cuantasCartas()!=0) {
			addCartaMano(suMazo.rmvCarta(suMazo.cuantasCartas()-1));
		}
	}
	
	/**
	 * Devuelve el n�mero de cartas de la mano del jugador
	 * @return
	 */
	public int numCartasMano()
	{
		return suMano.cuantasCartas();
	}
	
	/**
	 * Devuelve el n�mero de cartas de la mano del jugador
	 * @return
	 */
	public int numCartasMazo()
	{
		return suMazo.cuantasCartas();
	}

}
