/**
 * 
 */
package packModelo;

/**
 * Representa el Bar.
 */
public class BarBestial {
	
	private static BarBestial miBarBestial;
	
	private ListaCartas susCartas;
	
	private BarBestial() {}
	
	public static BarBestial getBarBestial() {
		if (miBarBestial == null) {
			miBarBestial = new BarBestial();
		}
		return miBarBestial;
	}
	
	/**
	 * Añade una carta a su lista de cartas.
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		susCartas.addCarta(pCarta);
	}
	
	/**
	 * Vacía la lista de cartas.
	 */
	public void vaciar() {
		susCartas.vaciar();
	}
	
	/**
	 * Calcula la puntuación del color indicado.
	 * @param pColor
	 * @return
	 */
	public int calcularPuntuacion(EnumColor pColor) {
		// TODO implementar
		return -1;
	}

}
