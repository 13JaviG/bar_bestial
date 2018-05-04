/**
 * 
 */
package packModelo;

import org.json.JSONObject;

/**
 * Representa una carta en el juego.
 *
 */
public class Carta {
	
	private int num;
	private EnumColor color;
	private Animal animal;
	
	public Carta(int pNum, EnumColor pColor, Animal pAnim) throws Exception {
		num = pNum;
		color = pColor;
		animal = pAnim;
	}
	
	public int getNum(){
		return num;
	}
	
	public void hacerAnimalada() {
		animal.hacerAnimalada(this);
		
	}
	
	public void recurrir () {
		if (animal instanceof IRecurrente) {
			((IRecurrente) animal).recurrir(this);
		}
	}
	
	/**
	 * Devuelve un string con la informaci�n de la carta.
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Color: ");
		result.append(getColor());
		result.append(" | Number: ");
		result.append(num);
		result.append(" | Animal: ");
		result.append(animal.getClass().getName());
		return result.toString();
	}
	
	/**
	 * Devuelve un String en formato json de la carta.
	 * @return
	 */
	public String toJson() {
		JSONObject json = new JSONObject()
				.put("numero", num)
				.put("color", color.toString().toLowerCase())
				.put("animal", animal.getClass().getSimpleName().toLowerCase());
		return json.toString(2);
	}

	/**
	 * @return the color
	 */
	public EnumColor getColor() {
		return color;
	}
	
}
