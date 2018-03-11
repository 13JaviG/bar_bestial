/**
 * 
 */
package packModelo;

/**
 * Representa el Bar.
 */
public class ColaDelBar {
	
	private static ColaDelBar miColaDelBar;
	
	private ListaCartas susCartas;
	
	private ColaDelBar() {}
	
	public static ColaDelBar getColaDelBar() {
		if (miColaDelBar == null) {
			miColaDelBar = new ColaDelBar();
		}
		return miColaDelBar;
	}
	
	/**
	 * Añade una carta a su lista de cartas.
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		susCartas.addCarta(pCarta);
	}
	
	/*
	 * De aquí para abajo son los métodos para las animaladas
	 */
	
	public void invertirCola() {
		// TODO implementar
	}

	public void hacerAnimaladasR() {
		// TODO implementar
		
	}

	private boolean estaLlena() {
		return (susCartas.cuantasCartas() == 5);
	}

	public void rmvEspMasAltas() {
		// TODO implementar
		
	}

	public void reordenarCola() {
		// TODO implementar
		
	}


	/**
	 * Elimina una carta dado un índice.
	 * @param pIndex
	 * @return la carta eliminada.
	 */
	public Carta rmvCarta(int pIndex) {
		return susCartas.rmvCarta(pIndex);
	}

	public void saltarPosicion(int pPos, Carta pCarta) {
		// TODO implementar
		
	}

	public Carta getCarta(int pPos) {
		// TODO implementar
		return null;
	}

	public void avanzaSiMayor() {
		// TODO implementar
		
	}

	public void ordenarDescendente() {
		// TODO implementar
		
	}

	public void avanzarEliminando() {
		// TODO implementar
		
	}

	public void adelantarse() {
		// TODO implementar
		
	}

	public void primeraPosicionNoCuatros() {
		// TODO implementar
		
	}

}
