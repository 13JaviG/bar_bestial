/**
 * 
 */
package packModelo;

import java.util.Iterator;

/**
 * Representa el Bar.
 */
public class ColaDelBar {
	
	private static ColaDelBar miColaDelBar;
	
	private ListaCartas susCartas;
	
	private ColaDelBar() {
		susCartas=new ListaCartas();
	}
	
	public static ColaDelBar getColaDelBar() {
		if (miColaDelBar == null) {
			miColaDelBar = new ColaDelBar();
		}
		return miColaDelBar;
	}
	
	/**
	 * A�ade una carta a su lista de cartas.
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		susCartas.addCarta(pCarta);
	}
	
	/*
	 * De aqu� para abajo son los m�todos para las animaladas
	 */
	
	public void invertirCola() {
		// TODO implementar
	}

	public void hacerAnimaladasR() {
		// TODO implementar
		if (estaLlena()) {colaLlena();}		
	}
	
	/**
	 * En caso de llena mueve las 2 primeras cartas a BarBestial
	 * y la Ultima a EsLoQueHay
	 */
	private void colaLlena() {
		// TODO Auto-generated method stub
		Carta esLoQueHay=susCartas.rmvCarta(susCartas.cuantasCartas()-1);
		Carta barBestial1=susCartas.rmvCarta(0);
		Carta barBestial2=susCartas.rmvCarta(0);
		BarBestial.getBarBestial().addCarta(barBestial1);
		BarBestial.getBarBestial().addCarta(barBestial2);
		EsLoQueHay.getEsLoQueHay().addCarta(esLoQueHay);
	}

	public boolean estaLlena() {
		return (susCartas.cuantasCartas() == 5);
	}

	public void rmvEspMasAltas() {
		// TODO implementar
		
	}

	public void reordenarCola() {
		// TODO implementar
		
	}


	/**
	 * Elimina una carta dado un �ndice.
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

	public void vaciar() {
		// TODO Auto-generated method stub
		susCartas.vaciar();
	}

}
