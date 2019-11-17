package com.codetrimix.apptest.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetrimix.apptest.model.dao.PersonaDAO;
import com.codetrimix.apptest.model.dominio.Persona;
import com.codetrimix.apptest.service.PersonaService;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDao;

	@Override
	public void add(Persona persona) {		 
		personaDao.add(persona);
	}

	@Override
	public void edit(Persona persona) {
		personaDao.edit(persona); 		
	}

	@Override
	public void delete(Long idPersona) {
		personaDao.delete(idPersona);
	}

	@Override
	public Persona getPersona(Long idPersona) {
		return personaDao.getPersona(idPersona);
	}

	@Override
	public List<Persona> getAll() {
		return personaDao.getAll();
	}

	@Override
	public List<Persona> getPersonasByFiltro(String nombre, String tipoDocumento) {
		return personaDao.getPersonasByFiltro(nombre, tipoDocumento);
	}
	
	

}
