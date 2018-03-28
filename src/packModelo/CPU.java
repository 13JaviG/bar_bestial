/**
 * 
 */
package packModelo;

/**
 * Representa a la CPU.
 */
public class CPU extends Jugador {

	public CPU(EnumColor pColor) {
		super(pColor);
	}
	
	@Override
	public Carta jugar(int pIndCarta) {
		Carta temp=rmvCartaMano(pIndCarta);
		this.rmvCartaMano(temp);
		return temp;
	}

}
