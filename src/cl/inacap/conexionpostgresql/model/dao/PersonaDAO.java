package cl.inacap.conexionpostgresql.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cl.inacap.conexionpostgresql.model.dto.Persona;
import cl.inacap.conexionpostgresql.util.BDUtil;

public class PersonaDAO {
	private BDUtil bdUtil = new BDUtil();
	
	public boolean save(Persona p) {
		boolean resultado;
		try {
			//1. Conectarse a la base de datos.
			bdUtil.conectar();
			System.out.println("Conexión a la DB: " + bdUtil.conectar());
			//2. Definir la sentencia sql (INSERT).
			String sql = "INSERT INTO persona(nombre, edad) VALUES(?, ?)"; //Los ID autoincrementales no van aca, ya que el dbms asigna su valor.
			Connection co = bdUtil.getConexion(); 
			PreparedStatement st = co.prepareStatement(sql);
			st.setString(1, p.getNombre());
			st.setInt(2, p.getEdad());
			//3. Ejecutar el SQL.
			st.executeUpdate();
			resultado = true;
			System.out.println("Ejecución del SQL: " + resultado);
		} catch (Exception ex) {
			resultado = false;
			System.out.println("Ejecución del SQL: " + resultado);
			//4. Desconectarse.
		} finally { 
			bdUtil.desconectar(); 
		}
		return resultado;
	}
}
