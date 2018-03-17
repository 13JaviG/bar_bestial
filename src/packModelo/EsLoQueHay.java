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
	
	private EsLoQueHay() {
		susCartas=new ListaCartas();
	}
	
	public static EsLoQueHay getEsLoQueHay() {
		if (miEsLoQueHay == null) {
			miEsLoQueHay = new EsLoQueHay();
		}
		return miEsLoQueHay;
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

	public int cuantasCartas() {
		// TODO Auto-generated method stub
		return susCartas.cuantasCartas();
	}

}
