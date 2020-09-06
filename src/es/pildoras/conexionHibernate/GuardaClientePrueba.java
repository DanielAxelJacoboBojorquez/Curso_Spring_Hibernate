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
			Clientes cliente1=new Clientes("Alex","Vazquez","Golla");
			miSession.beginTransaction();
			// 4.- Ejecutar trasacción SQL
			miSession.save(cliente1);
			miSession.getTransaction().commit();
			System.out.println("Registro insertado correctamente en BBDD");
			// Lectura de registro
			miSession.beginTransaction();
			System.out.println("Lectura del registro con ID: "+cliente1.getId());
			Clientes clienteInsertado=miSession.get(Clientes.class, cliente1.getId());
			System.out.println("Registro: "+clienteInsertado);
			miSession.getTransaction().commit();
			System.out.println(" Terminado!");
			miSession.close();
		}finally {
			miFactory.close();
		}
	}

}
