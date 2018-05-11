/**
 * 
 */
package packModelo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;

import packControlador.Juego;

/**
 * Representa el Bar.
 */
public class ColaDelBar {
	
	private static ColaDelBar miColaDelBar;
	private ListaCartas susCartas;
	
	/**
	 * Un boolean que indica si la foca ha intercambiado la puerta, util para la interfaz.
	 */
	private boolean entradaIntercambiada = false;
	
	
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
	 * Indica que se ha intercambiado la puerta.
	 */
	public void intercambiarEntrada() {
		entradaIntercambiada = !entradaIntercambiada;
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
		susCartas.invertir();
	}

	public void hacerAnimaladasR() {
		
		int i = 0;
		while( i<susCartas.cuantasCartas()) {
			
			Carta temp=susCartas.cartaIndex(i);
			temp.recurrir();
			if(temp.getNum()==10){
				i=susCartas.indexCarta(temp);
			}
			i++;
		}
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
	 * Mï¿½todo para eliminar las dos especies mï¿½s altas, usado por la Mofeta
	 */
	public void rmvEspMasAltas() {
		

		int max = 0;	//Valor de la especie mï¿½s alta
		Carta act;
		int espAltas = 0; //Cuï¿½ntas especies has eliminado
		while(espAltas<2 && susCartas.cuantasCartas()>0){
			for(int i = 0; i<susCartas.cuantasCartas();i++)
			{
				act=susCartas.cartaIndex(i);
				if(act.getNum()>max)
				{
					max = act.getNum();
				}
			}
			for(int i = 0; i<susCartas.cuantasCartas();i++)
			{
				act=susCartas.cartaIndex(i);
				if(act.getNum()==max)
				{
					Carta esLoQueHay = susCartas.rmvCarta(i);
					EsLoQueHay.getEsLoQueHay().addCarta(esLoQueHay); //La añadimos a "Es Lo Que Hay"
					i--;
				
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
	 * Elimina una carta dado un ï¿½ndice
	 * @param pIndex
	 * @return la carta eliminada.
	 */
	public Carta rmvCarta(int pIndex) {
		while( pIndex < 0 || pIndex > susCartas.cuantasCartas()-1){
			Scanner in = new Scanner(System.in);
			System.out.println("El valor introducido es incorrecto.");
			System.out.println("Introduce un valor entre 0 y "+(susCartas.cuantasCartas()-1));
			pIndex = in.nextInt();
			
		}
		Carta esLoQueHay = susCartas.rmvCarta(pIndex);
		EsLoQueHay.getEsLoQueHay().addCarta(esLoQueHay); //La añadimos a "Es Lo Que Hay"
		return susCartas.cartaIndex(0);
	}

	public void saltarPosicion(int pPos, Carta pCarta) {
		// TODO implementar
		
	}
	
	/**
	 * recibe una posicion y devuelve una carta si esa posicion existe si no nada
	 * @param pPos
	 * @return
	 */
	public Carta getCarta(int pPos) {
		// TODO implementar
		return susCartas.cartaIndex(pPos);
	}
	
	/**
	 * Mï¿½todo usado para avanzar el Hipopï¿½tamo
	 * @param pCarta
	 * La carta que hace la animalada, para saber por dï¿½nde empezar
	 */
	public void avanzaSiMayor(Carta pCarta) {
		
		Carta hipopotamo=pCarta;
		Carta sig;
		boolean stop = false;
		int i= susCartas.indexCarta(pCarta); //Mï¿½todo que te devuelve el ï¿½ndice dependiendo de la carta
		
		while(i>0 && !stop)
		{	
			System.out.println("Valor de i: "+i);
			sig= susCartas.cartaIndex(i-1); //Mï¿½todo que te devuelve la carta dependiendo del ï¿½ndice
			
			if(hipopotamo.getNum()==11)
			{		//Si es un hipopï¿½tamo
				
				if(sig.getNum()<hipopotamo.getNum() && sig.getNum()!= 7)
				{	//Si es una carta mï¿½s dï¿½bil y no es cebra
					
					susCartas.intercambiar(i-1,i); // intercambiamos las cartas de posiciï¿½n
				}
				else
				{
					stop = true; //No puede avanzar mï¿½s ya que no es mayor que la siguiente o hay una cebra
				}
			}
			
			i--;
		}
	}
	

	public void ordenarDesc() {
		// TODO implementar
		susCartas.ordenarDescendente();
	}
	
	/**
	 * Mï¿½todo para avanzar eliminando las cartas a las que "adelantas", usado en la animalada del Cocodrilo
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
				{	//Si es una carta mï¿½s dï¿½bil y no es cebra
					
					Carta esLoQueHay = susCartas.rmvCarta(i-1); // Eliminamos la carta correspondiente
					EsLoQueHay.getEsLoQueHay().addCarta(esLoQueHay); //La añadimos a "Es Lo Que Hay"		
					i= susCartas.indexCarta(act); //Damos a 'i' el nuevo valor de la posiciï¿½n del cocodrilo
					
				}
				else
				{
					stop = true;
				}
			
		}
			
	}
		


	/**
	 * Metodo que adelanta una carta sin condiciones (canguro).
	 * @param pCarta
	 */
	public void avanzarUna(Carta pCarta) {
		int indiceCarta = susCartas.indexCarta(pCarta);
		if (indiceCarta > 0) {
			int indiceAnterior = indiceCarta - 1;
			susCartas.intercambiar(indiceCarta, indiceAnterior);
		} else {
			System.out.println("No puede adelantarse.");
		}
		
	}

	/**
	 * Metodo que adelanta una carta si la carta que intenta avanzar es mayor (jirafa).
	 * @param pCarta
	 */
	public void avanzarUnaSiMayor(Carta pCarta) {
		int indiceCarta = susCartas.indexCarta(pCarta);
		if (indiceCarta > 0) {
			int indiceAnterior = indiceCarta - 1;
			Carta cartaAnterior = susCartas.cartaIndex(indiceAnterior);
			if (cartaAnterior.getNum() < pCarta.getNum()) {
				susCartas.intercambiar(indiceCarta, indiceAnterior);
			} else {
				System.out.println("No puede adelantarse.");
			}
		} else {
			System.out.println("No puede adelantarse.");
		}
		
	}
	
	/**
	 * Elimina de la lista todas las cartas que coincidan con el numero dado.
	 * El mono por ejemplo tiene que eliminar los hipopotamos y cocodrilos.
	 * @param pNum
	 */
	public void rmvTodasConNum(int pNum) {
		Iterator<Carta> it = susCartas.getIterator();
		ArrayList<Carta> cualesEliminar = new ArrayList<Carta>();
		while (it.hasNext()) {
			Carta cartaActual = it.next();
			if (cartaActual.getNum() == pNum) {
				cualesEliminar.add(cartaActual);
			}
		}
		
		Iterator<Carta> itEliminar = cualesEliminar.iterator();
		while (itEliminar.hasNext()) {
			Carta cartaActual = itEliminar.next();
			susCartas.rmvCarta(cartaActual);
			EsLoQueHay.getEsLoQueHay().addCarta(cartaActual);
		}

	}
	
	/**
	 * Pone la carta dada al principio de la lista
	 * @param pCarta
	 */
	public void ponerPrimera(Carta pCarta) {
		susCartas.rmvCarta(pCarta);
		susCartas.addCarta(0, pCarta);
	}
	
	/**
	 * Pone la carta dada en el indice indicado.
	 * @param pCarta
	 */
	public void ponerEnPos(int pIndice, Carta pCarta) {
		susCartas.rmvCarta(pCarta);
		susCartas.addCarta(pIndice, pCarta);
	}
	
	/**
	 * Avanza al principio todas las que tengan el numero indicado en el orden que las encuentra.
	 * @param pNum
	 */
	public void avanzarTodasConNum(int pNum) {
		ArrayList<Carta> paraAvanzar = new ArrayList<Carta>();
		Iterator<Carta> it = susCartas.getIterator();
		while (it.hasNext()) {
			Carta cartaActual = it.next();
			if (cartaActual.getNum() == pNum) {
				paraAvanzar.add(cartaActual);
			}
		}

		int cuantasAvanzar = paraAvanzar.size();
		int contador = 0;
		while (contador < cuantasAvanzar) {
			Carta carta = paraAvanzar.remove(0);
			ponerEnPos(contador, carta);
			contador++;
		}
	}
	
	

	public void primeraPosicionNoCuatros() {
		// TODO implementar
		boolean noLeon=true;
		for(int i=0;i<susCartas.cuantasCartas()-1;i++) {
			if(susCartas.cartaIndex(i).getNum()==12){
				susCartas.rmvCarta(susCartas.cuantasCartas()-1);
				noLeon=false;
			}
		}
		if(noLeon) {
			ponerPrimera(susCartas.cartaIndex(susCartas.cuantasCartas()-1));
			for(int i=0;i<=susCartas.cuantasCartas()-1;i++) {
				if(susCartas.cartaIndex(i).getNum()==4) {susCartas.rmvCarta(i);}
			}
		}
		
	}

	public void vaciar() {
		susCartas.vaciar();
	}
	/**
	 * Metodo que imprime las cartas en la ColaDelBar
	 */
	public void imprimirColaDelBar() {
		susCartas.imprimirCartas();
	}

	public int cuantasHay() {
		return susCartas.cuantasCartas();
	}
	
	/**
	 * Devuelve un String en formato JSON.
	 * @return
	 */
	public String toJson() {
		JSONObject json = new JSONObject(susCartas.toJson());
		json.put("entrada_intercambiada", entradaIntercambiada);
		return json.toString();
	}

}
