package com.codetrimix.apptest.service;

import java.util.List;

import com.codetrimix.apptest.model.dominio.Persona;

public interface PersonaService {
	
	public void add(Persona persona);
	public void edit(Persona persona);
	public void delete(Long idPersona);
	public Persona getPersona(Long idPersona);
	public List<Persona> getAll();
}
