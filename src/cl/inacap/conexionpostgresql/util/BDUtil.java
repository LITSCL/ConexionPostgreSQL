package cl.inacap.conexionpostgresql.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDUtil {
	private final String servidor = "localhost";
	private final String usuario = "postgres";
	private final String clave = "root";
	private final String baseDeDatos = "dbconexionpostgresql";
	private final int puerto = 5432;
	private Connection conexion;
	
	public Connection getConexion() {
		return conexion;
	}
	
	public boolean conectar() {
		try {
			String url = "jdbc:postgresql://" + servidor + ":" + puerto + "/" + baseDeDatos; 
			Class.forName("org.postgresql.Driver");
			this.conexion = DriverManager.getConnection(url, usuario, clave); 
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public void desconectar() {
		try {
			this.conexion.close();	
		} catch (Exception ex) {
			
		}
	}
} 
