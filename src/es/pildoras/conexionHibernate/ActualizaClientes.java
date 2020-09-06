package es.pildoras.conexionHibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.- Crear SessionFactory
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		// 2.- Crear obj Session
		Session miSession=miFactory.openSession();
		
		// 3.- Crear obj (Clientes)
		try {
			//int ClienteId=1;
			miSession.beginTransaction();
			// Update Nombre
			//Clientes miCliente=miSession.get(Clientes.class, ClienteId);
			miSession.createQuery("delete Clientes where Direccion='Golla'").executeUpdate();
			// 4.- Ejecutar trasacción SQL
			miSession.getTransaction().commit();
			System.out.println("Registro eliminado correctamente en BBDD");
			miSession.close();
		}finally {
			miFactory.close();
		}
	}

}
