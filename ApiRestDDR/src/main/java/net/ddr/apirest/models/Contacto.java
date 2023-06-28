package net.ddr.apirest.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contacto")
	private Long idContacto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido_p")
	private String apellidoP;
	
	@Column(name="apellido_m")
	private String apellidoM;
	
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_direccion")
	private Direccion direccion;
	
	
	public Long getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(Long idContacto) {
		this.idContacto = idContacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}
