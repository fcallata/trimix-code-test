package com.codetrimix.apptest.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codetrimix.apptest.model.dao.PersonaDAO;
import com.codetrimix.apptest.model.dominio.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Persona persona) {		
		sessionFactory.getCurrentSession().save(persona);
	}

	@Override
	public void edit(Persona persona) {
		sessionFactory.getCurrentSession().update(persona);
	}

	@Override
	public void delete(Long idPersona) {
		sessionFactory.getCurrentSession().delete(getPersona(idPersona));
	}

	@Override
	public Persona getPersona(Long idPersona) {		
		return (Persona)sessionFactory.getCurrentSession().get(Persona.class, idPersona);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getAll() {
		Session session = sessionFactory.openSession();
		return (List<Persona>)session.createQuery("from Persona").getResultList();
	}
	

}
