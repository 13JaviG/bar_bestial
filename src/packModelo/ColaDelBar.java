/**
 * 
 */
package packModelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

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
		susCartas.invertir();
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
	 * M�todo para eliminar las dos especies m�s altas, usado por la Mofeta
	 */
	public void rmvEspMasAltas() {
		
		int max = 0;	//Valor de la especie m�s alta
		Carta act;
		int espAltas = 0; //Cu�ntas especies has eliminado
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
	 * Elimina una carta dado un �ndice
	 * @param pIndex
	 * @return la carta eliminada.
	 */
	public Carta rmvCarta(int pIndex) {
		return susCartas.rmvCarta(pIndex);
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
	 * M�todo usado para avanzar el Hipop�tamo
	 * @param pCarta
	 * La carta que hace la animalada, para saber por d�nde empezar
	 */
	public void avanzaSiMayor(Carta pCarta) {
		
		Carta act=pCarta;
		Carta sig;
		boolean stop = false;
		int i= susCartas.indexCarta(pCarta); //M�todo que te devuelve el �ndice dependiendo de la carta
		
		while(i>0 && !stop)
		{	
			sig= susCartas.cartaIndex(i-1); //M�todo que te devuelve la carta dependiendo del �ndice
			
			if(act.getNum()==8 || act.getNum()==11)
			{		//Si es una jirafa o un hipop�tamo
				
				if(sig.getNum()<act.getNum() && sig.getNum()!= 7)
				{	//Si es una carta m�s d�bil y no es cebra
					
					susCartas.intercambiar(sig,act); // intercambiamos las cartas de posici�n
					if(act.getNum()==8){	//Si era el caso de la jirafa s�lo avanza una vez
						stop = true;
					}
				}
				else
				{
					stop = true; //No puede avanzar m�s ya que no es mayor que la siguiente o hay una cebra
				}
			}
			
			act=sig;
			i--;
		}
	}
	
	/**
	 * Metodo que imita la animalada de otro animal excepto la del camaleon
	 */
	public void clonar(Carta pCarta) {
		Carta temp=null;
		Scanner teclado=new Scanner(System.in);
		boolean avanza=false;
		while(!avanza) {
			System.out.println("Campo:");
			imprimirColaDelBar();
			try{
				System.out.println("introduce la posicion de la carta a copiar");
				temp=getCarta(teclado.nextInt()-1);
				switch (temp.getNum()) {
				case (1):
				}
				avanza=true;
			}catch(InputMismatchException e) {
				System.out.println("introduzca un numero");
				teclado.nextLine();
			}catch(IndexOutOfBoundsException e) {
				System.out.println("introduzca una posicion valida max "+cuantasHay());
			}
		}
	}

	public void ordenarDesc() {
		// TODO implementar
		susCartas.ordenarDescendente();
	}
	
	/**
	 * M�todo para avanzar eliminando las cartas a las que "adelantas", usado en la animalada del Cocodrilo
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
				{	//Si es una carta m�s d�bil y no es cebra
					
					susCartas.rmvCarta(sig); // Eliminamos la carta correspondiente
					i= susCartas.indexCarta(act); //Damos a 'i' el nuevo valor de la posici�n del cocodrilo
					
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
			Carta cartaAnterior = susCartas.cartaIndex(indiceAnterior);
			susCartas.intercambiar(pCarta, cartaAnterior);
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
				susCartas.intercambiar(pCarta, cartaAnterior);
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
		System.out.println("Al principio el tamaño es " + paraAvanzar.size());
		int contador = 0;
		while (contador < cuantasAvanzar) {
			System.out.println("Contador " + contador);
			System.out.println("CuantasAvanzar " + cuantasAvanzar);
			Carta carta = paraAvanzar.remove(0);
			System.out.println("Despues el tamaño es " + paraAvanzar.size());
			ponerEnPos(contador, carta);
			contador++;
		}
	}
	
	

	public void primeraPosicionNoCuatros() {
		// TODO implementar
		boolean noLeon=true;
		for(int i=0;i<susCartas.cuantasCartas()-1;i++) {
			if(susCartas.cartaIndex(i).getNum()==12){
				susCartas.rmvCarta(susCartas.cuantasCartas());
				noLeon=false;
			}
		}
		System.out.println(noLeon);
		if(noLeon) {
			susCartas.intercambiar(susCartas.cartaIndex(susCartas.cuantasCartas()-1), susCartas.cartaIndex(0));;
			for(int i=0;i<=susCartas.cuantasCartas()-1;i++) {
				if(susCartas.cartaIndex(i).getNum()==4) {susCartas.rmvCarta(i);}
			}
		}
		
	}

	public void vaciar() {
		// TODO Auto-generated method stub
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

}
