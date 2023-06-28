package net.ddr.apirest.vo;




public class DireccionVo {
	
	private Long idDireccion;
	private String calle;
	private String colonia;
	private Integer numero;
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
