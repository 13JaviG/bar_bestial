/**
 * 
 */
package packModelo;

/**
 * Representa una carta en el juego.
 *
 */
public class Carta {
	
	private int num;
	private EnumColor color;
	private Animal animal;
	
	public Carta(int pNum, EnumColor pColor) throws Exception {
		num = pNum;
		color = pColor;
		animal = CartaFactory.getCartaFactory().crearCarta(pNum);
	}
	
	public int getNum(){
		return num;
	}
	
	public void hacerAnimalada(Carta this) {
		animal.hacerAnimalada(this);
		
	}
	
	/**
	 * Devuelve un string con la informaci�n de la carta.
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Color: ");
		result.append(color);
		result.append(" | Number: ");
		result.append(num);
		result.append(" | Animal: ");
		result.append(animal.getClass().getName());
		return result.toString();
	}
	
}
