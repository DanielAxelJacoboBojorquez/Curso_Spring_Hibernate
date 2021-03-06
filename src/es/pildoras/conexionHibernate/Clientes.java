package es.pildoras.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Clientes {
	// 1.- Generar Constructor sin parametros y con parametros excepto Id
	public Clientes(String nombre, String apellidos, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}
	
	public Clientes() {
	}
	
	// 2.- Generar Getters y Setters de los parametros
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//3.- Crear un m�todo ToString
	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Apellidos")
	private String apellidos;
	@Column(name="Direccion")
	private String direccion;
}
