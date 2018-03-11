/**
 * 
 */
package packModelo;

/**
 * Representa el Bar.
 */
public class EsLoQueHay {
	
	private static EsLoQueHay miEsLoQueHay;
	
	private ListaCartas susCartas;
	
	private EsLoQueHay() {}
	
	public static EsLoQueHay getEsLoQueHay() {
		if (miEsLoQueHay == null) {
			miEsLoQueHay = new EsLoQueHay();
		}
		return miEsLoQueHay;
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

}
