package net.ddr.apirest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="direccion")
public class Direccion{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_direccion")
	private Long idDireccion;
	
	@Column(name="calle")
	private String calle;
	
	@Column(name="colonia")
	private String colonia;
	
	@Column(name="numero")
	private Integer numero;
	
	@Column(name="codigo_postal")
	private String codigoPostal;


	public Long getIdDireccion() {
		return idDireccion;
	}


	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getColonia() {
		return colonia;
	}


	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	

}
