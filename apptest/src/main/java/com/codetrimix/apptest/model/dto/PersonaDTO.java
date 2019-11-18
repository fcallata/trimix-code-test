package com.codetrimix.apptest.model.dto;

public class PersonaDTO {
	
	private Long perId;
	private String perFechaNacimiento;
	private String perApellido;
	private String perNombre;
	private String perTipoDocumento;
	private Long perNumeroDocumento;
	public Long getPerId() {
		return perId;
	}
	public void setPerId(Long perId) {
		this.perId = perId;
	}
	public String getPerFechaNacimiento() {
		return perFechaNacimiento;
	}
	public void setPerFechaNacimiento(String perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}
	public String getPerApellido() {
		return perApellido;
	}
	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}
	public String getPerNombre() {
		return perNombre;
	}
	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}
	public String getPerTipoDocumento() {
		return perTipoDocumento;
	}
	public void setPerTipoDocumento(String perTipoDocumento) {
		this.perTipoDocumento = perTipoDocumento;
	}
	public Long getPerNumeroDocumento() {
		return perNumeroDocumento;
	}
	public void setPerNumeroDocumento(Long perNumeroDocumento) {
		this.perNumeroDocumento = perNumeroDocumento;
	}
	
}
