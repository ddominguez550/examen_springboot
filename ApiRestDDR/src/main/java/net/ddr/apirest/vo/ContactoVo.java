package net.ddr.apirest.vo;



public class ContactoVo {
	
	private Long idContacto;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private String telefono;
	private String email;
	private DireccionVo direccionVo;
	
	
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
	public DireccionVo getDireccionVo() {
		return direccionVo;
	}
	public void setDireccionVo(DireccionVo direccionVo) {
		this.direccionVo = direccionVo;
	}
	
	

}
