package es.pildoras.pruebasHibernate;

import java.sql.*;

public class PruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl="jdbc:mysql://localhost:3306/pruebasHibernate?useSSL=false";
		String usuario="root";
		String contra="";
		try {
			System.out.println("Intentado conectar con la BDDD:" + jdbcUrl);
			Connection miConexion=DriverManager.getConnection(jdbcUrl,usuario,contra);
			System.out.println("Conexión Exitosa!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
