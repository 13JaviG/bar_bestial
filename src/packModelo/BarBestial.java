/**
 * 
 */
package packModelo;

import java.util.Iterator;

/**
 * Representa el Bar.
 */
public class BarBestial {
	
	private static BarBestial miBarBestial;
	
	private ListaCartas susCartas;
	
	private BarBestial() {
		susCartas=new ListaCartas();
	}
	
	public static BarBestial getBarBestial() {
		if (miBarBestial == null) {
			miBarBestial = new BarBestial();
		}
		return miBarBestial;
	}
	
	/**
	 * A�ade una carta a su lista de cartas.
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		susCartas.addCarta(pCarta);
	}
	
	/**
	 * Vac�a la lista de cartas.
	 */
	public void vaciar() {
		susCartas.vaciar();
	}
	
	/**
	 * Calcula la puntuaci�n del color indicado.
	 * @param pColor
	 * @return
	 */
	public int calcularPuntuacion(EnumColor pColor) {
		int puntuacion=0;
		Iterator<Carta> itr=susCartas.getIterator();
		while (itr.hasNext()) {
			if (itr.next().getColor().equals(pColor)) {puntuacion++;}
		}
		return puntuacion;
	}

	public int cuantasCartas() {
		// TODO Auto-generated method stub
		return susCartas.cuantasCartas();
	}

}
