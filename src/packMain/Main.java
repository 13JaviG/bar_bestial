/**
 * 
 */
package packMain;

import packControlador.Juego;
import packVista.VentanaInicioSesion;
import packVista.VentanaPrincipal;


/**
 * Clase donde iniciar el juego.
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO esto solo es para pruebas, el orden correcto es:
		/*
		 * abrir ventana de inicio sesion
		 * 	 si la sesion es correcta {
		 *      que la ventana de inicio de sesion cree un juego
		 *      que cree una ventana principal (esta ventana se suscribe solita al juego)
		 *      que se cierre
		 *   }
		 * 
		 * vamos que el unico codigo que necesitamos aqui es abrir la ventana de inicio
		 */
		VentanaInicioSesion.main(null);
	}

}
