package es.pildoras.conexionHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.- Crear SessionFactory
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();
				
		// 2.- Crear obj Session
		Session miSession=miFactory.openSession();
		
		// 3.- Crear obj (Clientes)
		try {
			miSession.beginTransaction();
			// Colsulta de Clientes
			List<Clientes> losClientes=miSession.createQuery("from Clientes").getResultList();
			// Mostrar los clientes
			recorreClientesConsultados(losClientes);
			// Consulta dame los Bojorquez
			losClientes=miSession.createQuery("from Clientes cl where cl.apellidos='Bojorquez'").getResultList();
			recorreClientesConsultados(losClientes);	
			// Muestra los que viven en Moreras 208 o se apellidan Jacobo
			losClientes=miSession.createQuery("from Clientes cl where cl.apellidos='Bojorquez'"+
			" or cl.direccion='Corullon 189'").getResultList();
			recorreClientesConsultados(losClientes);
			// Commit
			miSession.getTransaction().commit();
			// Cerrar la sesion
			miSession.close();
		}finally {
			miFactory.close();
		}
	}

	private static void recorreClientesConsultados(List<Clientes> losClientes) {
		for(Clientes unCliente:losClientes) {
			System.out.println(unCliente);
		}
	}

}
