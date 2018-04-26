/**
 * 
 */
package packModelo;

import java.util.Iterator;
import java.util.ListIterator;

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
	 * Aï¿½ade una carta a su lista de cartas.
	 * @param pCarta
	 */
	public void addCarta(Carta pCarta) {
		susCartas.addCarta(pCarta);
	}
	
	/*
	 * De aquï¿½ para abajo son los mï¿½todos para las animaladas
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
	
	/**
	 * Método para eliminar las dos especies más altas, usado por la Mofeta
	 */
	public void rmvEspMasAltas() {
		
		int max = 0;	//Valor de la especie más alta
		Carta act;
		int espAltas = 0; //Cuántas especies has eliminado
		while(espAltas<2 && susCartas.cuantasCartas()>0){
			for(Iterator<Carta> it = susCartas.getIterator(); it.hasNext();)
			{
				act=it.next();
				if(act.getNum()>max)
				{
					max = act.getNum();
				}
			}
			for(Iterator<Carta> it = susCartas.getIterator(); it.hasNext();)
			{
				act=it.next();
				if(act.getNum()==max)
				{
					it.remove();
				
				}
			}
			espAltas++;
			max = 0;
		}
	}

	public void reordenarCola() {
		// TODO implementar
		
	}


	/**
	 * Elimina una carta dado un índice
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
	
	/**
	 * Método usado para avanzar tanto si es una Jirafa como si es un Hipopótamo
	 * @param pCarta
	 * La carta que hace la animalada, para saber por dónde empezar
	 */
	public void avanzaSiMayor(Carta pCarta) {
		
		Carta act=pCarta;
		Carta sig;
		boolean stop = false;
		int i= susCartas.indexCarta(pCarta); //Método que te devuelve el índice dependiendo de la carta
		
		while(i>0 && !stop)
		{	
			sig= susCartas.cartaIndex(i-1); //Método que te devuelve la carta dependiendo del índice
			
			if(act.getNum()==8 || act.getNum()==11)
			{		//Si es una jirafa o un hipopótamo
				
				if(sig.getNum()<act.getNum() && sig.getNum()!= 7)
				{	//Si es una carta más débil y no es cebra
					
					susCartas.intercambiar(sig,act); // intercambiamos las cartas de posición
					if(act.getNum()==8){	//Si era el caso de la jirafa sólo avanza una vez
						stop = true;
					}
				}
				else
				{
					stop = true; //No puede avanzar más ya que no es mayor que la siguiente o hay una cebra
				}
			}
			
			act=sig;
			i--;
		}
	}

	public void ordenarDescendente() {
		// TODO implementar
		
	}
	
	/**
	 * Método para avanzar eliminando las cartas a las que "adelantas", usado en la animalada del Cocodrilo
	 * @param pCarta
	 * Desde la carta que empiezas, es decir, la que hace la animalada
	 */
	public void avanzarEliminando(Carta pCarta) {
		
		Carta act=pCarta;
		Carta sig;
		boolean stop = false;
		int i= susCartas.indexCarta(pCarta);
		
		while(i>0 && !stop)
		{	
			sig= susCartas.cartaIndex(i-1);
			
				if(sig.getNum()<act.getNum() && sig.getNum()!= 7)
				{	//Si es una carta más débil y no es cebra
					
					susCartas.rmvCarta(sig); // Eliminamos la carta correspondiente
					i= susCartas.indexCarta(act); //Damos a 'i' el nuevo valor de la posición del cocodrilo
					
				}
				else
				{
					stop = true;
				}
			
		}
			
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
