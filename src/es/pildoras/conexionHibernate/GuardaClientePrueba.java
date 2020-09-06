package es.pildoras.conexionHibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class GuardaClientePrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.- Crear SessionFactory
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
		
		// 2.- Crear obj Session
		Session miSession=miFactory.openSession();
		
		// 3.- Crear obj (Clientes)
		try {
			Clientes cliente1=new Clientes("Axel","Jacobo","Corullon 189");
			miSession.beginTransaction();
			// 4.- Ejecutar trasacción SQL
			miSession.save(cliente1);
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");
			miSession.close();
		}finally {
			miFactory.close();
		}
	}

}
