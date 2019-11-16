package com.codetrimix.apptest.model.dominio;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona", schema="trimix")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Long perId;
	@Column(name = "fec_nac")
	private LocalDate perFechaNacimiento;
	@Column(name = "apellido")
	private String perApellido;
	@Column(name = "nombre")
	private String perNombre;
	@Column(name = "tipo_documento")
	private String perTipoDocumento;
	@Column(name = "nro_documento")
	private Long perNumeroDocumento;
	
	public Long getPerId() {
		return perId;
	}
	public void setPerId(Long perId) {
		this.perId = perId;
	}
	public LocalDate getPerFechaNacimiento() {
		return perFechaNacimiento;
	}
	public void setPerFechaNacimiento(LocalDate perFechaNacimiento) {
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
