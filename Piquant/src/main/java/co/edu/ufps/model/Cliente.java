package co.edu.ufps.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	private String documento;
	
	private String nombre;
	
	private String apellido;
	
	private String correo;
	
	@OneToOne
	@JoinColumn(name="direccion")
	private Direccion direccion;
	
	@OneToMany(mappedBy = "cliente")
	private List<Compra>compras;
	
	private String clave;
	
	private String celular;


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Cliente(String documento, String nombre, String apellido, String correo, Direccion direccion, String clave,
			String celular) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.direccion = direccion;
		this.clave = clave;
		this.celular = celular;
	}



	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Direccion getDireccion() {
		return direccion;
	}


	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}	



	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	





	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	@Override
	public String toString() {
		return "Cliente [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", correo="
				+ correo + ", direccion=" + direccion + ", clave=" + clave + ", celular=" + celular + "]";
	}





	
	
	
}
