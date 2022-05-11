package co.edu.ufps.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador {

	
	@Id
	private Integer id_administrador;
	
	private String correo;
	
	private String clave;

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(Integer id_administrador, String correo, String clave) {
		super();
		this.id_administrador = id_administrador;
		this.correo = correo;
		this.clave = clave;
	}

	public Integer getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(Integer id_administrador) {
		this.id_administrador = id_administrador;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Administrador [id_administrador=" + id_administrador + ", correo=" + correo + ", clave=" + clave + "]";
	}

	
	
	
}
