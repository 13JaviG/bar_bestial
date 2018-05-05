/**
 * 
 */
package packControlador;

import static org.junit.Assert.assertArrayEquals;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Cliente de base de datos SQlite.
 */
public class ClienteBD {
	
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String nombreBD = "bar_bestial.db";
	
	private static ClienteBD instancia = null;
	
	private ClienteBD() {
      try {
    	 this.connect();
         this.crearTablas();
         this.addUsuarioTest();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Base de datos abierta exitosamente.");
	}
	
	public static ClienteBD getClienteBD() {
		if (instancia == null) {
			instancia = new ClienteBD();
		}
		return instancia;
	}
	
	/**
	 * Crea las tablas si no existen.
	 */
	private void crearTablas() {
		try {
			stmt = conn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS usuarios " +
					"(usuario varchar(100) PRIMARY KEY  NOT NULL," +
					" pass    varchar(100)    NOT NULL)";
			stmt.executeUpdate(sql);

			String sql2 = "CREATE TABLE IF NOT EXISTS ranking " +
					"(usuario varchar(100) NOT NULL," +
					" puntos           int    NOT NULL," +
					" fecha          date    NOT NULL," +
					"FOREIGN KEY(usuario) REFERENCES usuarios(usuario)"
					+ ")";
			stmt.executeUpdate(sql2);

			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	private void addUsuarioTest() {
		try {
			String usuario = "test";
			String pass = "test";

			if (!this.existeUsuario(usuario)) {
				this.addUsuario(usuario, pass);
				for (int i = 1; i <= 3; i++) {
					this.addPuntuacion(usuario, i);
				}
			}

		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	/**
	 * Registra a un usuario nuevo. Si ya existe el usuario devuelve False.
	 * @param pUsuario
	 * @param pPass
	 * @return
	 */
	public boolean registrarse(String pUsuario, String pPass) {
		boolean registroExitoso = false;

		if (!this.existeUsuario(pUsuario)) {
			this.addUsuario(pUsuario, pPass);
			registroExitoso = true;
		}
		
		return registroExitoso;
	}
	
	/**
	 * Inserta un nuevo usuario en la base de datos sin hacer ninguna comprobacion.
	 * @param pUsuario
	 * @param pPass
	 */
	private void addUsuario(String pUsuario, String pPass) {
		try {
	         stmt = conn.createStatement();
	         String sql = "INSERT INTO usuarios (usuario,pass) " +
	                        "VALUES ('" + pUsuario + "', '" + pPass + "');"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	}
	
	/**
	 * Intenta iniciar sesion dado un usuario y una contraseña.
	 * @param pUsuario
	 * @param pPass
	 * @return
	 */
	public boolean iniciarSesion(String pUsuario, String pPass) {
		boolean inicioExitoso = false;
		if (this.existeUsuario(pUsuario, pPass)) {
			Juego.getJuego().setUsuarioSesion(pUsuario);
			inicioExitoso = true;
		}
		return inicioExitoso;
	}
	
	/**
	 * Dado un usuario devuelve true si existe, false si no existe.
	 * @param pUsuario
	 * @return
	 */
	public boolean existeUsuario(String pUsuario) {
		boolean existe = false;
		 try {
		      stmt = conn.createStatement();
		      String sql = "SELECT * FROM usuarios WHERE usuario='" + pUsuario + "';";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while ( rs.next() && !existe ) {
		    	  existe = true;
		      }
		      rs.close();
		      stmt.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		 return existe;
	}
	
	/**
	 * Devuelve true si existe un usuario con el pass dado.
	 * @param pUsuario
	 * @param pPass
	 * @return
	 */
	public boolean existeUsuario(String pUsuario, String pPass) {
		boolean existe = false;
		 try {
		      stmt = conn.createStatement();
		      String sql = "SELECT * FROM usuarios WHERE usuario='" + pUsuario + "' AND pass='" + pPass + "';";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      while ( rs.next() && !existe ) {
		    	  existe = true;
		      }
		      rs.close();
		      stmt.close();
		   } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		   }
		 return existe;
	}
	
	/**
	 * Inserta una nueva puntuacion al ranking, inserta la fecha automaticamente.
	 * @param pUsuario
	 * @param pPuntos
	 */
	public void addPuntuacion(String pUsuario, int pPuntos) {
		try {
			 Date ahora = new Date();
			 SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd");
			 String fecha = format.format(ahora);

	         String sql = "INSERT INTO ranking (usuario,puntos,fecha) " +
	               "VALUES ('" + pUsuario + "', " + pPuntos + ", '" + fecha +"');"; 

	         stmt.executeUpdate(sql);

	         stmt.close();
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	}
	
	/**
	 * Finaliza la conexion con la base de datos.
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Abre una conexion a la base de datos.
	 * @throws SQLException 
	 */
	public void connect() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
			conn.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Devuelve un String en formato JSON con el contenido del ranking
	 * ordenado por la puntuacion ascendentemente.
	 * @return
	 */
	public String obtenerRanking() {
		JSONArray listaPuntuaciones = new JSONArray();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM ranking ORDER BY puntos DESC;";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String usuario = rs.getString("usuario");
				int puntos = rs.getInt("puntos");
				String fecha = rs.getString("fecha");
				listaPuntuaciones.put(new JSONObject().put("usuario", usuario)
						.put("puntos", puntos)
						.put("fecha", fecha));
			}
			rs.close();
			stmt.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}

		JSONObject resultado = new JSONObject();
		resultado.put("ranking", listaPuntuaciones);

		return resultado.toString(2);
	}

}
